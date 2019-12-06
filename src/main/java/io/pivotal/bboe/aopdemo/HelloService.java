package io.pivotal.bboe.aopdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HelloService {

    Logger logger = LoggerFactory.getLogger(HelloService.class);

    @PleaseLogThisCall
    public String sayHello(String toWho) {

        if(logger.isDebugEnabled()) {
            logger.debug("Lots of debugging stuff " + toWho.toString());
        }



        return "Hello " + toWho;
    }

    @PleaseLogThisCall
    public String simpleHello() {
        return "Hello World!";
    }
}
