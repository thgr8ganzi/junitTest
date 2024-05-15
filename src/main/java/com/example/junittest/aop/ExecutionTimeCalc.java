package com.example.junittest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ExecutionTimeCalc {
    @Pointcut("execution(* fact*(..))") // 메소드 이름이 fact 로 시작하는 메소드
    private void publicTarget() {
    }
    @Around("publicTarget()") // Advice
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed(); // Target, fact 연산
        long end = System.nanoTime();
        Signature sig = joinPoint.getSignature();
        System.out.printf(
                "%s.%s(%s) 실행 시간 : %d\n",
                joinPoint.getTarget().getClass().getSimpleName(),
                sig.getName(),
                Arrays.toString(joinPoint.getArgs()),
                (end - start)
                );
        return result;
    }
}
