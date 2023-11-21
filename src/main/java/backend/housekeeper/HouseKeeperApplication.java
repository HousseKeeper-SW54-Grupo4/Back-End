package backend.housekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"backend.housekeeper.houseelegantservice"})
public class HouseKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseKeeperApplication.class, args);
	}

}
