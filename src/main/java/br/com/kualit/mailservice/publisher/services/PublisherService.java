package br.com.kualit.mailservice.publisher.services;

import br.com.kualit.mailservice.publisher.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class PublisherService implements IPublisherService {
    Logger logger = LoggerFactory.getLogger(PublisherService.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Override
    public String sendEmail(EmailDTO dto) {

        try {
            //rabbitTemplate.convertAndSend(queue, dto);
            rabbitTemplate.convertAndSend(exchange, "", dto);
            return "The email has sent";

        } catch (Exception e) {
            var message = e.getMessage();
            logger.info(message);
            return message;
        }
    }
}
