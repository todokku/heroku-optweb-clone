package br.com.OPT_WEB_002.tipo_documento_transacao;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.transacao.Transacao;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

/**Tabela Tipo_Documento_Transaçao**/
@Entity(name="tipo_documento_transacao")
public class Tipo_Documento_Transacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id_tipo_doc_trans;
	
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne
	@JoinColumn(name="cod_unidade")
	private Unidade_Negocio cod_unidade;
	
	@OneToOne()
	@JoinColumn(name = "id_tipo_doc")
	private Tipo_Documento id_tipo_doc;
	
	@OneToOne()
	@JoinColumn(name = "id_transacao")
	private Transacao id_transacao;

	public Tipo_Documento_Transacao() {
		
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Tipo_Documento tipo_Documento = new Tipo_Documento();
		Transacao transacao = new Transacao();
				
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_tipo_doc = tipo_Documento;
		this.id_transacao = transacao;
		
		
	}

	public BigInteger getId_tipo_doc_trans() {
		return id_tipo_doc_trans;
	}

	public void setId_tipo_doc_trans(BigInteger id_tipo_doc_trans) {
		this.id_tipo_doc_trans = id_tipo_doc_trans;
	}

	public Empresa getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public Filial getCod_filial() {
		return cod_filial;
	}

	public void setCod_filial(Filial cod_filial) {
		this.cod_filial = cod_filial;
	}

	public Unidade_Negocio getCod_unidade() {
		return cod_unidade;
	}

	public void setCod_unidade(Unidade_Negocio cod_unidade) {
		this.cod_unidade = cod_unidade;
	}

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Tipo_Documento id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public Transacao getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Transacao id_transacao) {
		this.id_transacao = id_transacao;
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
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());
		result = prime * result + ((id_tipo_doc_trans == null) ? 0 : id_tipo_doc_trans.hashCode());
		result = prime * result + ((id_transacao == null) ? 0 : id_transacao.hashCode());
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
		Tipo_Documento_Transacao other = (Tipo_Documento_Transacao) obj;
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
		if (cod_unidade == null) {
			if (other.cod_unidade != null)
				return false;
		} else if (!cod_unidade.equals(other.cod_unidade))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		if (id_tipo_doc_trans == null) {
			if (other.id_tipo_doc_trans != null)
				return false;
		} else if (!id_tipo_doc_trans.equals(other.id_tipo_doc_trans))
			return false;
		if (id_transacao == null) {
			if (other.id_transacao != null)
				return false;
		} else if (!id_transacao.equals(other.id_transacao))
			return false;
		return true;
	}


	
}
