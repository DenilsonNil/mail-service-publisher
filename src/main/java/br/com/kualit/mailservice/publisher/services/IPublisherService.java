package br.com.kualit.mailservice.publisher.services;

import br.com.kualit.mailservice.publisher.dto.EmailDTO;

public interface IPublisherService {
    public String sendEmail(EmailDTO dto);
}
