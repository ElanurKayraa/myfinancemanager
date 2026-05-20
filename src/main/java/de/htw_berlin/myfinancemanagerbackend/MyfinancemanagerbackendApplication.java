package de.htw_berlin.myfinancemanagerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.htw_berlin.myfinancemanagerbackend")
public class MyfinancemanagerbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfinancemanagerbackendApplication.class, args);
	}
}
