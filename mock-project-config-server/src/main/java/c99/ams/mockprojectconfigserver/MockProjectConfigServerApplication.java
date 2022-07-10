package c99.ams.mockprojectconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MockProjectConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockProjectConfigServerApplication.class, args);
	}

}
