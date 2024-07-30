package com.Hyeonjin.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Precision {
    public int value() default 2;

    public int val() default 2;
}
