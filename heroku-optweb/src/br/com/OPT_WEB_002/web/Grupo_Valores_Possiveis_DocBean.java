package br.com.OPT_WEB_002.web;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.*;
import br.com.OPT_WEB_002.usuario.*;


@ManagedBean(name = "grupoValPosDocBean")
@ViewScoped
public class Grupo_Valores_Possiveis_DocBean {

	private Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc;
	private Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_DocSelecionado;
	private Usuario usuario;
	private BigInteger id_grup_val_pos_doc;
	private BigInteger id_grupo_valores;
	private Grupo_Valores_Possiveis_DocRN grupo_Valores_Possiveis_DocRN;
	
	public Grupo_Valores_Possiveis_DocBean() {}
	
	@PostConstruct
	public void init(){
		
		this.grupo_Valores_Possiveis_Doc = new Grupo_Valores_Possiveis_Doc();
		this.grupo_Valores_Possiveis_DocSelecionado = new Grupo_Valores_Possiveis_Doc();	
		
		
	}
	
	public Grupo_Valores_Possiveis_Doc iniciar(Usuario usuario){

		grupo_Valores_Possiveis_DocRN = null;
		grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();
		
		if(id_grup_val_pos_doc == null){
			
			this.grupo_Valores_Possiveis_Doc.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.grupo_Valores_Possiveis_Doc.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.grupo_Valores_Possiveis_Doc.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
		
	
			return this.grupo_Valores_Possiveis_Doc;
		
		}else{
		
			this.grupo_Valores_Possiveis_Doc = grupo_Valores_Possiveis_DocRN.carregar(id_grup_val_pos_doc);			
			return this.grupo_Valores_Possiveis_Doc;
		}
				
	}	
	
	public String novo (){
		
		return "/restrito/grupo_valores_possiveis_doc/cadastro_grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
	}
	
	public String alterar (){
				
		return "/restrito/grupo_valores_possiveis_doc/cadastro_grupo_valores_possiveis_doc.xhtml?id= " + grupo_Valores_Possiveis_DocSelecionado.getId_grup_val_pos_doc() +"faces-redirect=true";
	}
	
	public String excluir(){
		
		grupo_Valores_Possiveis_DocRN = null;
		grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();
		
		this.grupo_Valores_Possiveis_Doc = grupo_Valores_Possiveis_DocRN.carregar(grupo_Valores_Possiveis_DocSelecionado.getId_grup_val_pos_doc());
		
		grupo_Valores_Possiveis_DocRN.excluir(this.grupo_Valores_Possiveis_Doc);
		
		return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
		
	}
	
	public String salvar(){
		
		grupo_Valores_Possiveis_DocRN = null;
		grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();

		if(id_grup_val_pos_doc == null){
				
			grupo_Valores_Possiveis_DocRN.salvar(this.grupo_Valores_Possiveis_Doc);
			grupo_Valores_Possiveis_DocSelecionado = null;
			grupo_Valores_Possiveis_DocSelecionado = new Grupo_Valores_Possiveis_Doc();
			return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
			
		}else{
										
			grupo_Valores_Possiveis_DocRN.alterar(this.grupo_Valores_Possiveis_Doc);	
			grupo_Valores_Possiveis_DocSelecionado = null;
			grupo_Valores_Possiveis_DocSelecionado = new Grupo_Valores_Possiveis_Doc();
			return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
		}
	}
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorCodEmCodFiCodUni(Usuario usuario){
		
		Grupo_Valores_Possiveis_DocRN grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();		
		return grupo_Valores_Possiveis_DocRN.listarPorCodEmCodFiCodUni();
	}
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(Usuario usuario){
		
		Grupo_Valores_Possiveis_DocRN grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();
		
		return grupo_Valores_Possiveis_DocRN.listarPorIdGrupoValoresCodEmCodFiCodUni(iniciar(usuario).getId_grupo_valores().getId_grupo_valores(),iniciar(usuario).getCod_empresa().getCod_empresa(),iniciar(usuario).getCod_filial().getCod_filial(),iniciar(usuario).getCod_unidade().getCod_unidade());
	}
	
	public Grupo_Valores_Possiveis_Doc getGrupo_Valores_Possiveis_Doc() {
		return grupo_Valores_Possiveis_Doc;
	}

	public void setGrupo_Valores_Possiveis_Doc(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
		this.grupo_Valores_Possiveis_Doc = grupo_Valores_Possiveis_Doc;
	}

	public Grupo_Valores_Possiveis_Doc getGrupo_Valores_Possiveis_DocSelecionado() {
		return grupo_Valores_Possiveis_DocSelecionado;
	}

	public void setGrupo_Valores_Possiveis_DocSelecionado(
			Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_DocSelecionado) {
		this.grupo_Valores_Possiveis_DocSelecionado = grupo_Valores_Possiveis_DocSelecionado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigInteger getId_grup_val_pos_doc() {
		return id_grup_val_pos_doc;
	}

	public void setId_grup_val_pos_doc(BigInteger id_grup_val_pos_doc) {
		this.id_grup_val_pos_doc = id_grup_val_pos_doc;
	}
	
	public BigInteger getId_grupo_valores() {
		return id_grupo_valores;
	}

	public void setId_grupo_valores(BigInteger id_grupo_valores) {
		this.id_grupo_valores = id_grupo_valores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo_Valores_Possiveis_Doc == null) ? 0 : grupo_Valores_Possiveis_Doc.hashCode());
		result = prime * result + ((grupo_Valores_Possiveis_DocSelecionado == null) ? 0
				: grupo_Valores_Possiveis_DocSelecionado.hashCode());
		result = prime * result + ((id_grup_val_pos_doc == null) ? 0 : id_grup_val_pos_doc.hashCode());
		result = prime * result + ((id_grupo_valores == null) ? 0 : id_grupo_valores.hashCode());		
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
		Grupo_Valores_Possiveis_DocBean other = (Grupo_Valores_Possiveis_DocBean) obj;
		if (grupo_Valores_Possiveis_Doc == null) {
			if (other.grupo_Valores_Possiveis_Doc != null)
				return false;
		} else if (!grupo_Valores_Possiveis_Doc.equals(other.grupo_Valores_Possiveis_Doc))
			return false;
		if (grupo_Valores_Possiveis_DocSelecionado == null) {
			if (other.grupo_Valores_Possiveis_DocSelecionado != null)
				return false;
		} else if (!grupo_Valores_Possiveis_DocSelecionado.equals(other.grupo_Valores_Possiveis_DocSelecionado))
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


}
