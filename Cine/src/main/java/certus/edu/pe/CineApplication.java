package certus.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // habilitar el client
@SpringBootApplication
public class CineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineApplication.class, args);
	}

}
