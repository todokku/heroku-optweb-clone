
  
package br.com.OPT_WEB_002.layout_empresa;

import java.math.BigInteger;
import java.util.*;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.*;

public class Layout_EmpresaRN {

	private Layout_EmpresaDAO layoutEmpresaDAO;
	private Layout_Empresa layoutEmpresa = new Layout_Empresa();
	private Usuario usuario;

	public Layout_EmpresaRN() {

		this.layoutEmpresaDAO = DAOFactory.criarLayoutEmpresaDAO();
			
	}

	public void salvar(Layout_Empresa layoutEmpresa) throws DAOException{
		
	

		if (listar().size() >= 1) {
					
			layoutEmpresa.setId_layout(listarUltimoId().getId_layout().add(BigInteger.valueOf(Long.parseLong("1"))));
				
				this.layoutEmpresaDAO.salvar(layoutEmpresa);
				
		}else{
		
		layoutEmpresa.setId_layout(BigInteger.valueOf(Long.parseLong("1")));

		this.layoutEmpresaDAO.salvar(layoutEmpresa);
			
		}
		
	}

	public void excluir(Layout_Empresa layoutEmpresa) throws DAOException {

		this.layoutEmpresaDAO.excluir(layoutEmpresa);
	}

	public List<Layout_Empresa> listar() {
			
		return layoutEmpresaDAO.listar();
	}

	public void alterar(Layout_Empresa layoutempresa) {

		this.layoutEmpresaDAO.alterar(layoutempresa);

	}

	public Layout_Empresa carregar(BigInteger id_layout) {

		return this.layoutEmpresaDAO.carregar(id_layout);
	}

	public List<Layout_Empresa> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		return this.layoutEmpresaDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}
	
	public Layout_Empresa carregarPorCodCampo(String cod_campo,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		try{
		return this.layoutEmpresaDAO.carregarPorCodCampo(cod_campo, cod_empresa, cod_filial, cod_unidade);
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc, Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {
		
		return layoutEmpresaDAO.listarPorIdTipoDoc(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public Layout_Empresa listarPorIdTipoDocCodCampo(BigInteger id_tipo_doc,String cod_campo, Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {
		
		return layoutEmpresaDAO.listarPorIdTipoDocCodCampo(id_tipo_doc, cod_campo, cod_empresa, cod_filial, cod_unidade);
	}
	
	public Layout_Empresa listarUltimoId(){
		
		return layoutEmpresaDAO.listarUltimoId();
	}
	
	public List<Layout_Empresa> listarCamposFlag(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return layoutEmpresaDAO.listarCamposFlag(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
		
	}
	
	public List<Layout_Empresa> listarCampoReferencia(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return layoutEmpresaDAO.listarCampoReferencia(id_tipo_doc,cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Layout_Empresa> listarPorFlagFiltro (Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return layoutEmpresaDAO.listarPorFlagFiltro(cod_empresa, cod_filial, cod_unidade);
	}

	public List<Layout_Empresa> listarPorQrCodeFlag(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return layoutEmpresaDAO.listarPorQrCodeFlag(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Layout_Empresa> listarPorCod(String cod_campo){
		
		return this.layoutEmpresaDAO.listarPorCod(cod_campo);
		
	}
	
	public List<Layout_Empresa> listarPor_tipoDocumento(BigInteger id_tipo_doc){
		
		return layoutEmpresaDAO.listarPor_tipoDocumento(id_tipo_doc);
	}
	
	public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc){
		
		return this.layoutEmpresaDAO.listarPorIdTipoDoc(id_tipo_doc);
		
	}
	
	public Layout_EmpresaDAO getLayoutEmpresaDAO() {
		return layoutEmpresaDAO;
	}

	public void setLayoutEmpresaDAO(Layout_EmpresaDAO layoutEmpresaDAO) {
		this.layoutEmpresaDAO = layoutEmpresaDAO;
	}

	public Layout_Empresa getLayoutEmpresa() {
		return layoutEmpresa;
	}

	public void setLayoutEmpresa(Layout_Empresa layoutEmpresa) {
		this.layoutEmpresa = layoutEmpresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
