package com.Hyeonjin.web.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 주석에는 생명주기가 있다.
// 언제까지 생성할 것인지 작성해야한다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transient {

}