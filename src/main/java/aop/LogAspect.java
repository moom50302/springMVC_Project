package main.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	/* do only for file under controller package. */
    @Pointcut("execution(* main.java.controller.*.* (..))")
    private void log(){
    	logger.info("Entering Logger");
    	System.out.println("Entering Logger");
    }
    
    /* do for controller and its sub-package file. */
    @Pointcut("within(main.java.controller..*)")
    private void log2(){
    	logger.info("Entering Logger");
    	System.out.println("Entering Logger");
    }
    
    @Before("log()")
    public void before(JoinPoint joinPoint){
        
    	CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

    	logger.info("呼叫方法:"+codeSignature.getName());

        String [] getP = codeSignature.getParameterNames();
        Object [] getV = joinPoint.getArgs();
        for(int i = 0;i<getP.length;i++) {
        	logger.info("帶入參數:" + getP[i]+"  值:" + getV[i].toString());
        }
    }

    @AfterReturning(pointcut = "log()",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
    	logger.info("返回參數:" + result.toString());
    }
    
    @Before("log2()")
    public void before2(JoinPoint joinPoint){
        
    	CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

    	logger.info("呼叫方法:"+codeSignature.getName());

        String [] getP = codeSignature.getParameterNames();
        Object [] getV = joinPoint.getArgs();
        for(int i = 0;i<getP.length;i++) {
        	logger.info("帶入參數:" + getP[i]+"  值:" + getV[i].toString());
        }
    }

    @AfterReturning(pointcut = "log2()",returning = "result")
    public void after2(JoinPoint joinPoint,Object result){
    	logger.info("返回參數:" + result.toString());
    }
}
