package br.com.OPT_WEB_002.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.OPT_WEB_002.util.HibernateUtil;

@WebFilter(urlPatterns = { "*.xhtml", "/webservice/*" })
public class ConexaoHibernateFilter implements Filter {

	private SessionFactory sf;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		this.sf = HibernateUtil.getSessionFactory();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Session currentSession = this.sf.getCurrentSession();

		Transaction transaction = null;

		try {

			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();

			if (currentSession.isOpen()) {

				currentSession.close();

			}

		} catch (Throwable ex) {

			try {

				if (transaction.isActive()) {

					transaction.rollback();
				}

			} catch (Throwable t) {

				t.printStackTrace();

			}

			System.out.println(ex.getCause().getMessage().toString());
			throw new ServletException(ex);
		
		}

	}

	@Override
	public void destroy() {

	}

}
