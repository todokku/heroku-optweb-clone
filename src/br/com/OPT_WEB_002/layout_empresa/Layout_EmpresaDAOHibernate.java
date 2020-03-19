package br.com.OPT_WEB_002.layout_empresa;

import java.math.BigInteger;
import java.util.*;
import org.hibernate.*;
import br.com.OPT_WEB_002.util.DAOException;
public class Layout_EmpresaDAOHibernate implements Layout_EmpresaDAO {

	private Session session;
	public Layout_EmpresaDAOHibernate() {}

	@Override
	public void salvar(Layout_Empresa layoutEmpresa) throws DAOException {
				    
		try{
	
			this.session.clear();
			this.session.save(layoutEmpresa);
			this.session.flush();

		}catch(TransientObjectException e){
			
			e.printStackTrace();
			this.session.clear();
			
			throw new DAOException("Tipo Documento não pode ser nulo!",e);
		}
			
			
	}

	@Override
	public void alterar(Layout_Empresa layoutEmpresa) {

		this.session.merge(layoutEmpresa);

	}
	
	@Override
	public void excluir(Layout_Empresa layoutEmpresa) {

		this.session.delete(layoutEmpresa);

	}

	@Override
	public Layout_Empresa carregar(BigInteger id_layout) {
		
		String hql = "select tb from layout_empresa tb where tb.id_layout = :id_layout";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_layout",id_layout);			
		return (Layout_Empresa) consulta.uniqueResult();
			
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		String hql = "select l from layout_empresa l where l.cod_empresa = :cod_empresa and l.cod_filial = :cod_filial and l.cod_unidade = :cod_unidade order by l.id_tipo_doc,l.sequencia";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);
		
		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa> listar() {

		return this.session.createCriteria(Layout_Empresa.class).list();
	}


	@Override
	public Layout_Empresa carregarPorCodCampo(String cod_campo,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {

		String hql = "select l from layout_empresa l where l.cod_campo = :cod_campo and l.cod_empresa = :cod_empresa and l.cod_filial = :cod_filial and l.cod_unidade = :cod_unidade";
		
		Query consulta = this.session.createQuery(hql);		
		
		consulta.setString("cod_campo",cod_campo);		
		consulta.setInteger("cod_empresa", cod_empresa);		
		consulta.setInteger("cod_filial", cod_filial);		
		consulta.setInteger("cod_unidade", cod_unidade);
		
		return (Layout_Empresa) consulta.uniqueResult();	
	}
	
	@SuppressWarnings({ "unchecked"})
	public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
		
		
		
		String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);
				
		return consulta.list();
	}
	
	@Override
	public Layout_Empresa listarPorIdTipoDocCodCampo(BigInteger id_tipo_doc, String cod_campo,Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_campo = :cod_campo and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setString("cod_campo",cod_campo);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return (Layout_Empresa) consulta.uniqueResult();
	}

	@Override
	public Layout_Empresa listarUltimoId() {
		
		Query consulta = this.session.createQuery("select tb from layout_empresa tb order by id_layout desc");
		consulta.setMaxResults(1);
		
		return (Layout_Empresa) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa> listarCamposFlag(BigInteger id_tipo_doc,Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {
		
		String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and  tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade and tb.flag_campo = true order by tb.sequencia asc";
		
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
					
		return consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa> listarCampoReferencia(BigInteger id_tipo_doc,Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
		
		String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade and tb.flag_campo = true";
		
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);	
	
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
							
		return  consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa> listarPorFlagFiltro(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		String hql = "select tb from layout_empresa tb where tb.flag_campo = true and tb.filtro = true and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}


	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Layout_Empresa>  listarPorQrCodeFlag(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {

		String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and tb.qrcode = true and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		
		Query consulta = this.session.createQuery(hql);
	
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
	
		return consulta.list();
		
	}

		public void iniciaSessao(){
			
			session.beginTransaction();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Layout_Empresa> listarPorCod(String cod_campo) {
			
			String hql = "select l from layout_empresa l where l.cod_campo = :cod_campo";
			
			Query consulta = this.session.createQuery(hql);		
			
			consulta.setString("cod_campo",cod_campo);
									
			return  consulta.list();
			
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Layout_Empresa> listarPorIdTipoDoc(BigInteger id_tipo_doc) {
			

		
			
			String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc and tb.qrcode = true order by tb.sequencia asc";
			
			Query consulta = this.session.createQuery(hql);
			
			consulta.setBigInteger("id_tipo_doc",id_tipo_doc);	
		
			return  consulta.list();
			
		}

		@SuppressWarnings("unchecked")
		public List<Layout_Empresa> listarPor_tipoDocumento(BigInteger id_tipo_doc){
			
			/**List<Layout_Empresa> lista = new ArrayList<Layout_Empresa>();
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			@SuppressWarnings("unused")
			Transaction trans = session.beginTransaction();**/
						
			String hql = "select tb from layout_empresa tb where tb.id_tipo_doc = :id_tipo_doc";
			Query consulta = this.session.createQuery(hql);
			
		   	consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
					
			/**lista = consulta.list();
			
			this.session.getTransaction().commit();**/
			
			return consulta.list();
			
		}

	}

	
	
	





