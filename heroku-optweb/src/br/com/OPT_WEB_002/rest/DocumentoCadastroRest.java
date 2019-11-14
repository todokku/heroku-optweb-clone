package br.com.OPT_WEB_002.rest;

import java.math.BigInteger;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import br.com.OPT_WEB_002.documento.Documento;
import br.com.OPT_WEB_002.documento.DocumentoRN;

@Path("/documento")
public class DocumentoCadastroRest {

	private DocumentoRN documentoRN = new DocumentoRN();


	@PostConstruct
	public void init() {}

	@POST
	@Path("/cadastrar/{cod_em}/{cod_fi}/{cod_un}/{tp_doc}/{sit}/{dtini}/{dtfim}/{horini}/{horfim}/{cli}/{num1}/{num2}")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)

	public void salvarEtiquetas(

			@PathParam("cod_em") int cod_em, @PathParam("cod_fi") int cod_fi,@PathParam("cod_un") int cod_un,@PathParam("tp_doc") BigInteger tp_doc,
			@PathParam("sit") String sit,
			@PathParam("dtini") String dtini,
			@PathParam("dtfim") String dtfim,
			@PathParam("horini") String horini,
			@PathParam("horfim") String horfim,
			@PathParam("cli") String cli,
			@PathParam("num1") String num1,
			@PathParam("num2") String num2)
			
			/**@PathParam("ch1") String ch1, 
			@PathParam("ch2") String ch2, 
			@PathParam("ch3") String ch3,
			@PathParam("ch4") String ch4, 
			@PathParam("ch5") String ch5, 
			@PathParam("ch6") String ch6,
			@PathParam("ch7") String ch7, 
			@PathParam("ch8") String ch8, 
			@PathParam("ch9") String ch9,
			@PathParam("chdez") String ch10,
			@PathParam("ch11") String ch11, 
			@PathParam("ch12") String ch12,
			@PathParam("ch13") String ch13, 
			@PathParam("ch14") String ch14, 
			@PathParam("ch15") String ch15,
			@PathParam("ch16") String ch16, 
			@PathParam("ch17") String ch17, 
			@PathParam("ch18") String ch18,
			@PathParam("ch19") String ch19, 
			@PathParam("chvinte") String ch20,
			@PathParam("int1") int int1,
			@PathParam("int2") int int2, 
			@PathParam("int3") int int3, 
			@PathParam("int4") int int4,
			@PathParam("int5") int int5, 
			@PathParam("int6") int int6, 
			@PathParam("int7") int int7,
			@PathParam("int8") int int8, 
			@PathParam("int9") int int9, 
			@PathParam("intdez") int int10,
			@PathParam("dec1") int dec1, 
			@PathParam("dec2") int dec2, 
			@PathParam("dec3") int dec3,
			@PathParam("dec4") int dec4, 
			@PathParam("dec5") int dec5,
			@PathParam("dec6") int dec6,
			@PathParam("dec7") int dec7,
			@PathParam("dec8") int dec8, 
			@PathParam("dec9") int dec9,
			@PathParam("decdez") int dec10)**/{

		try {
			
			Documento doc = new Documento();
			
			doc.getCod_empresa().setCod_empresa(cod_em);
			
			doc.getCod_filial().setCod_filial(cod_fi);
			
			doc.getCod_unidade().setCod_unidade(cod_un);			
			
			doc.getId_tipo_doc().setId_tipo_doc(tp_doc);		
			
			doc.setSituacao(sit);			
			
			/**Date date = new SimpleDateFormat("yyyy-MM-dddd").parse(dtini);
			
			Date date2 = new SimpleDateFormat("yyyy-MM-dddd").parse(dtfim);
			
			doc.setDataIniPrev(date);
						
			doc.setDataFimPrev(date2);
			
			Date hora = new SimpleDateFormat("HH:mm").parse(horini);			
			
			doc.setHorarioIniPrev(hora);
			
			Date hora2 = new SimpleDateFormat("HH:mm").parse(horfim);
			
			doc.setHorarioFimPrev(hora2);
			
			doc.setCliente(cli);
			
			doc.setNumero(num1);
			
			doc.setNumero_2(num2);**/
		
			/**doc.setChar_001(ch1);
			doc.setChar_002(ch2);
			doc.setChar_003(ch3);
			doc.setChar_004(ch4);
			doc.setChar_005(ch5);
			doc.setChar_006(ch6);
			doc.setChar_007(ch7);
			doc.setChar_008(ch8);
			doc.setChar_009(ch9);
			doc.setChar_010(ch10);
			doc.setChar_011(ch11);
			doc.setChar_012(ch12);
			doc.setChar_013(ch13);
			doc.setChar_014(ch14);
			doc.setChar_015(ch15);
			doc.setChar_016(ch16);
			doc.setChar_017(ch17);
			doc.setChar_018(ch18);
			doc.setChar_019(ch19);
			doc.setChar_020(ch20);
			
			doc.setInt_001(int1);
			doc.setInt_002(int2);
			doc.setInt_003(int3);
			doc.setInt_004(int4);
			doc.setInt_005(int5);
			doc.setInt_006(int6);
			doc.setInt_007(int7);
			doc.setInt_008(int8);
			doc.setInt_009(int9);
			doc.setInt_010(int10);
			
			doc.setDec_001(dec1);
			doc.setDec_002(dec2);
			doc.setDec_003(dec3);
			doc.setDec_004(dec4);
			doc.setDec_005(dec5);
			doc.setDec_006(dec6);
			doc.setDec_007(dec7);
			doc.setDec_008(dec8);
			doc.setDec_009(dec9);
			doc.setDec_010(dec10);**/
			
			documentoRN.cadastrarDocumentoWebService(doc);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public DocumentoCadastroRest() {}

	public DocumentoRN getDocumentoRN() {
		return documentoRN;
	}

	public void setDocumentoRN(DocumentoRN documentoRN) {
		this.documentoRN = documentoRN;
	}


}
