package br.com.OPT_WEB_002.val_campos_trans_doc;

import java.math.BigInteger;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.*;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.HibernateUtil;



public class Val_Campos_Trans_DocDAOHibernate implements Val_Campos_Trans_DocDAO {

	private Session session;

	public Val_Campos_Trans_DocDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Val_Campos_Trans_Doc valCamp) throws DAOException {
	
		this.session.save(valCamp);		
	}
	

	@Override
	public void alterar(Val_Campos_Trans_Doc valCamp) {

		this.session.merge(valCamp);

	}


	@Override
	public void excluir(Val_Campos_Trans_Doc valCamp) throws DAOException {
		
		try{
		
			this.session.delete(valCamp);
			this.session.flush();
		
		/**Validação de relacionamento entre tabelas**/
		}catch(ConstraintViolationException e){
						
			throw new DAOException("Item relacionado com outra tabela!",e);
			
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Trans_Doc> listar() {

		return this.session.createCriteria(Val_Campos_Trans_Doc.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Trans_Doc> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
		
		String hql = "select tr from val_campos_trans_doc tr where tr.cod_empresa = :cod_empresa and tr.cod_filial = :cod_filial and tr.cod_unidade =:cod_unidade";
			
		Query consulta = this.session.createQuery(hql);
						
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}
	
	@Override
	public Val_Campos_Trans_Doc carregar(Integer id_val_camp_trans_doc) {
	
		return (Val_Campos_Trans_Doc) this.session.load(Val_Campos_Trans_Doc.class, id_val_camp_trans_doc);
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Trans_Doc> listarPorIdTransDoc(BigInteger id_trans_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
				
		String hql = "select tb from val_campos_trans_doc tb where tb.id_trans_doc = :id_trans_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade =:cod_unidade order by id_camp_adic";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_trans_doc", id_trans_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
						
		return consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Trans_Doc> carregarPorIdCampAdic(BigInteger id_camp_adic,BigInteger id_trans_doc,Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
		

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select tb from val_campos_trans_doc tb where tb.id_camp_adic = :id_camp_adic and tb.id_trans_doc = :id_trans_doc and cod_empresa = :cod_empresa and cod_filial = :cod_filial and cod_unidade = :cod_unidade order by id_camp_adic";
		Query consulta = this.session.createQuery(hql);
				
		consulta.setBigInteger("id_camp_adic",id_camp_adic);
		consulta.setBigInteger("id_trans_doc",id_trans_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
					
		return consulta.list();
	
	}
	
	@Override
	public Val_Campos_Trans_Doc listarUltimoId() {
				
			Query consulta = session.createQuery("select tb from val_campos_trans_doc tb order by id_val_camp_trans_doc desc");
					
			consulta.setMaxResults(1);
			return (Val_Campos_Trans_Doc) consulta.uniqueResult();		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Val_Campos_Trans_Doc> listarPorValCampoTransDoc(BigInteger id_val_camp_trans_doc) {
		
		String hql = "select tb from val_campos_trans_doc tb where tb.id_val_camp_trans_doc = :id_val_camp_trans_doc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_val_camp_trans_doc",id_val_camp_trans_doc);
				
		return consulta.list();
	}
	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void cadastrarCampoAdicionalWebService(Val_Campos_Trans_Doc val_Campos_Trans_Doc) {
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(val_Campos_Trans_Doc);			
		
		this.session.getTransaction().commit();
	
	}
	
}
