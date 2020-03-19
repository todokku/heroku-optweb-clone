package br.com.OPT_WEB_002.usuario_tipo_documento;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Usuario_Tipo_DocumentoDAOHibernate implements Usuario_Tipo_DocumentoDAO{
	
	private Session session;

	@Override
	public void salvar(Usuario_Tipo_Documento usuario_tipo_documento) {
		session.save(usuario_tipo_documento);
	}

	@Override
	public void alterar(Usuario_Tipo_Documento usuario_Tipo_Documento) {
		session.merge(usuario_Tipo_Documento);		
	}

	@Override
	public void excluir(Usuario_Tipo_Documento usuario_Tipo_Documento) {
		session.delete(usuario_Tipo_Documento);
		
	}

	@Override
	public Usuario_Tipo_Documento carregar(BigInteger id_usuario_tipo_documento) {
				
		return (Usuario_Tipo_Documento)  session.load(Usuario_Tipo_Documento.class,id_usuario_tipo_documento);
		
	}

	/**@SuppressWarnings("unchecked")
	@Override
	public List<Usuario_Tipo_Documento> listar() {
		
		return session.createCriteria(Usuario_Tipo_Documento.class).list();
				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario_Tipo_Documento> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_documento,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
		
		String hql = "select tb from usuario_tipo_documento tb where tb.id_tipo_documento = :id_tipo_documento and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_documento",id_tipo_documento);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
				
		return consulta.list();
	}*/
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario_Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
			
		String hql = "select tb from usuario_tipo_documento tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = session.createQuery(hql);		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
				
		return consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario_Tipo_Documento> listarPorIdUsuarioCodEmCodFiCodUni(BigInteger id_usuario, Integer cod_empresa,Integer cod_filial, Integer cod_unidade) {
		
		String hql = "select tb from usuario_tipo_documento tb where tb.id_usuario = :id_usuario and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = session.createQuery(hql);
		
		consulta.setBigInteger("id_usuario",id_usuario);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}
	
	@Override
	public Usuario_Tipo_Documento carregarPorIdUsuIdTipo(BigInteger id_usuario, BigInteger id_tipo_doc) {
		
		String hql = "select tb from usuario_tipo_documento tb where tb.id_usuario = :id_usuario and tb.id_tipo_doc = :id_tipo_doc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_usuario",id_usuario);
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		
		return (Usuario_Tipo_Documento)  consulta.uniqueResult();
		
	}


	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Usuario_Tipo_Documento> carregarPorIdTipoCodCampoConteudo(BigInteger id_tipo_doc, String cod_campo,
			String conteudo) {
		
		String hql = "select tb from usuario_tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc and cod_campo = :cod_campo and tb.conteudo = :conteudo";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setString("cod_campo",cod_campo);
		consulta.setString("conteudo",conteudo);
		
		return  consulta.list();
	}

	

	
	
	
	

}
