package br.com.alura.AplicacaoScreenmatch;

import br.com.alura.AplicacaoScreenmatch.principal.Principal;
import br.com.alura.AplicacaoScreenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoScreenmatchApplication {


	public static void main(String[] args) {
		SpringApplication.run(AplicacaoScreenmatchApplication.class, args);
	}

}
