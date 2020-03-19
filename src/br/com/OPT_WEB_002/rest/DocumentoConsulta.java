package br.com.OPT_WEB_002.rest;

import java.math.BigInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import br.com.OPT_WEB_002.documento.*;
import br.com.OPT_WEB_002.transacao_documento.*;


@Path("/doc")
public class DocumentoConsulta {

	private DocumentoRN documentoRN = new DocumentoRN();
	private Transacao_DocumentoRN transacaoDocumentoRN = new Transacao_DocumentoRN();
	
	@GET
	@Path("/consulta/{id_doc}")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)

	public String consultaTransacaoDoc(

			@PathParam("id_doc") String id_doc) {

		try {
			
			Documento doc = new Documento(); 
			doc = documentoRN.consultaWebService(BigInteger.valueOf(Long.parseLong(id_doc)));
			
			/**for(Transacao_Documento transacao_Documento : transacaoDocumentoRN.listarPorIdDoc(doc.getId_doc(),doc.getCod_empresa().getCod_empresa(),doc.getCod_filial().getCod_filial(),doc.getCod_unidade().getCod_unidade())){
			
				return "doc:" + doc.getId_doc().toString() + "-" + "estado:" + doc.getSituacao();
			}**/
			
		} catch (Exception e) {

			System.out.println("Erro: " + "\n" + e);
			return null;
		}
		return null;
		
	}

	public DocumentoConsulta() {}

	public DocumentoRN getDocumentoRN() {
		return documentoRN;
	}

	public void setDocumentoRN(DocumentoRN documentoRN) {
		this.documentoRN = documentoRN;
	}

	public Transacao_DocumentoRN getTransacaoDocumentoRN() {
		return transacaoDocumentoRN;
	}

	public void setTransacaoDocumentoRN(Transacao_DocumentoRN transacaoDocumentoRN) {
		this.transacaoDocumentoRN = transacaoDocumentoRN;
	}

}
