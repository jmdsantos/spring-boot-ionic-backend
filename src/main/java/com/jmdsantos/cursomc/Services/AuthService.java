package com.jmdsantos.cursomc.Services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jmdsantos.cursomc.Services.exceptions.ObjectNotFoundException;
import com.jmdsantos.cursomc.domain.Cliente;
import com.jmdsantos.cursomc.repositories.ClienteRepository;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {
		Optional<Cliente> obj = clienteRepository.findByEmail(email);
		
		Cliente cliente = obj.get();
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}

		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);

	}

	private String newPassword() {
		char[] vet = new char[10];

		for (int i = 0; i < 10; i++) {
			vet[i] = randowChar();
		}

		return new String(vet);
	}

	private char randowChar() {
		int opt = rand.nextInt(3);

		if (opt == 0) { //gera um digito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) {//gera  letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { //gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
		
	}
}
