package br.com.OPT_WEB_002.val_campos_doc;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.grupo_valores.Grupo_Valores;
import br.com.OPT_WEB_002.layout_empresa.Layout_Empresa;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@Entity(name = "val_campos_doc")
public class Val_Campos_Doc implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id
	@Column()
	private BigInteger id_val_campos_doc;
	
	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne()
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne()
	@JoinColumn(name = "cod_unidade")
	private Unidade_Negocio cod_unidade;
			
	@OneToOne
	@JoinColumn(name = "id_tipo_doc")
	private Tipo_Documento id_tipo_doc;
	
	@OneToOne
	@JoinColumn(name = "id_layout_tipo_doc")
	private Layout_Empresa id_layout_tipo_doc;
	
	@OneToOne
	@JoinColumn(name = "id_grupo_valores")
	private Grupo_Valores id_grupo_Valores;
		
	private String valor_possivel;
			
	public Val_Campos_Doc() {
	
		Layout_Empresa layout_Empresa = new Layout_Empresa();
		Tipo_Documento tipo_Documento = new Tipo_Documento();
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Grupo_Valores grupo_Valores = new Grupo_Valores();
		
		this.id_layout_tipo_doc = layout_Empresa;
		this.id_tipo_doc = tipo_Documento;
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_grupo_Valores = grupo_Valores;
	}

	public BigInteger getId_val_campos_doc() {
		return id_val_campos_doc;
	}

	public void setId_val_campos_doc(BigInteger id_val_campos_doc) {
		this.id_val_campos_doc = id_val_campos_doc;
	}

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Tipo_Documento id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public Layout_Empresa getId_layout_tipo_doc() {
		return id_layout_tipo_doc;
	}

	public void setId_layout_tipo_doc(Layout_Empresa id_layout_tipo_doc) {
		this.id_layout_tipo_doc = id_layout_tipo_doc;
	}

	public String getValor_possivel() {
		return valor_possivel;
	}

	public void setValor_possivel(String valor_possivel) {
		this.valor_possivel = valor_possivel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Grupo_Valores getId_grupo_Valores() {
		return id_grupo_Valores;
	}

	public void setId_grupo_Valores(Grupo_Valores id_grupo_Valores) {
		this.id_grupo_Valores = id_grupo_Valores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((id_layout_tipo_doc == null) ? 0 : id_layout_tipo_doc.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());
		result = prime * result + ((id_val_campos_doc == null) ? 0 : id_val_campos_doc.hashCode());
		result = prime * result + ((valor_possivel == null) ? 0 : valor_possivel.hashCode());
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
		Val_Campos_Doc other = (Val_Campos_Doc) obj;
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
		if (id_layout_tipo_doc == null) {
			if (other.id_layout_tipo_doc != null)
				return false;
		} else if (!id_layout_tipo_doc.equals(other.id_layout_tipo_doc))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		if (id_val_campos_doc == null) {
			if (other.id_val_campos_doc != null)
				return false;
		} else if (!id_val_campos_doc.equals(other.id_val_campos_doc))
			return false;
		if (valor_possivel == null) {
			if (other.valor_possivel != null)
				return false;
		} else if (!valor_possivel.equals(other.valor_possivel))
			return false;
		return true;
	}

	

	

}
