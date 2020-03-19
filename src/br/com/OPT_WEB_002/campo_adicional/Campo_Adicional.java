package br.com.OPT_WEB_002.campo_adicional;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.grupo_valores.Grupo_Valores;
import br.com.OPT_WEB_002.transacao.Transacao;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@Entity(name = "campo_adicional")
public class Campo_Adicional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id_camp_adic;

	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne()
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne()
	@JoinColumn(name = "cod_unidade")
	private Unidade_Negocio cod_unidade;

	private String cod_campo;

	private String descricao;

	@Column(nullable = true)
	private String observacao;

	@ManyToOne()
	@JoinColumn(name = "id_transacao")
	private Transacao id_transacao;

	@OneToOne
	@JoinColumn(name = "id_grupo_valores", nullable = true)
	private Grupo_Valores id_grupo_Valores;

	public Campo_Adicional() {

		Transacao transacao = new Transacao();

		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();

		Grupo_Valores grupo_Valores = new Grupo_Valores();

		this.id_transacao = transacao;
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_grupo_Valores = grupo_Valores;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_campo == null) ? 0 : cod_campo.hashCode());
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_camp_adic == null) ? 0 : id_camp_adic.hashCode());
		result = prime * result + ((id_grupo_Valores == null) ? 0 : id_grupo_Valores.hashCode());
		result = prime * result + ((id_transacao == null) ? 0 : id_transacao.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		Campo_Adicional other = (Campo_Adicional) obj;
		if (cod_campo == null) {
			if (other.cod_campo != null)
				return false;
		} else if (!cod_campo.equals(other.cod_campo))
			return false;
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
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_camp_adic == null) {
			if (other.id_camp_adic != null)
				return false;
		} else if (!id_camp_adic.equals(other.id_camp_adic))
			return false;
		if (id_grupo_Valores == null) {
			if (other.id_grupo_Valores != null)
				return false;
		} else if (!id_grupo_Valores.equals(other.id_grupo_Valores))
			return false;
		if (id_transacao == null) {
			if (other.id_transacao != null)
				return false;
		} else if (!id_transacao.equals(other.id_transacao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}

	public BigInteger getId_camp_adic() {
		return id_camp_adic;
	}

	public void setId_camp_adic(BigInteger id_camp_adic) {
		this.id_camp_adic = id_camp_adic;
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

	public String getCod_campo() {
		return cod_campo;
	}

	public void setCod_campo(String cod_campo) {
		this.cod_campo = cod_campo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Transacao getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Transacao id_transacao) {
		this.id_transacao = id_transacao;
	}

	public Grupo_Valores getId_grupo_Valores() {
		return id_grupo_Valores;
	}

	public void setId_grupo_Valores(Grupo_Valores id_grupo_Valores) {
		this.id_grupo_Valores = id_grupo_Valores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
