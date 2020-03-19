package br.com.OPT_WEB_002.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.transacao.*;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.usuario.UsuarioRN;
import br.com.OPT_WEB_002.util.DAOException;

@ManagedBean(name = "transacaoBean")
@ViewScoped
public class TransacaoBean {

	private Transacao transacao;
	private Transacao transacaoSelecionada;
	private List<Transacao> lista;
	private UsuarioRN usuarioRN;
	private LazyDataModel<Transacao> lazymodel;
	private Usuario usuario;
	private TransacaoRN transacaoRN;
	

	@PostConstruct
	public void init(){
		
		transacao = new Transacao();
		this.transacaoSelecionada = new Transacao();
	
	}	

	public Transacao iniciar(Usuario usuario) {
			
		transacaoRN = new TransacaoRN();
		
		if (this.transacaoSelecionada.getId_transacao() == null) {
		
					
			this.transacao.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.transacao.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.transacao.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
		
			return this.transacao;
			
		} else {
		
			this.transacao = transacaoRN.carregar(transacaoSelecionada.getId_transacao(),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
			return this.transacao;
		}

	}

	public String salvar() {
	
		transacaoRN = new TransacaoRN();
	
		if (this.transacaoSelecionada.getId_transacao() == null) {


			try {
				

				transacaoRN.salvar(this.transacao);								
				return "/restrito/transacao/transacao.xhtml?faces-redirect=true";

			} catch (DAOException e) {

				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
				return null;
			}

		} else {

			transacaoRN.alterar(this.transacao);
			return "/restrito/transacao/transacao.xhtml?faces-redirect=true";

		}

	}

	public String excluir() {
		
		transacaoRN = new TransacaoRN();
		
		
		try {
						
			this.transacao = transacaoRN.carregar(transacaoSelecionada.getId_transacao(),transacaoSelecionada.getCod_empresa().getCod_empresa(),transacaoSelecionada.getCod_filial().getCod_filial(),transacaoSelecionada.getCod_unidade().getCod_unidade());
		
			
			transacaoRN.excluir(this.transacao);
			return "/restrito/transacao/transacao.xhtml?faces-redirect=true";

		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}

		

	}
	

	public List<Transacao> listarPorCodEmCodFiCodUni(Usuario usuario) {

		transacaoRN = new TransacaoRN();
		
		return transacaoRN.listarPorCodEmCodFiCodUn(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
	}

	public String novo() {

		return "/restrito/transacao/cadastro_transacao.xhtml?faces-redirect=true";
	}

	public String alterar() {

		return "/restrito/transacao/cadastro_transacao.xhtml?id=" + this.transacaoSelecionada.getId_transacao() + "faces-redirect=true";
	}

	public boolean desabilitarCampo() {
		
		if (this.transacaoSelecionada != null) {

			return true;
		}

		return false;
	}
		
	public boolean desabilitarCampos() {

		if (transacaoSelecionada.getId_transacao() != null) {

			return true;
		}

		return false;
	}
	
	public String descricaoTempoTransacao(boolean tempo){
		
		if(tempo){			
			return "Proporcional";
		}else{			
			return "Fixo";
		}
		
	}
	
	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public Transacao getTransacaoSelecionada() {
		return transacaoSelecionada;
	}

	public void setTransacaoSelecionada(Transacao transacaoSelecionada) {
		this.transacaoSelecionada = transacaoSelecionada;
	}

	public List<Transacao> getLista() {
		return lista;
	}

	public void setLista(List<Transacao> lista) {
		this.lista = lista;
	}

	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public LazyDataModel<Transacao> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Transacao> lazymodel) {
		this.lazymodel = lazymodel;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public TransacaoRN getTransacaoRN() {
		return transacaoRN;
	}

	public void setTransacaoRN(TransacaoRN transacaoRN) {
		this.transacaoRN = transacaoRN;
	}

	
	public TransacaoBean() {}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((transacao == null) ? 0 : transacao.hashCode());
		result = prime * result + ((transacaoSelecionada == null) ? 0 : transacaoSelecionada.hashCode());
		result = prime * result + ((usuarioRN == null) ? 0 : usuarioRN.hashCode());
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
		TransacaoBean other = (TransacaoBean) obj;
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
		if (transacao == null) {
			if (other.transacao != null)
				return false;
		} else if (!transacao.equals(other.transacao))
			return false;
		if (transacaoSelecionada == null) {
			if (other.transacaoSelecionada != null)
				return false;
		} else if (!transacaoSelecionada.equals(other.transacaoSelecionada))
			return false;
		if (usuarioRN == null) {
			if (other.usuarioRN != null)
				return false;
		} else if (!usuarioRN.equals(other.usuarioRN))
			return false;
		return true;
	}

	
	
}
