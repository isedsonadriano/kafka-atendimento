package br.com.isedsonadriano.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.isedsonadriano.core.domain.producer.CotacaoProducer;
import br.com.isedsonadriano.core.domain.producer.implementation.CotacaoProducerImpl;

@Configuration
public class CotacaoProducerConfiguration {

	@Bean
	public CotacaoProducer buildCotacaoProducer() {
		return new CotacaoProducerImpl();
	}
}
