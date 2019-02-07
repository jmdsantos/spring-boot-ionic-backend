package com.jmdsantos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmdsantos.cursomc.domain.Produto;

@Repository
public interface ProtudoRepository extends JpaRepository<Produto, Integer>{

}
