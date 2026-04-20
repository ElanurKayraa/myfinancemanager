package de.htw_berlin.myfinancemanagerbackend;
//Startseite der App
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //kommmuniziert spring, dass hier die app startet
public class MyfinancemanagerbackendApplication {

	public static void main(String[] args) { //Einstiegspunkt der App, ab hier läuft es auf localhost
		SpringApplication.run(MyfinancemanagerbackendApplication.class, args);
	}

}
