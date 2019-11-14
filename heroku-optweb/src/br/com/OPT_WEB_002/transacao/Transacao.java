package br.com.OPT_WEB_002.transacao;

import java.io.Serializable;
import java.math.BigInteger;

import java.util.List;
import javax.persistence.*;

import br.com.OPT_WEB_002.campo_adicional.Campo_Adicional;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@Entity(name = "transacao")
public class Transacao implements Serializable {

		
	private static final long serialVersionUID = 1L;
	@Id		
	private BigInteger id_transacao;

	private String descricao;
		
	@ManyToOne
	@JoinColumn(name="cod_empresa")
	
	private Empresa cod_empresa;
		
	@ManyToOne
	@JoinColumn(name="cod_filial")
	private Filial cod_filial;
			
	@ManyToOne
	@JoinColumn(name="cod_unidade")
	private Unidade_Negocio cod_unidade;
	
	@OneToMany(mappedBy = "id_transacao")
	private List<Campo_Adicional> campo_Adicional;
	
	private String unidade_tempo;
		
	private float quantidade;
							  
	private float tempo_operacao;
    
	@Column(columnDefinition = "BOOLEAN",nullable = false,insertable = true)
    private Boolean tratamento_tempo;
	
	public Transacao() {
		
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		
	}

	public BigInteger getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(BigInteger id_transacao) {
		this.id_transacao = id_transacao;
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

	public List<Campo_Adicional> getCampo_Adicional() {
		return campo_Adicional;
	}

	public void setCampo_Adicional(List<Campo_Adicional> campo_Adicional) {
		this.campo_Adicional = campo_Adicional;
	}

	public String getUnidade_tempo() {
		return unidade_tempo;
	}

	public void setUnidade_tempo(String unidade_tempo) {
		this.unidade_tempo = unidade_tempo;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getTempo_operacao() {
		return tempo_operacao;
	}

	public void setTempo_operacao(float tempo_operacao) {
		this.tempo_operacao = tempo_operacao;
	}

	public Boolean getTratamento_tempo() {
		return tratamento_tempo;
	}

	public void setTratamento_tempo(Boolean tratamento_tempo) {
		this.tratamento_tempo = tratamento_tempo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo_Adicional == null) ? 0 : campo_Adicional.hashCode());
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id_transacao == null) ? 0 : id_transacao.hashCode());
		result = prime * result + Float.floatToIntBits(quantidade);
		result = prime * result + Float.floatToIntBits(tempo_operacao);
		result = prime * result + ((tratamento_tempo == null) ? 0 : tratamento_tempo.hashCode());
		result = prime * result + ((unidade_tempo == null) ? 0 : unidade_tempo.hashCode());
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
		Transacao other = (Transacao) obj;
		if (campo_Adicional == null) {
			if (other.campo_Adicional != null)
				return false;
		} else if (!campo_Adicional.equals(other.campo_Adicional))
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
		if (id_transacao == null) {
			if (other.id_transacao != null)
				return false;
		} else if (!id_transacao.equals(other.id_transacao))
			return false;
		if (Float.floatToIntBits(quantidade) != Float.floatToIntBits(other.quantidade))
			return false;
		if (Float.floatToIntBits(tempo_operacao) != Float.floatToIntBits(other.tempo_operacao))
			return false;
		if (tratamento_tempo == null) {
			if (other.tratamento_tempo != null)
				return false;
		} else if (!tratamento_tempo.equals(other.tratamento_tempo))
			return false;
		if (unidade_tempo == null) {
			if (other.unidade_tempo != null)
				return false;
		} else if (!unidade_tempo.equals(other.unidade_tempo))
			return false;
		return true;
	}

	

}
