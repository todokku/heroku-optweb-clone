package br.com.OPT_WEB_002.web;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.tipo_documento_transacao.*;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;


@ManagedBean(name = "tipoDocTransBean")
@ViewScoped
public class Tipo_Documento_TransacaoBean {

	private Tipo_Documento_Transacao tipo_Documento_Transacao;
	private Tipo_Documento_Transacao tipo_Documento_TransacaoSelecionado;
	private List<Tipo_Documento_Transacao> lista;	
	private LazyDataModel<Tipo_Documento_Transacao> lazymodel;
	private Usuario usuario;
	private Tipo_Documento_TransacaoRN tipo_Documento_TransacaoRN;
	private UsuarioBean usuarioBean = new UsuarioBean();
				
	public Tipo_Documento_TransacaoBean(){}
	
	@PostConstruct
	public void init(){
		
		this.tipo_Documento_Transacao = new Tipo_Documento_Transacao();
		this.tipo_Documento_TransacaoSelecionado = new Tipo_Documento_Transacao();
		
		
	}

	public Tipo_Documento_Transacao iniciar(Usuario usuario){
			
		tipo_Documento_TransacaoRN = null;
	    tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
	    		
		if(this.tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans() == null){
			
			this.tipo_Documento_Transacao.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.tipo_Documento_Transacao.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.tipo_Documento_Transacao.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
		
			return this.tipo_Documento_Transacao;
		
			}else{
				
				this.tipo_Documento_Transacao = tipo_Documento_TransacaoRN.carregar(this.tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans());	
				return this.tipo_Documento_Transacao;
			}
	}

	public String salvar(){
		
		tipo_Documento_TransacaoRN = null;
		tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
								
				if(tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans() == null){						
			
					if(tipo_Documento_TransacaoRN.carregarPorIdTransIdTipo(this.tipo_Documento_Transacao.getId_transacao().getId_transacao(),this.tipo_Documento_Transacao.getId_tipo_doc().getId_tipo_doc()) != null){
										
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Tipo Documento ja foi cadastrado!"));
						return null;
						
					}else{
						

						tipo_Documento_TransacaoRN.salvar(this.tipo_Documento_Transacao);				
						return "/restrito/tipo_documento_transacao/tipo_documento_transacao.xhtml?faces-redirect=true";		
						
					}
			
				}else{
					
					if(tipo_Documento_TransacaoRN.carregarPorIdTransIdTipo(this.tipo_Documento_Transacao.getId_transacao().getId_transacao(),this.tipo_Documento_Transacao.getId_tipo_doc().getId_tipo_doc()) != null){
						
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Tipo Documento ja foi cadastrado!"));
						return null;
						
					}else{
						
						tipo_Documento_TransacaoRN.alterar(this.tipo_Documento_Transacao);
						return "/restrito/tipo_documento_transacao/tipo_documento_transacao.xhtml?faces-redirect=true";
	}				
					}
										
									
						
			
	}
	
	public String novo(){
		
		return "/restrito/tipo_documento_transacao/cadastro_tipo_documento_transacao.xhtml?faces-redirect=true";
	}
	
	public String alterar(){
		
		return "/restrito/tipo_documento_transacao/cadastro_tipo_documento_transacao.xhtml?id=" + this.tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans() + "faces-redirect=true";
		
	}
	
	public String excluir(){
	
		tipo_Documento_TransacaoRN = null;
		tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
		this.tipo_Documento_Transacao =	tipo_Documento_TransacaoRN.carregar(this.tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans());
	
		try {
			
			tipo_Documento_TransacaoRN.excluir(this.tipo_Documento_Transacao);
			return "/restrito/tipo_documento_transacao/tipo_documento_transacao.xhtml?faces-redirect=true";
			
			} catch (DAOException e) {
			
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
				return null;
			}	
	
	}
	
	public List<Tipo_Documento_Transacao> listarPorCOdEmCodFiCodUni(Usuario usuario){
			
		tipo_Documento_TransacaoRN = null;
		tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
					
		return tipo_Documento_TransacaoRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
			
	}
		
	public boolean desabilitarCampos() {

		if (tipo_Documento_TransacaoSelecionado.getId_tipo_doc_trans() != null) {
			
			return true;
		}

		return false;
	}


	public Tipo_Documento_Transacao getTipo_Documento_Transacao() {
		return tipo_Documento_Transacao;
	}


	public void setTipo_Documento_Transacao(Tipo_Documento_Transacao tipo_Documento_Transacao) {
		this.tipo_Documento_Transacao = tipo_Documento_Transacao;
	}


	public Tipo_Documento_Transacao getTipo_Documento_TransacaoSelecionado() {
		return tipo_Documento_TransacaoSelecionado;
	}


	public void setTipo_Documento_TransacaoSelecionado(Tipo_Documento_Transacao tipo_Documento_TransacaoSelecionado) {
		this.tipo_Documento_TransacaoSelecionado = tipo_Documento_TransacaoSelecionado;
	}


	public List<Tipo_Documento_Transacao> getLista() {
		return lista;
	}


	public void setLista(List<Tipo_Documento_Transacao> lista) {
		this.lista = lista;
	}

	public LazyDataModel<Tipo_Documento_Transacao> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Tipo_Documento_Transacao> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tipo_Documento_TransacaoRN getTipo_Documento_TransacaoRN() {
		return tipo_Documento_TransacaoRN;
	}

	public void setTipo_Documento_TransacaoRN(Tipo_Documento_TransacaoRN tipo_Documento_TransacaoRN) {
		this.tipo_Documento_TransacaoRN = tipo_Documento_TransacaoRN;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());		
		result = prime * result + ((tipo_Documento_Transacao == null) ? 0 : tipo_Documento_Transacao.hashCode());
		result = prime * result
				+ ((tipo_Documento_TransacaoSelecionado == null) ? 0 : tipo_Documento_TransacaoSelecionado.hashCode());
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
		Tipo_Documento_TransacaoBean other = (Tipo_Documento_TransacaoBean) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;	
		if (tipo_Documento_Transacao == null) {
			if (other.tipo_Documento_Transacao != null)
				return false;
		} else if (!tipo_Documento_Transacao.equals(other.tipo_Documento_Transacao))
			return false;
		if (tipo_Documento_TransacaoSelecionado == null) {
			if (other.tipo_Documento_TransacaoSelecionado != null)
				return false;
		} else if (!tipo_Documento_TransacaoSelecionado.equals(other.tipo_Documento_TransacaoSelecionado))
			return false;
		return true;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	

}

