package br.com.OPT_WEB_002.filial;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.OPT_WEB_002.empresa.Empresa;

@Entity(name = "filial")
public class Filial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@NotNull(message = "código filial é obrigatório!")
	private Integer cod_filial;

	private String descricao;
		
	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;

	public Filial(){
		
		Empresa empresa = new Empresa();
		this.cod_empresa = empresa;
		
		
	}

	public Integer getCod_filial() {
		return cod_filial;
	}

	public void setCod_filial(Integer cod_filial) {
		this.cod_filial = cod_filial;
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
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
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
		Filial other = (Filial) obj;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (cod_filial == null) {
			if (other.cod_filial != null)
				return false;
		} else if (!cod_filial.equals(other.cod_filial))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
		
	
}
