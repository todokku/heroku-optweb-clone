package br.com.OPT_WEB_002.usuario_tipo_documento;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;
import br.com.OPT_WEB_002.usuario.Usuario;

@Entity(name = "usuario_tipo_documento")
public class Usuario_Tipo_Documento implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id_usuario_tipo_doc;
	
	@OneToOne()
	@JoinColumn(name = "id_usuario", nullable = true)
	private Usuario id_usuario;
	
	@ManyToOne()
	@JoinColumn(name = "id_tipo_doc", nullable = true)
	private Tipo_Documento id_tipo_doc;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_empresa", nullable = false)
	private Empresa cod_empresa;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_filial", nullable = false)
	private Filial cod_filial;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_unidade", nullable = false)
	private Unidade_Negocio cod_unidade;
	
	private String cod_campo;
	
	private String conteudo;
	
	public Usuario_Tipo_Documento(){
		
		Usuario usuario = new Usuario();
		Tipo_Documento tipo_documento = new Tipo_Documento();
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		
		
		this.id_tipo_doc = tipo_documento;
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_usuario = usuario;
	}

	public BigInteger getId_usuario_tipo_doc() {
		return id_usuario_tipo_doc;
	}

	public void setId_usuario_tipo_doc(BigInteger id_usuario_tipo_doc) {
		this.id_usuario_tipo_doc = id_usuario_tipo_doc;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_documento(Tipo_Documento id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
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
		result = prime * result + ((cod_campo == null) ? 0 : cod_campo.hashCode());
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((id_usuario_tipo_doc == null) ? 0 : id_usuario_tipo_doc.hashCode());
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
		Usuario_Tipo_Documento other = (Usuario_Tipo_Documento) obj;
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
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (id_usuario_tipo_doc == null) {
			if (other.id_usuario_tipo_doc != null)
				return false;
		} else if (!id_usuario_tipo_doc.equals(other.id_usuario_tipo_doc))
			return false;
		return true;
	}

	public String getCod_campo() {
		return cod_campo;
	}

	public void setCod_campo(String cod_campo) {
		this.cod_campo = cod_campo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
