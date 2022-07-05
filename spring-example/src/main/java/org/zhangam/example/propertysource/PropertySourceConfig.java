package org.zhangam.example.propertysource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/5
 */
@Configuration
@PropertySource(value = {"classpath:propertysource/test.yaml"}, factory = YamlPropertySourceFactory.class)
@ComponentScan("org.zhangam.example.propertysource")
public class PropertySourceConfig {


}