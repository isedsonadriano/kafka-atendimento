package br.com.isedsonadriano.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.isedsonadriano.core.domain.service.AtendimentoService;
import br.com.isedsonadriano.core.domain.service.implementation.AtendimentoServiceImpl;

@Configuration
public class AtendimentoServicoConfiguration {

	@Bean
	public AtendimentoService buildAtendimentoService() {
		return new AtendimentoServiceImpl();
	}
}
