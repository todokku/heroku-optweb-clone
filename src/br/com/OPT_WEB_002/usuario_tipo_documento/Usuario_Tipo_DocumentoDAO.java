package br.com.OPT_WEB_002.usuario_tipo_documento;

import java.math.BigInteger;
import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.util.UsAsciiUtils;


public interface Usuario_Tipo_DocumentoDAO {
	
	public void salvar(Usuario_Tipo_Documento usuario_tipo_documento);
	
	public void alterar (Usuario_Tipo_Documento usuario_Tipo_Documento);
	
	public void excluir (Usuario_Tipo_Documento usuario_Tipo_Documento);
	
	public Usuario_Tipo_Documento carregar (BigInteger id_usuario_tipo_documento);
	
	public Usuario_Tipo_Documento carregarPorIdUsuIdTipo(BigInteger id_usuario,BigInteger id_tipo_doc);
	
	/**public List<Usuario_Tipo_Documento> listar();**/
	
	/**public List<Usuario_Tipo_Documento> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_documento,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);**/

	public List<Usuario_Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Usuario_Tipo_Documento> listarPorIdUsuarioCodEmCodFiCodUni(BigInteger id_usuario,Integer cod_empresa,Integer cod_filial,Integer cod_unidade); 
	
	public List<Usuario_Tipo_Documento> carregarPorIdTipoCodCampoConteudo(BigInteger id_tipo_doc,String cod_campo,String conteudo);
}
