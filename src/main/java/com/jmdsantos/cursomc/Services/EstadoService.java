package com.jmdsantos.cursomc.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdsantos.cursomc.domain.Estado;
import com.jmdsantos.cursomc.repositories.EstadoRepository;


@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll(){
		return repo.findAllByOrderByNome();
	}
	
}
