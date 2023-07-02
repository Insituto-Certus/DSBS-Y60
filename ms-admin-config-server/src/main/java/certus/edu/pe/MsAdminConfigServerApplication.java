package certus.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//config server
@EnableConfigServer
@SpringBootApplication
public class MsAdminConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminConfigServerApplication.class, args);
	}

}
