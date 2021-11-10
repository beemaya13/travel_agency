package com.mnilga.travel.agency.application.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class Logging {

    private static final Logger LOGGER = LogManager.getLogger(Logging.class);

    @Pointcut("within(com.mnilga.travel.agency.application..*)")
    public void callAtMyServicePublic() {
    }

//    @Around("callAtMyServicePublic()")
//    public Object aroundCallAt(ProceedingJoinPoint call) throws Throwable {
//        StopWatch clock = new StopWatch(call.toString());
//        LOGGER.info(clock);
//        return call.proceed();
//    }

    @Before("callAtMyServicePublic()")
    public void aroundCallAt(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        LOGGER.info("before " + jp + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        LOGGER.info("after " + jp.toString());
    }
}