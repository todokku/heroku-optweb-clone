package br.com.OPT_WEB_002.rest;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import br.com.OPT_WEB_002.transacao_documento.*;


@Path("/transdoc")
public class TransacaoDocumentoCadastroRest {

	private Transacao_DocumentoRN transDocRN = new Transacao_DocumentoRN();

	@POST
	@Path("/cadastrar/{id_doc}/{cod_em}/{cod_fi}/{cod_un}/{id_trans}/{dtini}/{dtfim}/{horini}/{horfim}")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)

	public void salvarTransacaoEtiquetas(

			@PathParam("id_doc") String id_doc,@PathParam("cod_em") int cod_em, @PathParam("cod_fi") int cod_fi,
			@PathParam("cod_un") int cod_un,@PathParam("id_trans")String id_trans,@PathParam("dtini")String dtini,@PathParam("dtfim") String dtfim,@PathParam("horini")String horini,@PathParam("horfim") String horfim) {

		try {
		
			Transacao_Documento transDoc = new Transacao_Documento();
			
			transDoc.getId_doc().setId_doc(BigInteger.valueOf(Long.parseLong(id_doc)));
			transDoc.getCod_empresa().setCod_empresa(cod_em);
			transDoc.getCod_filial().setCod_filial(cod_fi);
			transDoc.getCod_unidade().setCod_unidade(cod_un);
			transDoc.getId_transacao().setId_transacao(BigInteger.valueOf(Long.parseLong(id_trans)));
		
			Date data1 = new SimpleDateFormat("yyyy-MM-dd").parse(dtini);			
			Date data2 = new SimpleDateFormat("yyyy-MM-dd").parse(dtfim);
						
			transDoc.setData_ini(data1);
			transDoc.setData_fim(data2);
			
			Date hora1 = new SimpleDateFormat("HH:mm").parse(horini);			
			Date hora2 = new SimpleDateFormat("HH:mm").parse(horfim);
			
			transDoc.setHorario_ini(hora1);
			transDoc.setHorario_fim(hora2);	
			
			transDocRN.cadastrarTransacaoDocumentoWebService(transDoc);
		
		} catch (Exception e) {

			System.out.println("Erro: " + "\n" + e);
		}
	}

	public TransacaoDocumentoCadastroRest() {
		
	}

}
