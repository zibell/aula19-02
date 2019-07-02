package com.marcelo.aula.apicard.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcelo.aula.apicard.entity.CartaEntity;

@Repository
public interface CartaDAO extends JpaRepository<CartaEntity, Integer>{
	
	@Query("SELECT obj FROM CartaEntity obj WHERE obj.nomeCard LIKE %:nomeCard%")
	Page<CartaEntity> search(@Param("nomeCard") String nomeCard, Pageable pageable);
}
/**obj*/