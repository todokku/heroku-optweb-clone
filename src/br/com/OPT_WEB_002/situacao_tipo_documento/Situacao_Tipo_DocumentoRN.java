package br.com.OPT_WEB_002.situacao_tipo_documento;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOFactory;


public class Situacao_Tipo_DocumentoRN {

	private Situacao_Tipo_DocumentoDAO situacao_Tipo_DocumentoDAO;
	
	public Situacao_Tipo_DocumentoRN(){
		
		this.situacao_Tipo_DocumentoDAO = DAOFactory.criarSituacaoTipoDocumento();
		
	}
	
	public void salvar (Situacao_Tipo_Documento situacao_Tipo_Documento){
		
		this.situacao_Tipo_DocumentoDAO.salvar(situacao_Tipo_Documento);
	}
	

	public void excluir (Situacao_Tipo_Documento situacao_Tipo_Documento){
		
		this.situacao_Tipo_DocumentoDAO.excluir(situacao_Tipo_Documento);
	}
	
	
	public void alterar (Situacao_Tipo_Documento situacao_Tipo_Documento){
		
		this.situacao_Tipo_DocumentoDAO.alterar(situacao_Tipo_Documento);
	}

	public Situacao_Tipo_Documento carregar (String cod_campo){
		
		return this.situacao_Tipo_DocumentoDAO.carregar(cod_campo);
	}
	
	public List<Situacao_Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc){
		
		return this.situacao_Tipo_DocumentoDAO.listarPorIdTipoDoc(id_tipo_doc);
	}


	public List<Situacao_Tipo_Documento> listarPorCodEmpCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.situacao_Tipo_DocumentoDAO.listarPorCodEmpCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}
	
	public Situacao_Tipo_Documento carregarPorIdTipoDocDesc(BigInteger id_tipo_doc,String descricao){
		
		return this.situacao_Tipo_DocumentoDAO.carregarPorIdTipoDocDesc(id_tipo_doc,descricao);
	}
	
}
