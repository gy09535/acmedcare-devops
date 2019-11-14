package com.acmedcare.framework.devops.endpoint;

import com.acmedcare.framework.devops.Dto.CenterServiceQueryDto;
import com.acmedcare.framework.devops.bean.CenterService;
import com.acmedcare.framework.devops.bean.ServiceInstance;
import com.acmedcare.framework.devops.common.MyPage;
import com.acmedcare.framework.devops.endpoint.service.CenterServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "获取服务信息")
@RequestMapping("/services")
public class CenterServiceEndpoint {

  final CenterServiceImp serviceImp;

  public CenterServiceEndpoint(
      CenterServiceImp serviceImp) {
    this.serviceImp = serviceImp;
  }

  @GetMapping
  @ApiOperation("获取所有服务列表")
  public ResponseEntity<MyPage<CenterService>> getService(CenterServiceQueryDto serviceQueryDto) {

    return ResponseEntity.ok(serviceImp.getService(serviceQueryDto));
  }

  @GetMapping("/instances")
  public ResponseEntity<MyPage<ServiceInstance>> getServiceInstances(
      CenterServiceQueryDto serviceQueryDto) {

    return ResponseEntity.ok(serviceImp.getServiceInstance(serviceQueryDto));
  }

  @PostMapping("/command/{instanceId}")
  public ResponseEntity command(@PathVariable Long instanceId,
      @ApiParam("状态") @RequestParam ServiceInstance.Status status) {

    serviceImp.sendCommand(instanceId, status);
    return ResponseEntity.ok().build();
  }
}
