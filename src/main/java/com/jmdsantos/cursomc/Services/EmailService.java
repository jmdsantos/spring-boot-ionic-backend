package com.jmdsantos.cursomc.Services;

import org.springframework.mail.SimpleMailMessage;

import com.jmdsantos.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
