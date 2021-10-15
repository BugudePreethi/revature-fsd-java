package com.revature.springlearn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Before(value = "execution(* com.revature.springlearn.*.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info("Start {}", joinPoint.getSignature().toShortString());
    }

    @After(value = "execution(* com.revature.springlearn.*.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        LOGGER.info("End {}", joinPoint.getSignature().toShortString());
    }
    
    // Point Cut  - The expression given as part of value of @Before 
    //              and @After annotation
    
    // @Before    - To be executed before execution of a method
    
    // @After     - To be executed after execution of a method
    
    // Expression - Expression expression of what package, class and 
    //              method for which the code execution needs to be 
    //              targeted
    // 1st (*)    - Represents the access specifier of the method
    // 2nd (*)    - Represents a package under "springlearn" package
    // 3rd (*)    - Represents a class
    // 4th (*)    - Represents a method
    // (..)       - Represents a method with zero or more parameters
    
    // Advice     - What needs to be done when the execution pattern 
    //              matches
    
    // Join Point - The specific instance of where the match is found.
    //              This contains the details about the matching method.
}