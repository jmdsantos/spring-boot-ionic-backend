package com.jmdsantos.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmdsantos.cursomc.domain.Categoria;
import com.jmdsantos.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Transactional(readOnly=true)
	//Com uso de query
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome,@Param("categorias") List<Categoria> categoria, Pageable pageRequest);
	
	@Transactional(readOnly=true)
	//Com o uso dos nomes do framework
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome,List<Categoria> categoria, Pageable pageRequest);
	
}
