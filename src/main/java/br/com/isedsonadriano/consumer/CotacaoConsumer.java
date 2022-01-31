package br.com.isedsonadriano.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import br.com.isedsonadriano.core.domain.Cotacao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class CotacaoConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, Cotacao> record, Acknowledgment ack) {

    	Cotacao cotacao = record.value();

        log.info("Mensagem consumida " + cotacao.toString());

    }
}
