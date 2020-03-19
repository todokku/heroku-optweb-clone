package br.com.OPT_WEB_002.situacao_tipo_documento;

import java.math.BigInteger;
import java.util.List;

public interface Situacao_Tipo_DocumentoDAO {
	
	
	public void salvar(Situacao_Tipo_Documento situacao_Tipo_Documento);
	
	public void excluir (Situacao_Tipo_Documento situacao_Tipo_Documento);
	
	public void alterar (Situacao_Tipo_Documento situacao_Tipo_Documento);
	
	public Situacao_Tipo_Documento carregar(String cod_campo);
	
	public List<Situacao_Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc);
	
	public List<Situacao_Tipo_Documento> listarPorCodEmpCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public Situacao_Tipo_Documento carregarPorIdTipoDocDesc(BigInteger id_tipo_doc,String descricao);
}
