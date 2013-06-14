package br.feevale.physis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.enums.RequestType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
	
	public RequestMethod[] methods() default {};
	
	public RequestType type() default RequestType.ANY;
	
	public boolean sessionRequired() default true;
}
