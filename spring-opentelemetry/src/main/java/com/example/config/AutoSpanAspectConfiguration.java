package com.example.config;

import io.opentelemetry.api.GlobalOpenTelemetry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
@Configuration
public class AutoSpanAspectConfiguration {

    /**
     * @Service, @Repository, @Component에 Span을 추가한다.
     */
    @Around("@within(org.springframework.stereotype.Service) || " +
            "@within(org.springframework.stereotype.Repository) || " +
            "@within(org.springframework.stereotype.Component)")
    public Object createSpan(ProceedingJoinPoint joinPoint) throws Throwable {
        var signature = joinPoint.getSignature();
        var classFullPath = signature.getDeclaringType().getName(); // e.g.) com.example.api.ExampleService
        var methodName = signature.getName();

        var tracer = GlobalOpenTelemetry.getTracer("api-trace");
        var span = tracer.spanBuilder(classFullPath + "." + methodName).startSpan();

        /** {@link io.opentelemetry.context.Scope} MUST BE CLOSED */
        try (var scope = span.makeCurrent()) {
            return joinPoint.proceed();
        } finally {
            span.end();
        }
    }
}
