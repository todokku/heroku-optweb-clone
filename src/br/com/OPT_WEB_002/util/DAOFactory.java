package br.com.OPT_WEB_002.util;

import br.com.OPT_WEB_002.campo_adicional.Campo_AdicionalDAO;
import br.com.OPT_WEB_002.campo_adicional.Campo_AdicionalDAOHibernate;
import br.com.OPT_WEB_002.documento.DocumentoDAO;
import br.com.OPT_WEB_002.documento.DocumentoDAOHibernate;
import br.com.OPT_WEB_002.empresa.EmpresaDAO;
import br.com.OPT_WEB_002.empresa.EmpresaDAOHibernate;
import br.com.OPT_WEB_002.filial.FilialDAO;
import br.com.OPT_WEB_002.filial.FilialDAOHibernate;
import br.com.OPT_WEB_002.grupo_valores.Grupo_ValoresDAO;
import br.com.OPT_WEB_002.grupo_valores.Grupo_ValoresDAOHibernate;
import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.Grupo_Valores_Possiveis_DocDAO;
import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.Grupo_Valores_Possiveis_DocDAOHibernate;
import br.com.OPT_WEB_002.layout_empresa.Layout_EmpresaDAO;
import br.com.OPT_WEB_002.layout_empresa.Layout_EmpresaDAOHibernate;
import br.com.OPT_WEB_002.situacao_tipo_documento.Situacao_Tipo_DocumentoDAO;
import br.com.OPT_WEB_002.situacao_tipo_documento.Situacao_Tipo_DocumentoDAOHibernate;
import br.com.OPT_WEB_002.tipo_documento.Tipo_DocumentoDAO;
import br.com.OPT_WEB_002.tipo_documento.Tipo_DocumentoDAOHibernate;
import br.com.OPT_WEB_002.tipo_documento_transacao.Tipo_Documento_TransacaoDAO;
import br.com.OPT_WEB_002.tipo_documento_transacao.Tipo_Documento_TransacaoDAOHibernate;
import br.com.OPT_WEB_002.transacao.TransacaoDAO;
import br.com.OPT_WEB_002.transacao.TransacaoDAOHibernate;
import br.com.OPT_WEB_002.transacao_documento.Transacao_DocumentoDAO;
import br.com.OPT_WEB_002.transacao_documento.Transacao_DocumentoDAOHibernate;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_NegocioDAO;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_NegocioDAOHibernate;
import br.com.OPT_WEB_002.usuario.UsuarioDAO;
import br.com.OPT_WEB_002.usuario.UsuarioDAOHibernate;
import br.com.OPT_WEB_002.usuario_tipo_documento.Usuario_Tipo_DocumentoDAOHibernate;
import br.com.OPT_WEB_002.val_campos_doc.Val_Campos_DocDAO;
import br.com.OPT_WEB_002.val_campos_doc.Val_Campos_DocDAOHibernate;
import br.com.OPT_WEB_002.val_campos_trans_doc.Val_Campos_Trans_DocDAO;
import br.com.OPT_WEB_002.val_campos_trans_doc.Val_Campos_Trans_DocDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO()

	{

		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return usuarioDAO;
	}

	public static EmpresaDAO criarEmpresaDAO() {

		EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
		empresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return empresaDAO;
	}

	public static FilialDAO criarFilialDAO() {

		FilialDAOHibernate filialDAO = new FilialDAOHibernate();
		filialDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return filialDAO;

	}

	public static Unidade_NegocioDAO criarUnidade_NegocioDAO() {

		Unidade_NegocioDAOHibernate unidade_DAO = new Unidade_NegocioDAOHibernate();
		unidade_DAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return unidade_DAO;

	}

	
	public static DocumentoDAO criarDocumentoDAO() {

		DocumentoDAOHibernate documentoDAO = new DocumentoDAOHibernate();
		documentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return documentoDAO;

	}

	public static Layout_EmpresaDAO criarLayoutEmpresaDAO() {

		Layout_EmpresaDAOHibernate layoutEmpresaDAO = new Layout_EmpresaDAOHibernate();
		layoutEmpresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return layoutEmpresaDAO;
	}

	public static TransacaoDAO criarTransacaoDAO() {

		TransacaoDAOHibernate transacaoDAO = new TransacaoDAOHibernate();
		transacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return transacaoDAO;
	}

	public static Transacao_DocumentoDAO criarTransacaoDocumentoDAO() {

		Transacao_DocumentoDAOHibernate transacaoDocumentoDAO = new Transacao_DocumentoDAOHibernate();
		transacaoDocumentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return transacaoDocumentoDAO;
	}

	public static Campo_AdicionalDAO criarCampoAdicionalDAO() {

		Campo_AdicionalDAOHibernate campoAdicionalDAO = new Campo_AdicionalDAOHibernate();
		campoAdicionalDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return campoAdicionalDAO;
	}

	
	public static Val_Campos_Trans_DocDAO criarValCampDAO(){
				
		Val_Campos_Trans_DocDAOHibernate ValCampDAO = new Val_Campos_Trans_DocDAOHibernate();
		ValCampDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return ValCampDAO;
		
	}
	
	public static Tipo_DocumentoDAO criarTipo_Documento(){
		
		Tipo_DocumentoDAOHibernate tipo_DocumentoDAOHibernate = new Tipo_DocumentoDAOHibernate();
		tipo_DocumentoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return tipo_DocumentoDAOHibernate;
		
	}
	
	public static Tipo_Documento_TransacaoDAO criarTipoDocumentoTransacao(){
		
		Tipo_Documento_TransacaoDAOHibernate tipo_Documento_TransacaoDAOHibernate = new  Tipo_Documento_TransacaoDAOHibernate();
		tipo_Documento_TransacaoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return tipo_Documento_TransacaoDAOHibernate;
	}
	

	public static Val_Campos_DocDAO criarValCamposDoc(){
		
		Val_Campos_DocDAOHibernate val_Campos_DocDAOHibernate = new Val_Campos_DocDAOHibernate();
		val_Campos_DocDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return val_Campos_DocDAOHibernate;
	}
	
	
	public static Grupo_ValoresDAO criarGrupoValores(){
		
		Grupo_ValoresDAOHibernate grupo_ValoresDAOHibernate = new Grupo_ValoresDAOHibernate();
		grupo_ValoresDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return grupo_ValoresDAOHibernate;
	}
	
	public static Grupo_Valores_Possiveis_DocDAO criarGrupo_Valores_Possiveis_Doc(){
		
		Grupo_Valores_Possiveis_DocDAOHibernate grupo_Valores_Possiveis_DocDAOHibernate = new Grupo_Valores_Possiveis_DocDAOHibernate();
		grupo_Valores_Possiveis_DocDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		
		return grupo_Valores_Possiveis_DocDAOHibernate;
	}
	

	public static Situacao_Tipo_DocumentoDAO criarSituacaoTipoDocumento(){
		
		Situacao_Tipo_DocumentoDAOHibernate situacao_Tipo_DocumentoDAOHibernate = new Situacao_Tipo_DocumentoDAOHibernate();
		situacao_Tipo_DocumentoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		
		return situacao_Tipo_DocumentoDAOHibernate;
	}
	
	public static Usuario_Tipo_DocumentoDAOHibernate criarUsuario_Tipo_Documento(){
		
		Usuario_Tipo_DocumentoDAOHibernate usuario_Tipo_DocumentoDAOHibernate = new Usuario_Tipo_DocumentoDAOHibernate();
		usuario_Tipo_DocumentoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
				
		return usuario_Tipo_DocumentoDAOHibernate;
	}
		
		
}
