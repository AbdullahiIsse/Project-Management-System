package com.ai.projectmanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {



    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.ai.projectmanagement.controller..*)")

    public void definePackagePointcuts(){

        // empty method just to name the location specified in the pointcut


    }

    // joinpoint a point during the execution of your program
   @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp)  {

        log.debug(" \n \n \n ");
        log.debug("*********** Before Method Execution *************** \n {}. {} () with arguments [s] ={}",jp.getSignature().getDeclaringTypeName()
                ,jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("___________________________________________________________ \n \n \n");


       Object o = null;
       try {
           o = jp.proceed();
       } catch (Throwable e) {
           e.printStackTrace();
       }
       log.debug(" \n \n \n ");
       log.debug("*********** After Method Execution *************** \n {}. {} () with arguments [s] ={}",jp.getSignature().getDeclaringTypeName()
               ,jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
       log.debug("___________________________________________________________ \n \n \n");

       return o;

   }


}
