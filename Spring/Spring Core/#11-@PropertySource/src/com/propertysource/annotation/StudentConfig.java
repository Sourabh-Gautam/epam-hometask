package com.propertysource.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.propertysource.annotation")
@PropertySource("classpath:com/propertysource/annotation/student-info.properties")
public class StudentConfig {

}
