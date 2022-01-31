package br.com.isedsonadriano.core.domain.service.implementation;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.isedsonadriano.core.domain.Cotacao;
import br.com.isedsonadriano.core.domain.entity.Atendimento;
import br.com.isedsonadriano.core.domain.service.AtendimentoService;
import br.com.isedsonadriano.infra.repository.AtendimentoRepository;
import br.com.isedsonadriano.producer.CotacaoProducer;

public class AtendimentoServiceImpl implements AtendimentoService {

	@Autowired
	private CotacaoProducer cotacaoProducer;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Override
	@Transactional
	public void save(Atendimento atendimento) {
		
		this.atendimentoRepository.save(atendimento);
		
		if(atendimento.isGeraCotacao()) {
			Cotacao cotacao = new Cotacao();
			cotacao.setIdAtendimento(atendimento.getId());
			cotacao.setServicos( atendimento.getServicos().stream().map(s -> new String(s.getDescricao())).collect(Collectors.toList()));
			this.cotacaoProducer.enviar(cotacao);
		}
		
	}

}
