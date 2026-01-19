package br.com.dragos.ArquiteturaSpring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ArquiteturaSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(ArquiteturaSpringApplication.class, args);

		//FAZ O MESMO QUE A LINHA DE CIMA
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaSpringApplication.class);
		//builder.run(args);

		//DESABILITA O BANNER NA INICIALIZAÇÃO DA APLICAÇÃO
		builder.bannerMode(Banner.Mode.OFF);

		//RECUPERA O CONTEXTO DA APLICAÇÃO
		ConfigurableApplicationContext context = builder.context();
		var produtoRepository = context.getBean("produtoRepository");

		// DEFINE O PROFILE
		builder.profiles("producao");

		//INICIA A APLICAÇÃO COM AS CONFIGURAÇÕES
		builder.run(args);

		//DEFINE PROPERTIES
		SpringApplicationBuilder properties = builder.properties("spring.datasource.url=jdbc");

		//RECUPERA O VAOR DA VARIAVEL NO ARQUIVO (APPLICATION.PROPERTIES)
		ConfigurableEnvironment environment = context.getEnvironment();
		String property = environment.getProperty("spring.application.name");
		System.out.println(property);
	}

}


