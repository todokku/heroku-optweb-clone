package br.com.OPT_WEB_002.tipo_documento;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface Tipo_DocumentoDAO {

	public void salvar(Tipo_Documento tipo_documento) throws DAOException;
	
	public void alterar(Tipo_Documento tipo_documento);
	
	public void excluir(Tipo_Documento tipo_documento) throws DAOException;
	
	public Tipo_Documento carregar(BigInteger id_tipo_doc);
	
	public Tipo_Documento carregarPorIdTiDocCodEmCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Tipo_Documento> listar();
	
	public List<Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
		
	public List<Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public Tipo_Documento listarUltimoId();
	
	public Tipo_Documento carregarPorCodTipoDocDesc(String codigo,BigInteger id_tipo_doc,String descricao);
	
	public Tipo_Documento carregarPorTipoDocDesc(BigInteger id_tipo_doc,String descricao);

}
