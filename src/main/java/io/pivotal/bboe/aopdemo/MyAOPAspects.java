package io.pivotal.bboe.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAOPAspects {

    @Before("execution(String io.pivotal.bboe.aopdemo.HelloService.simpleHello())")
    public void beforeSimpleHello(JoinPoint joinPoint) {
        System.out.println("Calling SimpleHello - " + joinPoint);
    }

    @AfterReturning(pointcut = "execution(String io.pivotal.bboe.aopdemo.HelloService.simpleHello())", returning="retVal")
    public void afterSimpleHello(JoinPoint joinPoint, Object retVal) {
        System.out.println("After SimpleHello - " + joinPoint + " result: " + retVal);
    }

    @Around("execution(String io.pivotal.bboe.aopdemo.HelloService.sayHello(..))")
    public Object handleRegularHelloWorld(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around " + pjp);

        //Modify args
        Object[] newArgs = new Object[]{"AOP Modified: " + pjp.getArgs()[0]};

        //Run call
        Object result = pjp.proceed(newArgs);

        System.out.println("Result: " + result);
        return result;
    }

    @AfterReturning(pointcut = "@annotation(io.pivotal.bboe.aopdemo.PleaseLogThisCall)", returning="result")
    public void logCall(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint + ": \"" + result + "\"");
    }


}
