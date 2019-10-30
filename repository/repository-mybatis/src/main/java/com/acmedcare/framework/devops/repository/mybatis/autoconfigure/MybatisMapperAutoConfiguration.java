package com.acmedcare.framework.devops.repository.mybatis.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link MybatisMapperAutoConfiguration}
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2019-03-12.
 */
@Configuration
@MapperScan({"com.acmedcare.framework.devops.repository"})
public class MybatisMapperAutoConfiguration {}
