package com.acmedcare.framework.starter.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = ConditionalOnControlEnabled.ACMEDCARE_CONTROL_ENABLED,
    matchIfMissing = true)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ConditionalOnControlEnabled {

  String ACMEDCARE_CONTROL_ENABLED = "acmedcare.devops.enabled";
}