package com.acmedcare.framework.devops.endpoint;

import com.acmedcare.framework.devops.bean.ServiceInstance;
import com.acmedcare.framework.devops.repository.ServiceInstanceRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ServiceHealthCheck extends ServiceImpl<ServiceInstanceRepository, ServiceInstance> {


  @Scheduled(fixedDelay = 10000)
  public void CheckService() {

    try {
      //检查所有活着但是没有心跳的服务是否真的存活，如果不存活则直接打死
      QueryWrapper<ServiceInstance> instanceQueryWrapper = new QueryWrapper<>();
      instanceQueryWrapper.eq("alive", true);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new Date());
      calendar.add(Calendar.MINUTE, -2);
      instanceQueryWrapper.lt("last_heart_time", calendar.getTime());
      List<ServiceInstance> serviceInstances = getBaseMapper().selectList(instanceQueryWrapper);

      RestTemplate restTemplate = new RestTemplate();
      serviceInstances.forEach(c -> {
        String url = String.format("http://%s:%s/actuator/health", c.getIp(), c.getPort());
        try {
          String data = restTemplate.getForObject(url, String.class);
          if (!data.contains("UP")) {
            c.setAlive(false);
          }
        } catch (Exception e) {
          log.error("服务:" + c.getServiceName() + "监控检查失败" + e.getMessage());
          c.setAlive(false);
        }
      });

      if (!serviceInstances.isEmpty()) {
        updateBatchById(serviceInstances);
      }
    } catch (Exception e) {
      log.error("执行服务健康检查发生错误!", e);
    }
  }
}
