package br.com.alura.AplicacaoScreenmatch;

import br.com.alura.AplicacaoScreenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
