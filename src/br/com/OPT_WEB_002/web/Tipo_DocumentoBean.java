package br.com.OPT_WEB_002.web;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.*;
import br.com.OPT_WEB_002.unidade_negocio.*;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;

@javax.faces.bean.ManagedBean(name="tipoDocumentoBean")
@ViewScoped
public class Tipo_DocumentoBean implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Tipo_Documento tipo_Documento;
	private Tipo_Documento tipo_DocumentoSelecionado;
	private List<Tipo_Documento> lista;
	private LazyDataModel<Tipo_Documento> lazymodel;
	private Usuario usuario = new Usuario();
	private BigInteger id_tipo_doc;
	private Empresa empresa = new Empresa();
	private Filial filial = new Filial();
	private Unidade_Negocio unidade_negocio = new Unidade_Negocio();
	private Tipo_DocumentoRN tipo_DocumentoRN;

	
	@PostConstruct
	public void init(){
		
		this.tipo_Documento = new Tipo_Documento();				
		
	}
	
	public Tipo_Documento iniciar(Usuario usuario){
			
	
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();
		
		
		this.tipo_Documento.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
		this.tipo_Documento.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
		this.tipo_Documento.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
						
		if(id_tipo_doc == null){
										
			return this.tipo_Documento;
						
		}else{
	
			this.tipo_Documento = tipo_DocumentoRN.carregarPorIdTiDocCoDEmCodFiCodUni(id_tipo_doc,usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
			
			return this.tipo_Documento;
		}				
	}
	
	public String salvar(){
		
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();
				
		if(id_tipo_doc == null){

		try {
			            	    
			tipo_DocumentoRN.salvar(this.tipo_Documento);			
			return "/restrito/tipo_documento/tipo_documento.xhtml?faces-redirect=true";
			
		} catch (DAOException e) {
			
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}	
		}else{
					
	
			tipo_DocumentoRN.alterar(this.tipo_Documento);		
			return "/restrito/tipo_documento/tipo_documento.xhtml?faces-redirect=true";
		}
		
		
	}
	
	public Tipo_Documento carregar(BigInteger id_tipo_doc){
		
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();
		
		this.tipo_Documento = tipo_DocumentoRN.carregar(id_tipo_doc);
		
		return this.tipo_Documento;
		
	}
	
	public String novo(){
				
		return "/restrito/tipo_documento/cadastro_tipo_documento.xhtml?faces-redirect=true";
		
	}
	
	public String alterar(){
			
		return "/restrito/tipo_documento/cadastro_tipo_documento.xhtml?id=" + this.tipo_DocumentoSelecionado.getId_tipo_doc() + "faces-redirect=true";
		
	}
	

	public String excluir(){
		
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();	
			
		try {
			
			this.tipo_Documento = tipo_DocumentoRN.carregarPorIdTiDocCoDEmCodFiCodUni(tipo_DocumentoSelecionado.getId_tipo_doc(),tipo_DocumentoSelecionado.getCod_empresa().getCod_empresa(),tipo_DocumentoSelecionado.getCod_filial().getCod_filial(),tipo_DocumentoSelecionado.getCod_unidade().getCod_unidade());
			tipo_DocumentoRN.excluir(this.tipo_Documento);		
			return "/restrito/tipo_documento/tipo_documento.xhtml?faces-redirect=true";
			
		} catch (DAOException e) {
			
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}
	}
	
	
	public List<Tipo_Documento> listarPorCodEmCodFiCodUni(Usuario usuario){
		
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();		
		
		try{

			return tipo_DocumentoRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
			
		}
		
		}
	
	public List<Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc,Usuario usuario){
		
		tipo_DocumentoRN = null;
		tipo_DocumentoRN = new Tipo_DocumentoRN();
				
		return tipo_DocumentoRN.listarPorIdTipoDoc(id_tipo_doc,usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		
	}
	

	public boolean desabilitarCampos() {

		if (id_tipo_doc != null) {

			return true;
		}

		return false;
	}
	
	
	public Tipo_Documento descricaoTipoDoc(BigInteger id_tipo_doc){
		
		Tipo_DocumentoRN tipo_DocumentoRN = new Tipo_DocumentoRN();			
		return tipo_DocumentoRN.carregar(id_tipo_doc);
		
	}
	

	
	public Tipo_Documento getTipo_Documento() {
		return tipo_Documento;
	}

	public void setTipo_Documento(Tipo_Documento tipo_Documento) {
		this.tipo_Documento = tipo_Documento;
	}

	public Tipo_Documento getTipo_DocumentoSelecionado() {
		return tipo_DocumentoSelecionado;
	}

	public void setTipo_DocumentoSelecionado(Tipo_Documento tipo_DocumentoSelecionado) {
		this.tipo_DocumentoSelecionado = tipo_DocumentoSelecionado;
	}

	public List<Tipo_Documento> getLista() {
		return lista;
	}

	public void setLista(List<Tipo_Documento> lista) {
		this.lista = lista;
	}

	public LazyDataModel<Tipo_Documento> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Tipo_Documento> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public BigInteger getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(BigInteger id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Unidade_Negocio getUnidade_negocio() {
		return unidade_negocio;
	}

	public void setUnidade_negocio(Unidade_Negocio unidade_negocio) {
		this.unidade_negocio = unidade_negocio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Tipo_DocumentoRN getTipo_DocumentoRN() {
		return tipo_DocumentoRN;
	}

	public void setTipo_DocumentoRN(Tipo_DocumentoRN tipo_DocumentoRN) {
		this.tipo_DocumentoRN = tipo_DocumentoRN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((tipo_Documento == null) ? 0 : tipo_Documento.hashCode());
		result = prime * result + ((tipo_DocumentoSelecionado == null) ? 0 : tipo_DocumentoSelecionado.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Tipo_DocumentoBean other = (Tipo_DocumentoBean) obj;
		if (lazymodel == null) {
			if (other.lazymodel != null)
				return false;
		} else if (!lazymodel.equals(other.lazymodel))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (tipo_Documento == null) {
			if (other.tipo_Documento != null)
				return false;
		} else if (!tipo_Documento.equals(other.tipo_Documento))
			return false;
		if (tipo_DocumentoSelecionado == null) {
			if (other.tipo_DocumentoSelecionado != null)
				return false;
		} else if (!tipo_DocumentoSelecionado.equals(other.tipo_DocumentoSelecionado))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
