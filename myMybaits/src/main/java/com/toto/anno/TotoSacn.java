package com.toto.anno;

import com.toto.registrar.TotoBDRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解：注册BeanDefinition
 */
@Retention(RetentionPolicy.RUNTIME)
@Import({TotoBDRegistrar.class})
public @interface TotoSacn {
}
