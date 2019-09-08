package com.toto.config;

import com.toto.anno.TotoSacn;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置信息
 */
@Configuration
@ComponentScan("com.toto")
@TotoSacn
public class Appconfig {
}
