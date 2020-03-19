package br.com.OPT_WEB_002.unidade_negocio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.OPT_WEB_002.empresa.Empresa;


@Entity(name = "unidade_negocio")
public class Unidade_Negocio implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message = "código unidade é obrigatório!")
	private Integer cod_unidade;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	
	public Unidade_Negocio (){
		
		Empresa empresa = new Empresa();
		this.cod_empresa = empresa;
	}


	public Integer getCod_unidade() {
		return cod_unidade;
	}


	public void setCod_unidade(Integer cod_unidade) {
		this.cod_unidade = cod_unidade;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Empresa getCod_empresa() {
		return cod_empresa;
	}


	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Unidade_Negocio other = (Unidade_Negocio) obj;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (cod_unidade == null) {
			if (other.cod_unidade != null)
				return false;
		} else if (!cod_unidade.equals(other.cod_unidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	

}
