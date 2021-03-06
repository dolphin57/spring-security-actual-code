package io.dolphin.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @create 2019 07 20 18:25
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* io.dolphin.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is" + arg);
        }
        Long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        System.out.println("time aspect 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return proceed;
    }
}
