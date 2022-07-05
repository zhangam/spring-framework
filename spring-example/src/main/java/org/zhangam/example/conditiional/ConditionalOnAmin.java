package org.zhangam.example.conditiional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author zhangamin
 * @date 2022/7/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnAminCondition.class)
public @interface ConditionalOnAmin {

}
