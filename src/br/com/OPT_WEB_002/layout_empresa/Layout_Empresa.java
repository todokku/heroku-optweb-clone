package br.com.OPT_WEB_002.layout_empresa;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;


@Entity(name = "layout_empresa")
public class Layout_Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger id_layout;	
	
	private String cod_campo;

	private String descricao;	
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_doc")
	private Tipo_Documento id_tipo_doc;
	
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne
	@JoinColumn(name="cod_unidade")
	private Unidade_Negocio cod_unidade;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean flag_campo;	
	
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean flagCampos;	
	
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean filtro;	
	
	private String valor_filtro;
	
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean qrcode;	
				
	private Integer sequencia;
	
	public Layout_Empresa (){
		
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Tipo_Documento tipo_Documento = new Tipo_Documento();
		
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_tipo_doc = tipo_Documento;
				
	}

	public BigInteger getId_layout() {
		return id_layout;
	}

	public void setId_layout(BigInteger id_layout) {
		this.id_layout = id_layout;
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

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Tipo_Documento id_tipo_doc) {
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

	public boolean isFlag_campo() {
		return flag_campo;
	}

	public void setFlag_campo(boolean flag_campo) {
		this.flag_campo = flag_campo;
	}

	public boolean isFlagCampos() {
		return flagCampos;
	}

	public void setFlagCampos(boolean flagCampos) {
		this.flagCampos = flagCampos;
	}

	public boolean isFiltro() {
		return filtro;
	}

	public void setFiltro(boolean filtro) {
		this.filtro = filtro;
	}

	public String getValor_filtro() {
		return valor_filtro;
	}

	public void setValor_filtro(String valor_filtro) {
		this.valor_filtro = valor_filtro;
	}

	public boolean isQrcode() {
		return qrcode;
	}

	public void setQrcode(boolean qrcode) {
		this.qrcode = qrcode;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + (filtro ? 1231 : 1237);
		result = prime * result + (flagCampos ? 1231 : 1237);
		result = prime * result + (flag_campo ? 1231 : 1237);
		result = prime * result + ((id_layout == null) ? 0 : id_layout.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());
		result = prime * result + (qrcode ? 1231 : 1237);
		result = prime * result + ((sequencia == null) ? 0 : sequencia.hashCode());
		result = prime * result + ((valor_filtro == null) ? 0 : valor_filtro.hashCode());
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
		Layout_Empresa other = (Layout_Empresa) obj;
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
		if (filtro != other.filtro)
			return false;
		if (flagCampos != other.flagCampos)
			return false;
		if (flag_campo != other.flag_campo)
			return false;
		if (id_layout == null) {
			if (other.id_layout != null)
				return false;
		} else if (!id_layout.equals(other.id_layout))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		if (qrcode != other.qrcode)
			return false;
		if (sequencia == null) {
			if (other.sequencia != null)
				return false;
		} else if (!sequencia.equals(other.sequencia))
			return false;
		if (valor_filtro == null) {
			if (other.valor_filtro != null)
				return false;
		} else if (!valor_filtro.equals(other.valor_filtro))
			return false;
		return true;
	}


	
}