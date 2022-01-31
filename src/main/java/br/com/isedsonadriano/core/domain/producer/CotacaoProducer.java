package br.com.isedsonadriano.core.domain.producer;

import br.com.isedsonadriano.core.domain.Cotacao;

public interface CotacaoProducer {

	public void enviar(Cotacao cotacao);

}
