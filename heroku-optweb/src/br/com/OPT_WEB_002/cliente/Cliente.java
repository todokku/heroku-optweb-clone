package br.com.OPT_WEB_002.cliente;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.OPT_WEB_002.empresa.Empresa;

@Entity(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id_cliente;
	
	private String descricao;
	
	@Column(unique = true)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	
	public Cliente() {
	
	Empresa empresa = new Empresa();	
		
		this.cod_empresa = empresa;
		
		
	}


	public BigInteger getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(BigInteger id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		return true;
	}


	public Empresa getCod_empresa() {
		return cod_empresa;
	}


	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


}
