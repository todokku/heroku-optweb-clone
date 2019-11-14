package br.com.OPT_WEB_002.tipo_documento;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Tipo_DocumentoRN {
	
	private Tipo_DocumentoDAO tipo_DocumentoDAO;
	private Usuario usuario;
	
	public Tipo_DocumentoRN(){

		this.tipo_DocumentoDAO = DAOFactory.criarTipo_Documento();
			
	}

	public void salvar(Tipo_Documento tipo_documento) throws DAOException{

		if (listar().size() >= 1) {
		
			Tipo_Documento tipo_Documento2 = tipo_documento;
	
			tipo_Documento2.setId_tipo_doc(listarUltimoId().getId_tipo_doc().add(BigInteger.valueOf(Long.parseLong("1"))));
	
			this.tipo_DocumentoDAO.salvar(tipo_Documento2);			
					
		}else{
					
			tipo_documento.setId_tipo_doc(BigInteger.valueOf(Long.parseLong("1")));
		
			this.tipo_DocumentoDAO.salvar(tipo_documento);
			
		}
	}
	
	public void alterar(Tipo_Documento tipo_Documento){
		
		this.tipo_DocumentoDAO.alterar(tipo_Documento);
	}
	
	public void excluir(Tipo_Documento tipo_documento) throws DAOException{
		
		this.tipo_DocumentoDAO.excluir(tipo_documento);
	} 
	
	public Tipo_Documento carregar(BigInteger id_tipo_doc){
		
		return this.tipo_DocumentoDAO.carregar(id_tipo_doc);
	}
	
	public List<Tipo_Documento> listar(){
			
		return this.tipo_DocumentoDAO.listar();
	}
	
	public List<Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return 	tipo_DocumentoDAO.listarPorCodEmCodFiCodUni(cod_empresa,cod_filial,cod_unidade);		
		
	}
	
	public Tipo_Documento carregarPorIdTiDocCoDEmCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return tipo_DocumentoDAO.carregarPorIdTiDocCodEmCodFiCodUni(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
	}
			

	public List<Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.tipo_DocumentoDAO.listarPorIdTipoDoc(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public Tipo_Documento listarUltimoId(){
		
		return tipo_DocumentoDAO.listarUltimoId();
	}
	
	public Tipo_Documento carregarPorCodTipoDocDesc(String codigo,BigInteger id_tipo_doc,String descricao){
		
		return tipo_DocumentoDAO.carregarPorCodTipoDocDesc(codigo, id_tipo_doc, descricao);
	}
	
	public Tipo_Documento carregarPorTipoDocDesc(BigInteger id_tipo_doc,String descricao){
		
		return tipo_DocumentoDAO.carregarPorTipoDocDesc(id_tipo_doc, descricao);
	}
		
		
	public Tipo_DocumentoDAO getTipo_DocumentoDAO() {
		
		return tipo_DocumentoDAO;
	}

	public void setTipo_DocumentoDAO(Tipo_DocumentoDAO tipo_DocumentoDAO) {
		this.tipo_DocumentoDAO = tipo_DocumentoDAO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo_DocumentoDAO == null) ? 0 : tipo_DocumentoDAO.hashCode());
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
		Tipo_DocumentoRN other = (Tipo_DocumentoRN) obj;
		if (tipo_DocumentoDAO == null) {
			if (other.tipo_DocumentoDAO != null)
				return false;
		} else if (!tipo_DocumentoDAO.equals(other.tipo_DocumentoDAO))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
