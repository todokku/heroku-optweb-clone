package br.com.OPT_WEB_002.val_campos_doc;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;



public class Val_Campos_DocDAOHibernate implements Val_Campos_DocDAO{

	private Session session;
	
	
	public Val_Campos_DocDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Val_Campos_Doc val_Campos_Doc) {
		
		this.session.clear();
		this.session.save(val_Campos_Doc);
		this.session.flush();
		
	}

	@Override
	public void alterar(Val_Campos_Doc val_Campos_Doc) {
		
		this.session.clear();
		this.session.merge(val_Campos_Doc);
		
	}

	@Override
	public Val_Campos_Doc carregar(BigInteger id_val_campos_doc) {
		
		String hql = "select tb from val_campos_doc tb where tb.id_val_campos_doc = :id_val_campos_doc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_val_campos_doc",id_val_campos_doc);		
		
		return (Val_Campos_Doc) consulta.uniqueResult();
	}

	@Override
	public void excluir(Val_Campos_Doc val_Campos_Doc) {
		
		this.session.delete(val_Campos_Doc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Doc> listar() {
		
		return this.session.createCriteria(Val_Campos_Doc.class).list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Doc> listarPorCodEmpresaCodFilialCodUnidade(Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {

		String hql ="select tb from val_campos_doc tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Val_Campos_Doc> listarPorIdTipoDocIdLay(BigInteger id_tipo_doc,BigInteger id_layout_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		String hql = "select tb from val_campos_doc tb where tb.id_tipo_doc = :id_tipo_doc and tb.id_layout_tipo_doc = :id_layout_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setBigInteger("id_layout_tipo_doc",id_layout_tipo_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
				
		return consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Doc> listarPorIdTipoDoc(BigInteger id_tipo_doc, Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {
			
				
				String hql = "select tb from val_campos_doc tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
				Query consulta = this.session.createQuery(hql);
				
				consulta.setBigInteger("id_tipo_doc",id_tipo_doc);		
				consulta.setInteger("cod_empresa",cod_empresa);
				consulta.setInteger("cod_filial",cod_filial);
				consulta.setInteger("cod_unidade",cod_unidade);
						
				return consulta.list();
	}

	@Override
	public Val_Campos_Doc listarUltimoId() {
		
		Query consulta = this.session.createQuery("select tb from val_campos_doc tb order by id_val_campos_doc desc");
		consulta.setMaxResults(1);
			
		return (Val_Campos_Doc) consulta.uniqueResult();
	}
		
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Val_Campos_DocDAOHibernate other = (Val_Campos_DocDAOHibernate) obj;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}


	}

	
		
		
		
		
		
			


