package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringQdoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQdoxApplication.class, args);
                new QDoxAnalizer().runAnalysis();
	}
}
