package br.com.OPT_WEB_002.rest;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.primefaces.model.StreamedContent;
import br.com.OPT_WEB_002.documento.*;
import br.com.OPT_WEB_002.layout_empresa.*;
import br.com.OPT_WEB_002.transacao_documento.*;

@Path("/doc")
public class DocumentoConsultaQRCode {

	private DocumentoRN documentoRN = new DocumentoRN();
	private Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
	private Layout_Empresa layout_Empresa = new Layout_Empresa();
	private Transacao_DocumentoRN transacaoDocumentoRN = new Transacao_DocumentoRN();
	private Documento doc = new Documento();
	private String [] teste;
	private List<String> listaCampo = new ArrayList<String>();
	private String url = "http://localhost:8080/heroku-optweb/restrito/teste.xhtml?id=";
	private Field campo = null;
		

	@GET
	@Path("/consulta-rastreabilidade/{id_tipo_doc}/{campo1}")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA)

	public StreamedContent consultaTransacaoDoc(
			
			@PathParam("id_tipo_doc") String id_tipo_doc,@PathParam("campo1") String campo1) {

				teste = campo1.split(",");
			
			/**		
			try {
				
				QRCodeWriter qrCodeWriter = new QRCodeWriter();
			
				for(String campo : teste){
					listaCampo.add(campo);	
				}
				
			for(Layout_Empresa layout_Empresa : layout_EmpresaRN.consultaPorIdTipoDoc(BigInteger.valueOf(Long.parseLong(id_tipo_doc)))){
					
					for(Documento documento : documentoRN.listarPorIdTipoDoc(BigInteger.valueOf(Long.parseLong(id_tipo_doc)))){
						
						campo =	documento.getClass().getDeclaredField(layout_Empresa.getCod_campo());
						campo.setAccessible(true);
					
						if(campo.get(documento).equals(listaCampo.get(0).toString())){
													
							url = url + documento.getId_doc().toString();
							
							BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 350, 350);

							ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();

							MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

							InputStream in = new ByteArrayInputStream(pngOutputStream.toByteArray());

							StreamedContent streamedContent = new DefaultStreamedContent(in, ".png", "documento.png");
						**/
							return null;
						/**}
					
					}
					
				}
				
			} catch (NullPointerException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | WriterException | IOException e) {
	
				return null;
			}
			return null;**/
			
						
	}

	public DocumentoConsultaQRCode() {}

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

	public Layout_EmpresaRN getLayout_EmpresaRN() {
		return layout_EmpresaRN;
	}

	public void setLayout_EmpresaRN(Layout_EmpresaRN layout_EmpresaRN) {
		this.layout_EmpresaRN = layout_EmpresaRN;
	}

	public Layout_Empresa getLayout_Empresa() {
		return layout_Empresa;
	}

	public void setLayout_Empresa(Layout_Empresa layout_Empresa) {
		this.layout_Empresa = layout_Empresa;
	}

	public Documento getDoc() {
		return doc;
	}

	public void setDoc(Documento doc) {
		this.doc = doc;
	}

}
