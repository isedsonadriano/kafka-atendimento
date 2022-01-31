package br.com.isedsonadriano.producer;

import br.com.isedsonadriano.core.domain.Cotacao;

public interface CotacaoProducer {

	public void enviar(Cotacao cotacao);

}
