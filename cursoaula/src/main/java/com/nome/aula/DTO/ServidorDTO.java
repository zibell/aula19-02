package com.nome.aula.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nome.aula.entity.ServidorEntity;

public class ServidorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	
	@Email(message = "Email inválido")
	private String email;
	
	
	public ServidorDTO() {}
	
	public ServidorDTO(ServidorEntity obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	//getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
