package tn.esprit.spring.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {
    @After("execution(void tn.esprit.spring.services.*.*(..))")
    public void logMethodExit1(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("Le nom de méthode:" + name+":");
    }
}
