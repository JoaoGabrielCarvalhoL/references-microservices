package br.com.carv.mscreditassessor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emissao-cartoes}")
    private String emissaoCartoes;

    @Bean
    public Queue queueEmissaoCartoes() {
        return new Queue(emissaoCartoes, true);
    }


}
