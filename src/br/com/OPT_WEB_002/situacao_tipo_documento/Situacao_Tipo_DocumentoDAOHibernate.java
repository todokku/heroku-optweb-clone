package br.com.OPT_WEB_002.situacao_tipo_documento;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Situacao_Tipo_DocumentoDAOHibernate implements Situacao_Tipo_DocumentoDAO {

	private Session session;
	
	
	
	@Override
	public void salvar(Situacao_Tipo_Documento situacao_Tipo_Documento) {
		
		this.session.save(situacao_Tipo_Documento);
		
	}

	@Override
	public void excluir(Situacao_Tipo_Documento situacao_Tipo_Documento) {
		
		this.session.delete(situacao_Tipo_Documento);
		
	}

	public void alterar(Situacao_Tipo_Documento situacao_Tipo_Documento) {
		
		this.session.merge(situacao_Tipo_Documento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Situacao_Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc) {
		
		String hql = "select tb from situacao_tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);		
		
		return consulta.list();
	}
	
	@Override
	public Situacao_Tipo_Documento carregar(String cod_campo) {
		
		String hql = "select tb from situacao_tipo_documento tb where tb.cod_campo = :cod_campo";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setString("cod_campo",cod_campo);
		
		return (Situacao_Tipo_Documento) consulta.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Situacao_Tipo_Documento> listarPorCodEmpCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
		String hql = "select tb from situacao_tipo_documento tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}


	@Override
	public Situacao_Tipo_Documento carregarPorIdTipoDocDesc(BigInteger id_tipo_doc, String descricao) {
		
		String hql = "select tb from situacao_tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.descricao = :descricao";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setString("descricao",descricao);
		
		return (Situacao_Tipo_Documento) consulta.uniqueResult();
	}


	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}



}
