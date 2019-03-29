package pl.ms.SafeDriving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
public class SafeDrivingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeDrivingApplication.class, args);
	}

}
