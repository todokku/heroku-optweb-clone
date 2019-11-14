package br.com.OPT_WEB_002.tipo_documento;

import java.math.BigInteger;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.OPT_WEB_002.util.DAOException;

public class Tipo_DocumentoDAOHibernate implements Tipo_DocumentoDAO {

	private Session session;
			
	@Override
	public void salvar(Tipo_Documento tipo_documento) throws DAOException {
		
		try{
	
			this.session.save(tipo_documento);
			this.session.flush();

		}catch (ConstraintViolationException e) {
			
			e.printStackTrace();
			this.session.clear();
			
			throw new DAOException("Id tipo documento já foi cadastrado!");
		
		}
	}

	@Override
	public void alterar(Tipo_Documento tipo_Documento) {		

			this.session.merge(tipo_Documento);		
	}

	@Override
	public void excluir(Tipo_Documento tipo_documento) throws DAOException {
		
		try{

			this.session.delete(tipo_documento);

		}catch(ConstraintViolationException e){
			
			e.printStackTrace();
			this.session.clear();
			
			throw new DAOException("Item relacionado com outra tabela!");
			
		}
		
	}

	@Override
	public Tipo_Documento carregar(BigInteger id_tipo_doc) {
		
		return (Tipo_Documento) this.session.get(Tipo_Documento.class,id_tipo_doc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento> listar() {

		return this.session.createCriteria(Tipo_Documento.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {

		String hql = "select tdoc from tipo_documento tdoc where tdoc.cod_empresa = :cod_empresa and tdoc.cod_filial = :cod_filial and tdoc.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);

		return consulta.list();
	}

	
	@Override
	public Tipo_Documento carregarPorIdTiDocCodEmCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {
	
		String hql = "select tb from tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
	
		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return (Tipo_Documento) consulta.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
		
		String hql = "select tb from tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}


	@Override
	public Tipo_Documento listarUltimoId() {
		
		Query consulta = this.session.createQuery("select tb from tipo_documento tb order by id_tipo_doc desc");
		consulta.setMaxResults(1);
		
		return (Tipo_Documento) consulta.uniqueResult();
	}
	
	
	@Override
	public Tipo_Documento carregarPorCodTipoDocDesc(String codigo, BigInteger id_tipo_doc, String descricao) {
	
		String hql = "select tb from tipo_documento tb where tb.cod_campo = :codigo and tb.id_tipo_doc = :id_tipo_doc and tb.descricao = :descricao";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setString("codigo",codigo);
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setString("descricao",descricao);
					
		return (Tipo_Documento) consulta.uniqueResult();
		
	}
	
	@Override
	public Tipo_Documento carregarPorTipoDocDesc(BigInteger id_tipo_doc, String descricao) {
	
		String hql = "select tb from tipo_documento tb where tb.id_tipo_doc = :id_tipo_doc and tb.descricao = :descricao";
		Query consulta = this.session.createQuery(hql);
		
		
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		consulta.setString("descricao",descricao);
					
		return (Tipo_Documento) consulta.uniqueResult();
		
	}

	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}



	

	
}
