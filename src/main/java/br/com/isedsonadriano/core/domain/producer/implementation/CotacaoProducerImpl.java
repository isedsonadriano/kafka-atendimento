package br.com.isedsonadriano.core.domain.producer.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import br.com.isedsonadriano.core.domain.Cotacao;
import br.com.isedsonadriano.core.domain.producer.CotacaoProducer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class CotacaoProducerImpl implements CotacaoProducer {
	
	@Autowired
	private KafkaTemplate<String, Cotacao> kafkaTemplate;

	@Value("${topico}")
	private String topico;
	
	@Override
	public void enviar(Cotacao cotacao) {
		kafkaTemplate.send(this.topico, cotacao).addCallback(
				success -> log.info("mensagem enviada com sucesso"),
				failure -> log.error("Falha ao enviar mensagem!"));
	}

}
