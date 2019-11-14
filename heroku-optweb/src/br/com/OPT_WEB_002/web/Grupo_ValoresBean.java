package br.com.OPT_WEB_002.web;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;
import br.com.OPT_WEB_002.grupo_valores.*;
import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.*;
import br.com.OPT_WEB_002.usuario.*;


@ManagedBean(name = "grupoValoresBean")
@SessionScoped
public class Grupo_ValoresBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Grupo_Valores grupo_Valores;
	private Grupo_Valores grupo_ValoresSelecionado;
	private BigInteger id_grupo_val;
	private BigInteger id_grupo_valores;
	private List<Grupo_Valores> lista;
	private Usuario usuario;	
	private Grupo_ValoresRN grupo_ValoresRN;
	
	public Grupo_ValoresBean() {}
	
	@PostConstruct
	public void init(){
		
		grupo_Valores = new Grupo_Valores();	
		grupo_ValoresSelecionado = new Grupo_Valores();
		id_grupo_valores = null;
		
		id_grupo_val = null;
	
	}
		
	
	/**Métodos Cadastro de Documento**/
	public BigInteger selecionarLinhaGrupo(SelectEvent event) {
	
		id_grupo_val = BigInteger.valueOf(Long.parseLong( ((Grupo_Valores) event.getObject()).getId_grupo_valores().toString()));
         
		return id_grupo_val;
	}
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(Usuario usuario){
		
	Grupo_Valores_Possiveis_DocRN grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();
		
		if(id_grupo_val != null){
	
			return grupo_Valores_Possiveis_DocRN.listarPorIdGrupoValoresCodEmCodFiCodUni(id_grupo_val,usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
						
		}else{
			
			return null;
		}	
		
	}
	
	
	
	public Grupo_Valores iniciar(Usuario usuario){
		
		grupo_ValoresRN = null;
		grupo_ValoresRN = new Grupo_ValoresRN();

		if(id_grupo_valores == null){
			
			this.grupo_Valores.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.grupo_Valores.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.grupo_Valores.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
						
			return this.grupo_Valores;	
		
		}else{
					
			grupo_ValoresRN = null;
			grupo_ValoresRN = new Grupo_ValoresRN();
		
			this.grupo_Valores = grupo_ValoresRN.carregar(id_grupo_valores);
	       
			return this.grupo_Valores;
		}
		
	}
	
	
	public String novo(){
		
		return "/restrito/grupo_valores/cadastro_grupo_valores.xhtml?faces-redirect=true";
	}
	
	public String alterar(){
	
		return "/restrito/grupo_valores/cadastro_grupo_valores.xhtml?id=" + this.grupo_ValoresSelecionado.getId_grupo_valores() + "faces-redirect=true";
	}
	
	public String  excluir(){
		
		grupo_ValoresRN = null;
		grupo_ValoresRN = new Grupo_ValoresRN();
			
		this.grupo_Valores = grupo_ValoresRN.carregar(grupo_ValoresSelecionado.getId_grupo_valores());
		
		grupo_ValoresRN.excluir(this.grupo_Valores);
		
		this.grupo_Valores = null;
		this.grupo_Valores = new Grupo_Valores();
		this.grupo_ValoresSelecionado = null;
		this.grupo_ValoresSelecionado = new Grupo_Valores();
		id_grupo_valores = null;
	
		return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
		
	}
	
	public List<Grupo_Valores> listarPorCodEmCodFiCodUni(Usuario usuario){
		
		grupo_ValoresRN = null;
		grupo_ValoresRN = new Grupo_ValoresRN();
		
		return grupo_ValoresRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
	}
	
	public String salvar(){
		
		grupo_ValoresRN = null;
		grupo_ValoresRN = new Grupo_ValoresRN();
			
		if(id_grupo_valores == null){
				
			grupo_ValoresRN.salvar(this.grupo_Valores);
			this.grupo_Valores = null;
			this.grupo_Valores = new Grupo_Valores();
			this.grupo_ValoresSelecionado = null;
			this.grupo_ValoresSelecionado = new Grupo_Valores();
			id_grupo_valores = null;
			return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
			
		}else{
				
			grupo_ValoresRN.alterar(this.grupo_Valores);

			this.grupo_Valores = null;
			this.grupo_Valores = new Grupo_Valores();
			this.grupo_ValoresSelecionado = null;
			this.grupo_ValoresSelecionado = new Grupo_Valores();
			id_grupo_valores = null;
			return "/restrito/grupo_valores_possiveis_doc/grupo_valores_possiveis_doc.xhtml?faces-redirect=true";
		}
	}
	
	public Grupo_Valores getGrupo_Valores() {
		return grupo_Valores;
	}

	public void setGrupo_Valores(Grupo_Valores grupo_Valores) {
		this.grupo_Valores = grupo_Valores;
	}

	public Grupo_Valores getGrupo_ValoresSelecionado() {
		return grupo_ValoresSelecionado;
	}

	public void setGrupo_ValoresSelecionado(Grupo_Valores grupo_ValoresSelecionado) {
		this.grupo_ValoresSelecionado = grupo_ValoresSelecionado;
	}

	public BigInteger getId_grupo_valores() {
		return id_grupo_valores;
	}

	public void setId_grupo_valores(BigInteger id_grupo_valores) {
		this.id_grupo_valores = id_grupo_valores;
	}

	public List<Grupo_Valores> getLista() {
		return lista;
	}

	public void setLista(List<Grupo_Valores> lista) {
		this.lista = lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo_ValoresRN getGrupo_ValoresRN() {
		return grupo_ValoresRN;
	}

	public void setGrupo_ValoresRN(Grupo_ValoresRN grupo_ValoresRN) {
		this.grupo_ValoresRN = grupo_ValoresRN;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo_Valores == null) ? 0 : grupo_Valores.hashCode());
		result = prime * result + ((grupo_ValoresSelecionado == null) ? 0 : grupo_ValoresSelecionado.hashCode());
		result = prime * result + ((id_grupo_valores == null) ? 0 : id_grupo_valores.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		Grupo_ValoresBean other = (Grupo_ValoresBean) obj;
		if (grupo_Valores == null) {
			if (other.grupo_Valores != null)
				return false;
		} else if (!grupo_Valores.equals(other.grupo_Valores))
			return false;
		if (grupo_ValoresSelecionado == null) {
			if (other.grupo_ValoresSelecionado != null)
				return false;
		} else if (!grupo_ValoresSelecionado.equals(other.grupo_ValoresSelecionado))
			return false;
		if (id_grupo_valores == null) {
			if (other.id_grupo_valores != null)
				return false;
		} else if (!id_grupo_valores.equals(other.id_grupo_valores))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
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

	public BigInteger getId_grupo_val() {
		return id_grupo_val;
	}

	public void setId_grupo_val(BigInteger id_grupo_val) {
		this.id_grupo_val = id_grupo_val;
	}

	

}
