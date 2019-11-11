package com.acmedcare.framework.devops.endpoint.center;


import com.acmedcare.framework.boot.snowflake.Snowflake;
import com.acmedcare.framework.devops.bean.CenterHeartbeat;
import com.acmedcare.framework.devops.bean.CenterService;
import com.acmedcare.framework.devops.bean.ServiceInstance;
import com.acmedcare.framework.devops.bean.ServiceInstance.Status;
import com.acmedcare.framework.devops.endpoint.center.ControllerCenterGrpc.ControllerCenterImplBase;
import com.acmedcare.framework.devops.repository.HeartBeatRepository;
import com.acmedcare.framework.devops.repository.ServiceInstanceRepository;
import com.acmedcare.framework.devops.repository.ServiceRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Date;
import java.util.List;

public class ControlCenterGrpc extends ControllerCenterImplBase {

  final ServiceRepository serviceRepository;

  final HeartBeatRepository heartBeatRepository;
  final ServiceInstanceRepository instanceRepository;
  final Snowflake snowflake;

  public ControlCenterGrpc(
      ServiceRepository serviceRepository,
      HeartBeatRepository heartBeatRepository,
      ServiceInstanceRepository instanceRepository,
      Snowflake snowflake) {
    this.serviceRepository = serviceRepository;
    this.heartBeatRepository = heartBeatRepository;
    this.instanceRepository = instanceRepository;
    this.snowflake = snowflake;
  }

  /**
   * <pre>
   * Sends a greeting
   * </pre>
   */
  public void registerService(Service request,
      io.grpc.stub.StreamObserver<Result> responseObserver) {

    QueryWrapper<CenterService> serviceQueryWrapper = new QueryWrapper<>();
    serviceQueryWrapper.eq("service_name", request.getName());
    List<CenterService> services = serviceRepository.selectList(serviceQueryWrapper);
    if (services.isEmpty()) {

      CenterService centerService = new CenterService();
      centerService.setServiceName(request.getName());
      centerService.setClusterCount(1);
      centerService.setInstanceCount(1);
      centerService.setHealthInstanceCount(1);
      centerService.setServiceId(snowflake.nextId());
      serviceRepository.insert(centerService);
    }

    //查询服务实例是否存在
    CenterService centerService = services.get(0);
    QueryWrapper<ServiceInstance> instanceQueryWrapper = new QueryWrapper<>();
    instanceQueryWrapper.eq("service_name", centerService.getServiceName());
    instanceQueryWrapper.eq("ip", request.getIp());
    instanceQueryWrapper.eq("port", request.getPort());
    List<ServiceInstance> serviceInstances = instanceRepository.selectList(instanceQueryWrapper);

    ServiceInstance serviceInstance;
    if (serviceInstances.isEmpty()) {

      //不存在实例则直接新增一个
      serviceInstance = new ServiceInstance();
      serviceInstance.setAlive(true);
      serviceInstance.setServiceName(request.getName());
      serviceInstance.setIp(request.getIp());
      serviceInstance.setInstanceId(snowflake.nextId());
      serviceInstance.setPort(request.getPort());
      serviceInstance.setLastHeartTime(new Date());
      serviceInstance.setStatus(Status.Start);
      instanceRepository.insert(serviceInstance);
    } else {

      //存在实例直接更新实例状态为已注册
      serviceInstance = serviceInstances.get(0);
      serviceInstance.setAlive(true);
      instanceRepository.updateById(serviceInstance);
    }

    //更新服务集群数量
    instanceQueryWrapper = new QueryWrapper<>();
    instanceQueryWrapper.eq("service_name", centerService.getServiceName());
    serviceInstances = instanceRepository.selectList(instanceQueryWrapper);
    centerService.setInstanceCount(serviceInstances.size());
    centerService
        .setHealthInstanceCount((int) serviceInstances.stream().filter(f -> f.isAlive()).count());

    serviceRepository.updateById(centerService);
    Result result = Result.newBuilder()
        .setSuccess(true)
        .setData("").build();
    responseObserver.onNext(result);
    responseObserver.onCompleted();
  }

  /**
   *
   */
  public void reportHeartBeat(HeartBeat request,
      io.grpc.stub.StreamObserver<Result> responseObserver) {

    // 写入心跳
    CenterHeartbeat heartBeat = new CenterHeartbeat();
    heartBeat.setServiceName(request.getServiceName());
    heartBeat.setIp(request.getIp());
    heartBeat.setHeartbeatId(snowflake.nextId());
    heartBeat.setFailCount(request.getFailCount());
    heartBeat.setSuccessCount(request.getSuccessCount());
    heartBeat.setTime(new Date(request.getCurrentTime()));
    heartBeatRepository.insert(heartBeat);

    //判定服务健康状态
    QueryWrapper<ServiceInstance> instanceQueryWrapper = new QueryWrapper<>();
    instanceQueryWrapper.eq("service_name", request.getServiceName());
    instanceQueryWrapper.eq("ip", request.getIp());
    List<ServiceInstance> serviceInstances = instanceRepository.selectList(instanceQueryWrapper);
    if (serviceInstances.isEmpty()) {
      return;
    }

    ServiceInstance serviceInstance = serviceInstances.get(0);
    int total = heartBeat.getSuccessCount() + heartBeat.getFailCount();
    if (total == 0) {
      serviceInstance.setAlive(false);
    } else {

      int per = (heartBeat.getSuccessCount() * 100) / total;
      if (per > 70) {
        //如果服务超过百分之70成功则认为成功
        serviceInstance.setAlive(true);
      } else {
        serviceInstance.setAlive(false);
      }
    }

    instanceRepository.updateById(serviceInstance);
    Result result = Result.newBuilder()
        .setSuccess(true)
        .setData("").build();
    responseObserver.onNext(result);
    responseObserver.onCompleted();
  }
}
