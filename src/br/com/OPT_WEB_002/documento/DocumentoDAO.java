package br.com.OPT_WEB_002.documento;


import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;


public interface DocumentoDAO {

	public void salvar(Documento documento) throws DAOException;

	public void alterar(Documento documento);
	
	public void excluir(Documento documento) throws DAOException;
	
	public Documento carregar(BigInteger id_doc);
	
	public void cadastrarDocumentoWebService(Documento documento);
	
	public Documento listar();	
	
	public List<Documento> listarPorIdTipoDescCodEmpCodFiCodUni(BigInteger id_tipo_doc,String situacao,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
		
	public List<Documento> listarPorCodEmCodFi(Integer cod_empresa, Integer cod_filial);

	public List<Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade);

	public List<Documento> listarPorIdTipoDocCodEmpCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Documento> listarPorCliente(String cliente,BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public Documento listarUltimoId(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Documento> listarPorIdDoc(BigInteger id_doc);
	
	public  Documento consultaWebService(BigInteger id_doc);
	
	public List<Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc);
	
				
}
