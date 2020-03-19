package br.com.OPT_WEB_002.transacao_documento;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface Transacao_DocumentoDAO {

	public void salvar(Transacao_Documento transacao_documento) throws DAOException;

	public void alterar(Transacao_Documento transacao_documento);
	
	public void excluir(Transacao_Documento transacao_documento) throws DAOException;

	public Transacao_Documento carregar(BigInteger id_transacao_documento);
	
	public Transacao_Documento carregarPorIdTransDocCodEmpCodFiCodUni(BigInteger id_transacao_doc,Integer cod_empresa, Integer cod_filial, Integer cod_unidade);

	public void cadastrarTransacaoDocumentoWebService(Transacao_Documento transacao_documento);
	
	public List<Transacao_Documento> listarPorIdDoc(BigInteger id_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Transacao_Documento> listar();
	
	public List<Transacao_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade);

	public Transacao_Documento listarUltimoId();
	
	public List<Transacao_Documento> listarPorIdTrans(BigInteger id_transacao_doc);
	
	public Transacao_Documento consultaWebService(BigInteger id_transacao_doc);
	

	
}
