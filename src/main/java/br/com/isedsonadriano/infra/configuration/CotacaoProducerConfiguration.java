package br.com.isedsonadriano.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.isedsonadriano.producer.CotacaoProducer;
import br.com.isedsonadriano.producer.implementation.CotacaoProducerImpl;

@Configuration
public class CotacaoProducerConfiguration {

	@Bean
	public CotacaoProducer buildCotacaoProducer() {
		return new CotacaoProducerImpl();
	}
}
