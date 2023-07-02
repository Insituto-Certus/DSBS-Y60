package pe.edu.alcale.solutions.java.sb.msadminregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Registry Server
@EnableEurekaServer
@SpringBootApplication
public class MsAdminRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdminRegistryServerApplication.class, args);
	}

}
