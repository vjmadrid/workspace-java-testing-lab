package com.acme.testing.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.testing.api.constant.ComponentScanConfigConstant;

@Configuration
@ComponentScan(basePackages = { ComponentScanConfigConstant.GENERIC_PACKAGE })
public class ComponentScanConfig {

}
