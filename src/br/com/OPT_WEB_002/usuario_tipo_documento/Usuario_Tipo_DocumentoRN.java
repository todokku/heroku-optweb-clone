package br.com.OPT_WEB_002.usuario_tipo_documento;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Usuario_Tipo_DocumentoRN {
	
		private Usuario_Tipo_DocumentoDAO usuario_Tipo_DocumentoDAO;
		
		public Usuario_Tipo_DocumentoRN(){
			
			this.usuario_Tipo_DocumentoDAO = DAOFactory.criarUsuario_Tipo_Documento();
			
		}
		
		public void salvar(Usuario_Tipo_Documento usuario_tipo_documento) {
			
			usuario_Tipo_DocumentoDAO.salvar(usuario_tipo_documento);
			
		}
		
		/**public List<Usuario_Tipo_Documento> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
			
			return usuario_Tipo_DocumentoDAO.listarPorIdTipoDocCodEmCodFiCodUni(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
		}
		
		public List<Usuario_Tipo_Documento> listar() {
			
			return usuario_Tipo_DocumentoDAO.listar();
		}**/
		
		public void excluir(Usuario_Tipo_Documento usuario_Tipo_Documento) {
			
			usuario_Tipo_DocumentoDAO.excluir(usuario_Tipo_Documento);
			
		}
		
		public Usuario_Tipo_Documento carregar(BigInteger id_usuario_tipo_documento) {
			
			return usuario_Tipo_DocumentoDAO.carregar(id_usuario_tipo_documento);
		}
		
		public void alterar(Usuario_Tipo_Documento usuario_Tipo_Documento) {
			
			usuario_Tipo_DocumentoDAO.alterar(usuario_Tipo_Documento);
			
		}
		

		public List<Usuario_Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
			
			return this.usuario_Tipo_DocumentoDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
		}
		
		public List<Usuario_Tipo_Documento> listarPorIdUsuarioCodEmCodFiCodUni(BigInteger id_usuario, Integer cod_empresa,
				Integer cod_filial, Integer cod_unidade) {
			
			return usuario_Tipo_DocumentoDAO.listarPorIdUsuarioCodEmCodFiCodUni(id_usuario, cod_empresa, cod_filial, cod_unidade);
		}
		

		public Usuario_Tipo_Documento carregarPorIdUsuIdTipo(BigInteger id_usuario,BigInteger id_tipo_doc){
			return usuario_Tipo_DocumentoDAO.carregarPorIdUsuIdTipo(id_usuario, id_tipo_doc);
		}
		
		public List<Usuario_Tipo_Documento> carregarPorIdTipoCodCampoConteudo(BigInteger id_tipo_doc,String cod_campo,String conteudo) {
			
			return usuario_Tipo_DocumentoDAO.carregarPorIdTipoCodCampoConteudo(id_tipo_doc, cod_campo, conteudo);
		}

	public Usuario_Tipo_DocumentoDAO getUsuario_Tipo_DocumentoDAO() {
		return usuario_Tipo_DocumentoDAO;
	}

	public void setUsuario_Tipo_DocumentoDAO(Usuario_Tipo_DocumentoDAO usuario_Tipo_DocumentoDAO) {
		this.usuario_Tipo_DocumentoDAO = usuario_Tipo_DocumentoDAO;
	}}
