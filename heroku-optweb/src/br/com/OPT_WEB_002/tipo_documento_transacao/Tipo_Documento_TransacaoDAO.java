package br.com.OPT_WEB_002.tipo_documento_transacao;

import java.math.BigInteger;
import java.util.List;

import br.com.OPT_WEB_002.util.DAOException;

public interface Tipo_Documento_TransacaoDAO {

	public void salvar(Tipo_Documento_Transacao tipo_Documento_Transacao) ;
	
	public void alterar(Tipo_Documento_Transacao tipo_Documento_Transacao);
	
	public void excluir(Tipo_Documento_Transacao tipo_Documento_Transacao) throws DAOException;
	
	public Tipo_Documento_Transacao carregar(BigInteger id_tipo_doc_trans);
	
	public List<Tipo_Documento_Transacao> listar ();
	
	public List<Tipo_Documento_Transacao> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_doc);
	
	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUniWebService(BigInteger id_tipo_doc);
	
	public Tipo_Documento_Transacao listarUtlimoId();
	
	public Tipo_Documento_Transacao carregarPorIdTransIdTipo(BigInteger id_transacao,BigInteger id_tipo_doc);
	
	
}