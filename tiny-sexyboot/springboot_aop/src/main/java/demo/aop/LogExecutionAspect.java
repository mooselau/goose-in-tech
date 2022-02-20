package demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogExecutionAspect {

    @Before("@annotation(LogExecution)")
    public void loginExecutionBefore(JoinPoint jp) {
        LOGGER.info("===> Before LogExecution {}", jp);
    }

    @Around("@annotation(LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("===> Do LogExecution in @Around..");
        long start = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.info("===> " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return ret;
    }

}
