package P3.Archery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ArcheryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcheryApplication.class, args);
	}

}