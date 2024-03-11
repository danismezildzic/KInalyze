package at.htlleonding.Kinalyze;

import at.htlleonding.Kinalyze.Controller.FileController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"at.htlleonding.Kinalyze.Controller", "at.htlleonding.Kinalyze.Service"})
public class KinalyzeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinalyzeApplication.class, args);
	}

}
