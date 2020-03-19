package br.com.OPT_WEB_002.rest;

import java.math.BigInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import br.com.OPT_WEB_002.transacao_documento.*;


@Path("/transdoc")
public class TransacaoDocumentoConsulta {

	private Transacao_DocumentoRN transDocRN = new Transacao_DocumentoRN();
	private Transacao_Documento TransacaoDocumento = new Transacao_Documento();
	

	@GET
	@Path("/consulta/{id_trans_doc}")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)

	public String consultaTransacaoDoc(

			@PathParam("id_trans_doc") String id_trans_doc) {

		try {
			
		    TransacaoDocumento = transDocRN.consultaWebService(BigInteger.valueOf(Long.parseLong(id_trans_doc))) ;		 
		    return "descrição:" + TransacaoDocumento.getId_transacao().getDescricao() + "-"  + "data inicial:" + String.valueOf(TransacaoDocumento.getData_ini()) +  "-" + "data final:" + String.valueOf(TransacaoDocumento.getData_fim()) + "-" +"hora inicial:" + TransacaoDocumento.getHorario_ini().toString() + "-" + "hora final:" + TransacaoDocumento.getHorario_fim().toString() + "-" + "estado:" + TransacaoDocumento.getEstado();
					    
		} catch (Exception e) {

			System.out.println("Erro: " + "\n" + e);
			return null;
		}
	}

	public TransacaoDocumentoConsulta() {}

	public Transacao_DocumentoRN getTransDocRN() {
		return transDocRN;
	}

	public void setTransDocRN(Transacao_DocumentoRN transDocRN) {
		this.transDocRN = transDocRN;
	}

	public Transacao_Documento getTransacaoDocumento() {
		return TransacaoDocumento;
	}

	public void setTransacaoDocumento(Transacao_Documento transacaoDocumento) {
		TransacaoDocumento = transacaoDocumento;
	}

}
