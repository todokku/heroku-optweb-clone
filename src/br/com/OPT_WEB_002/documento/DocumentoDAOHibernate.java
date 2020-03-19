package br.com.OPT_WEB_002.documento;

import java.math.BigInteger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.HibernateUtil;

public class DocumentoDAOHibernate implements DocumentoDAO {

	/**Objeto para iniciar sessão com o banco de dados**/
	private Session session;

	/**Método para gravar dados para a tabela documento**/
	@Override
	public void salvar(Documento documento) throws DAOException {

		try {

			System.out.println(documento.getChar_001());
			this.session.save(documento);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();

			throw new DAOException("Este código já foi cadastrado teste", e);
		}
	}

	/**Método para alterar dados para a tabela documento**/
	@Override
	public void alterar(Documento documento) {

		this.session.merge(documento);

	}

	/**Método para excluir dados para a tabela cliente**/
	@Override
	public void excluir(Documento documento) throws DAOException {

		try {

			this.session.delete(documento);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();

			throw new DAOException("Item relacionado com outra tabela", e);

		}

	}

	/**Método para carregar dados para a tabela documento por id_doc**/
	@Override
	public Documento carregar(BigInteger id_doc) {
		
		return(Documento) session.load(Documento.class, id_doc);
	}

	/**Método para listar dados para a tabela documento por ordenação de id_doc**/
	@Override
	public Documento listar() {

		String hql = "select tb from documento tb order by id_doc desc";
		Query consulta = this.session.createQuery(hql);

		consulta.setMaxResults(1);

		return (Documento) consulta.uniqueResult();
	}

	/**Método para listar dados para a tabela documento por cod_empresa,cod_filial e cod_unidade**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
			
		String hql = "select tb from documento tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();
	}

	/**Método para listar dados para a tabela documento por cod_empresa,cod_filial**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorCodEmCodFi(Integer cod_empresa, Integer cod_filial) {

		String hql = "select tb from documento tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);

		return consulta.list();
	}

	/**Método para gravar dados para a tabela documento por webService **/
	@Override
	public void cadastrarDocumentoWebService(Documento documento) {
		
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction trans = session.beginTransaction();
		session.save(documento);
		
		
		this.session.getTransaction().commit();
		
	}

	/**Método para listar dados para a tabela documento por id_tipo_doc,cod_empresa,cod_filial e cod_unidade**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorIdTipoDocCodEmpCodFiCodUni(BigInteger id_tipo_doc, Integer cod_empresa,
			Integer cod_filial, Integer cod_unidade) {

		String hql = "select tb from documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade order by tb.id_doc";

		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_tipo_doc", id_tipo_doc);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorCliente(String cliente,BigInteger id_tipo_doc, Integer cod_empresa,
			Integer cod_filial, Integer cod_unidade) {

		
		String hql = "select tb from documento tb where tb.cliente = :cliente and tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setString("cliente", cliente);
		consulta.setBigInteger("id_tipo_doc", id_tipo_doc);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();
	}

	@Override
	public Documento listarUltimoId(BigInteger id_tipo_doc,Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		Query consulta = session.createQuery(
		"select tb from documento tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade order by id_doc desc");
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);
		
		consulta.setMaxResults(1);

		return (Documento) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorIdDoc(BigInteger id_doc) {

		String hql = "select tb from documento tb where tb.id_doc = :id_doc";
		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_doc", id_doc);

		return consulta.list();
	}

	@Override
	public List<Documento> listarPorIdTipoDescCodEmpCodFiCodUni(BigInteger id_tipo_doc, String situacao,Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		String hql = "select tb from documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.situacao = :situacao and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_tipo_doc", id_tipo_doc);
		consulta.setString("situacao", situacao);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return null;
	}
	
	@Override
	public Documento consultaWebService(BigInteger id_doc) {
			
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction transaction = session.beginTransaction();
		return(Documento) session.load(Documento.class, id_doc);
	}

	
	public void iniciaSessao(){
		
		session.beginTransaction();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc) {
		
		String hql = "select tb from documento tb where tb.id_tipo_doc = :id_tipo_doc";
		
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc", id_tipo_doc);
			
		return consulta.list();
	}

}