package org.zhangam.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.zhangam.example.demo.registrar.AminRegistrar;

/**
 * @author Live.InPast
 * @since  2022/6/3
 */
@ComponentScan("org.zhangam.example")
@Import(AminRegistrar.class)
public class AppConfig {

}
