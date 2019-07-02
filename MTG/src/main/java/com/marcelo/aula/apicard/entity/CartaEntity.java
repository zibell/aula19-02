package com.marcelo.aula.apicard.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartaEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeCard;
	private String custoCard;
	private String custoCMCCard;
	private String corCard;
	private String tipoCard;
	private String colecaoCard;
	
	public String getColecaoCard() {
		return colecaoCard;
	}
	public void setColecaoCard(String colecaoCard) {
		this.colecaoCard = colecaoCard;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeCard() {
		return nomeCard;
	}
	public void setNomeCard(String nomeCard) {
		this.nomeCard = nomeCard;
	}
	public String getCustoCard() {
		return custoCard;
	}
	public void setCustoCard(String custoCard) {
		this.custoCard = custoCard;
	}
	public String getCorCard() {
		return corCard;
	}
	public void setCorCard(String corCard) {
		this.corCard = corCard;
	}
	public String getTipoCard() {
		return tipoCard;
	}
	public void setTipoCard(String tipoCard) {
		this.tipoCard = tipoCard;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CartaEntity(String nomeCard, String custoCard, String corCard, String tipoCard) {
		super();
		this.nomeCard = nomeCard;
		this.custoCard = custoCard;
		this.corCard = corCard;
		this.tipoCard = tipoCard;
	}
	
	@Override
	public String toString() {
		return "CartaEntity [id=" + id + ", nomeCard=" + nomeCard + ", custoCard=" + custoCard + ", custoCMCCard="
				+ custoCMCCard + ", corCard=" + corCard + ", tipoCard=" + tipoCard + ", colecaoCard=" + colecaoCard
				+ "]";
	}
	public CartaEntity() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colecaoCard == null) ? 0 : colecaoCard.hashCode());
		result = prime * result + ((corCard == null) ? 0 : corCard.hashCode());
		result = prime * result + ((custoCard == null) ? 0 : custoCard.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeCard == null) ? 0 : nomeCard.hashCode());
		result = prime * result + ((tipoCard == null) ? 0 : tipoCard.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaEntity other = (CartaEntity) obj;
		if (colecaoCard == null) {
			if (other.colecaoCard != null)
				return false;
		} else if (!colecaoCard.equals(other.colecaoCard))
			return false;
		if (corCard == null) {
			if (other.corCard != null)
				return false;
		} else if (!corCard.equals(other.corCard))
			return false;
		if (custoCard == null) {
			if (other.custoCard != null)
				return false;
		} else if (!custoCard.equals(other.custoCard))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeCard == null) {
			if (other.nomeCard != null)
				return false;
		} else if (!nomeCard.equals(other.nomeCard))
			return false;
		if (tipoCard == null) {
			if (other.tipoCard != null)
				return false;
		} else if (!tipoCard.equals(other.tipoCard))
			return false;
		return true;
	}
	public String getCustoCMCCard() {
		return custoCMCCard;
	}
	public void setCustoCMCCard(String custoCMCCard) {
		this.custoCMCCard = custoCMCCard;
	}
	
	
	
	

	
	
}
