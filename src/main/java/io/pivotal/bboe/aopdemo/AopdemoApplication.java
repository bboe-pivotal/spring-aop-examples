package io.pivotal.bboe.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Component
	public static class CommandLineAppStartupRunner implements CommandLineRunner {
		private HelloService helloService;

		public CommandLineAppStartupRunner(HelloService helloService) {
			this.helloService = helloService;
		}

		@Override
		public void run(String...args) throws Exception {
			System.out.println("Hello Service implementation: " + helloService.getClass());
			System.out.println();

			System.out.println("Call Simple Hello World!");
			System.out.println(helloService.simpleHello());

			System.out.println();

			System.out.println("Call regular Hello World");
			System.out.println(helloService.sayHello("Freddie Mac"));
		}
	}
}




