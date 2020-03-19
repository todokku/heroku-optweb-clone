package br.com.OPT_WEB_002.layout_empresa;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface Layout_EmpresaDAO {

	public void salvar(Layout_Empresa layoutEmpresa) throws DAOException;

	public void alterar(Layout_Empresa layoutEmpresa);
	
	public void excluir(Layout_Empresa layoutEmpresa);

	public Layout_Empresa carregar(BigInteger id_layout);
	
	public Layout_Empresa carregarPorCodCampo(String cod_campo,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Layout_Empresa> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade);

	public List<Layout_Empresa> listar();
		
	public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc, Integer cod_empresa, Integer cod_filial,Integer cod_unidade);	
	
	public Layout_Empresa listarPorIdTipoDocCodCampo(BigInteger id_tipo_doc,String cod_campo,Integer cod_empresa, Integer cod_filial,Integer cod_unidade);
	
	public Layout_Empresa listarUltimoId();
	
	public List<Layout_Empresa> listarCamposFlag(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Layout_Empresa> listarCampoReferencia(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Layout_Empresa> listarPorFlagFiltro(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Layout_Empresa> listarPorQrCodeFlag(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Layout_Empresa> listarPorCod(String cod_campo);
	
	public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc);
	
	public List<Layout_Empresa> listarPor_tipoDocumento(BigInteger id_tipo_doc);
	
	public void iniciaSessao();
	
	
}
