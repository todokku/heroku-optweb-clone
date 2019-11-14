package br.com.OPT_WEB_002.grupo_valores_possiveis_doc;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.grupo_valores.Grupo_Valores;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;


@Entity(name = "grupo_valores_possiveis_doc")
public class Grupo_Valores_Possiveis_Doc {

	@Id
	private BigInteger id_grup_val_pos_doc;	
	
	@OneToOne
	@JoinColumn(name = "id_grupo_valores",nullable = false)
	private Grupo_Valores id_grupo_valores;
	
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne
	@JoinColumn(name = "cod_unidade")
	private Unidade_Negocio cod_unidade;
		
	private String valor_possivel;
	
	public Grupo_Valores_Possiveis_Doc() {
		
		Grupo_Valores grupo_Valores = new Grupo_Valores();	
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
			
		
		this.id_grupo_valores = grupo_Valores;	
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
	}

	public BigInteger getId_grup_val_pos_doc() {
		return id_grup_val_pos_doc;
	}

	public void setId_grup_val_pos_doc(BigInteger id_grup_val_pos_doc) {
		this.id_grup_val_pos_doc = id_grup_val_pos_doc;
	}

	public Grupo_Valores getId_grupo_valores() {
		return id_grupo_valores;
	}

	public void setId_grupo_valores(Grupo_Valores id_grupo_valores) {
		this.id_grupo_valores = id_grupo_valores;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());			
		result = prime * result + ((id_grup_val_pos_doc == null) ? 0 : id_grup_val_pos_doc.hashCode());
		result = prime * result + ((id_grupo_valores == null) ? 0 : id_grupo_valores.hashCode());
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
		Grupo_Valores_Possiveis_Doc other = (Grupo_Valores_Possiveis_Doc) obj;
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
		if (id_grup_val_pos_doc == null) {
			if (other.id_grup_val_pos_doc != null)
				return false;
		} else if (!id_grup_val_pos_doc.equals(other.id_grup_val_pos_doc))
			return false;
		if (id_grupo_valores == null) {
			if (other.id_grupo_valores != null)
				return false;
		} else if (!id_grupo_valores.equals(other.id_grupo_valores))
			return false;
		return true;
	}

	public String getValor_possivel() {
		return valor_possivel;
	}

	public void setValor_possivel(String valor_possivel) {
		this.valor_possivel = valor_possivel;
	}
	
}
