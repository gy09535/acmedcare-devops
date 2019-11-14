package com.acmedcare.framework.devops.endpoint.service;

import com.acmedcare.framework.devops.Dto.CenterServiceQueryDto;
import com.acmedcare.framework.devops.bean.CenterService;
import com.acmedcare.framework.devops.bean.ServiceInstance;
import com.acmedcare.framework.devops.common.ConvertUtils;
import com.acmedcare.framework.devops.common.JacksonHelper;
import com.acmedcare.framework.devops.common.MyPage;
import com.acmedcare.framework.devops.repository.ServiceInstanceRepository;
import com.acmedcare.framework.devops.repository.ServiceRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.security.InvalidParameterException;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CenterServiceImp {

  final ServiceRepository serviceRepository;

  final ServiceInstanceRepository instanceRepository;

  final StringRedisTemplate stringRedisTemplate;
  final RabbitTemplate rabbitTemplate;

  public CenterServiceImp(
      ServiceRepository serviceRepository,
      ServiceInstanceRepository instanceRepository,
      StringRedisTemplate stringRedisTemplate,
      RabbitTemplate rabbitTemplate) {
    this.serviceRepository = serviceRepository;
    this.instanceRepository = instanceRepository;
    this.stringRedisTemplate = stringRedisTemplate;
    this.rabbitTemplate = rabbitTemplate;
  }

  public MyPage<CenterService> getService(CenterServiceQueryDto queryDto) {

    Page<CenterService> page = new Page<>(
        queryDto.getSize(), queryDto.getCurrPage(), 0);
    QueryWrapper<CenterService> queryWrapper = new QueryWrapper<>();
    if (!StringUtils.isEmpty(queryDto.getName())) {
      queryWrapper.like("service_name", queryDto.getName());
    }

    IPage<CenterService> data = serviceRepository.selectPage(page, queryWrapper);
    return ConvertUtils.convertPage(data);
  }

  public MyPage<ServiceInstance> getServiceInstance(CenterServiceQueryDto queryDto) {

    Page<ServiceInstance> page = new Page<>(
        queryDto.getSize(), queryDto.getCurrPage(), 0);
    QueryWrapper<ServiceInstance> queryWrapper = new QueryWrapper<>();
    if (!StringUtils.isEmpty(queryDto.getName())) {
      queryWrapper.eq("service_name", queryDto.getName());
    }

    MyPage<ServiceInstance> instancePage = ConvertUtils
        .convertPage(instanceRepository.selectPage(page, queryWrapper));
    if (instancePage.getList().isEmpty()) {

      return instancePage;
    }

    instancePage.getList().forEach(c -> {

      String alive = stringRedisTemplate.opsForValue()
          .get(String.format("%s:%s:%s", c.getServiceName(), c.getIp(),
              c.getPort()));
      if (!StringUtils.isEmpty(alive)) {
        c.setAlive(true);
      }
    });

    return instancePage;
  }

  public void sendCommand(Long instanceId, ServiceInstance.Status status) {

    ServiceInstance serviceInstance = instanceRepository.selectById(instanceId);
    if (serviceInstance == null) {
      throw new InvalidParameterException("服务实例不存在");
    }

    String topic = "acmedcare.control.topic";
    String route = String
        .format("%s.%s.%s:%s", topic, serviceInstance.getServiceName(), serviceInstance.getIp(),
            serviceInstance.getPort());

    Command command = new Command();
    command.setServiceName(serviceInstance.getServiceName());
    command.setServiceCommandType(status.ordinal());
    rabbitTemplate.convertAndSend(topic, route, JacksonHelper.objectToJson(command));
    serviceInstance.setStatus(status);
    instanceRepository.updateById(serviceInstance);
  }

  @Data
  class Command {

    int serviceCommandType;
    String serviceName;
  }
}
