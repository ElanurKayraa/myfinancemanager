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
//Feedback M2
//node models rausnehmen
//git ignore fehlt
//npm create projekt neu generieren
//clonen repo frontrend -lokal auf rechner, alles rauslöschen, löschen auch committen zu einem leeren repo
//dann von lokal nmp vue at latest aus dem ordner üer dem ordner des repo, danach meldung ordner nicht leer, dann neues projekt ins alte repo
//transaction list wieder reinschieben