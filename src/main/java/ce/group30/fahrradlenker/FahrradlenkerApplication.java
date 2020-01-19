package ce.group30.fahrradlenker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@SpringBootApplication
public class FahrradlenkerApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FahrradlenkerApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8080"));
		app.run(args);
	}


}
