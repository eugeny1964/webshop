package com.evgueny.webshop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogTimeAspect {

    //@Around("@annotation(com.evgueny.webshop.aspect.annotations.LogTime)")
    @Around(value = "execution(* com.evgueny.webshop.service.*.*(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) {
        long time1 = System.currentTimeMillis();
        Object proceed;
        try {
            proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        finally {
            long time2 = System.currentTimeMillis();
            System.out.println(joinPoint.getSignature().getName() + " отработал: " + (time2 - time1)+"ms");
        }
        return null;
    }


}
