package br.com.OPT_WEB_002.empresa;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "código empresa é obrigatório!")
	private Integer cod_empresa;
		
	private String descricao;
	
	@Lob	
	private byte[] logotipo;
	
	private String extensaoArq;
	
	private String nomeArq;
	
	private String corEmpresa;
	
	public Empresa(){}

	public Integer getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(Integer cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}

	public String getExtensaoArq() {
		return extensaoArq;
	}

	public void setExtensaoArq(String extensaoArq) {
		this.extensaoArq = extensaoArq;
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public String getCorEmpresa() {
		return corEmpresa;
	}

	public void setCorEmpresa(String corEmpresa) {
		this.corEmpresa = corEmpresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((corEmpresa == null) ? 0 : corEmpresa.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((extensaoArq == null) ? 0 : extensaoArq.hashCode());
		result = prime * result + Arrays.hashCode(logotipo);
		result = prime * result + ((nomeArq == null) ? 0 : nomeArq.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (corEmpresa == null) {
			if (other.corEmpresa != null)
				return false;
		} else if (!corEmpresa.equals(other.corEmpresa))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (extensaoArq == null) {
			if (other.extensaoArq != null)
				return false;
		} else if (!extensaoArq.equals(other.extensaoArq))
			return false;
		if (!Arrays.equals(logotipo, other.logotipo))
			return false;
		if (nomeArq == null) {
			if (other.nomeArq != null)
				return false;
		} else if (!nomeArq.equals(other.nomeArq))
			return false;
		return true;
	}
	
}