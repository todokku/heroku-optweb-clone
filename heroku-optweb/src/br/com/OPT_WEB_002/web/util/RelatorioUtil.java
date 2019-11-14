
package br.com.OPT_WEB_002.web.util;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import javax.faces.context.*;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;
import org.primefaces.model.*;
import br.com.OPT_WEB_002.util.UtilException;

public class RelatorioUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StreamedContent geraRelatorio(

		HashMap parametrosRelatorio, String nomeRelatorioJasper, String nomeRelatorioSaida) throws UtilException {

		StreamedContent arquivoRetorno = null;

		try {
					
			Connection conexao = this.getConexao();
	
			FacesContext contextoFaces = FacesContext.getCurrentInstance();
	
			ExternalContext contextoExterno = contextoFaces.getExternalContext();
	
			ServletContext contextoServlet = (ServletContext) contextoExterno.getContext();
	
			String caminhoRelatorios = contextoServlet.getRealPath("/relatorios");
	
			String caminhoArquivoJasper = caminhoRelatorios + File.separator + nomeRelatorioJasper + ".jasper";

			String caminhoArquivoRelatorio = caminhoRelatorios + File.separator + nomeRelatorioSaida;

			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivoJasper);

			JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper,parametrosRelatorio, conexao);

			String extensao = null;
	
			File arquivoGerado = null;
		
			JRPdfExporter pdfExportado = new JRPdfExporter();
		
			extensao = "pdf";
		
			arquivoGerado = new java.io.File(caminhoArquivoRelatorio + "." + extensao);
			
			pdfExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
			
			pdfExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivoGerado));
			
			pdfExportado.exportReport();
		
			arquivoGerado.deleteOnExit();
			
			InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
			arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/" + extensao,
					nomeRelatorioSaida + "." + extensao);
			
		} catch (JRException e) {

			throw new UtilException("Não foi possível gerar o relatório.", e);

		}

		catch (FileNotFoundException e) {

			throw new UtilException("Arquivo do relatório não encontrado.", e);
		}

		return arquivoRetorno;
	}

	private Connection getConexao() throws UtilException {

		try {
					
			Connection con = DriverManager.getConnection( "jdbc:postgresql://ec2-54-163-226-238.compute-1.amazonaws.com:5432/opt_web_002","patrick","root");  
			
			return con;	
			
		} catch (SQLException e) {

			throw new UtilException("Ocorreu um erro de SQL.", e);
		}
	}

}