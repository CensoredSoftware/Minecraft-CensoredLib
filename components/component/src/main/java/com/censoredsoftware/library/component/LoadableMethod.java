package com.censoredsoftware.library.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoadableMethod
{
	LoadOrder loadOrder() default LoadOrder.BEFORE_PLUGIN;
}