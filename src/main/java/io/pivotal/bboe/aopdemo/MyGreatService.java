package io.pivotal.bboe.aopdemo;

import org.springframework.beans.factory.annotation.Autowired;

public class MyGreatService {
    private HelloService helloService;

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
