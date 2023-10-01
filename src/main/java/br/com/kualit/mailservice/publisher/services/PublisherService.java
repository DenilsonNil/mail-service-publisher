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
    @Value("${spring.rabbitmq.queue}")
    private String queue;
    @Override
    public String sendEmail(EmailDTO dto) {

        try {
            rabbitTemplate.convertAndSend(queue, dto);
            return "The email has sended";

        } catch (Exception e) {
            var message = e.getMessage();
            logger.info(message);
            return message;
        }
    }
}
