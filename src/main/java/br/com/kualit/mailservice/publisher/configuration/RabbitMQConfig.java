package br.com.kualit.mailservice.publisher.configuration;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //First Exchange
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchange);
    }

    //Dead letter exchange
    @Bean FanoutExchange fanoutExchangeDLQ() {
        return new FanoutExchange("mail-message-dlq");
    }
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connection){
        return new RabbitAdmin(connection);
    }

    @Bean
    public  Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }
}
