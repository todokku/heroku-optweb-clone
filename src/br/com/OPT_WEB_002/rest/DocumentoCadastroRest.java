package br.com.OPT_WEB_002.rest;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import br.com.OPT_WEB_002.documento.*;
import br.com.OPT_WEB_002.layout_empresa.*;

@Path("/documento")
public class DocumentoCadastroRest {

	private DocumentoRN documentoRN = new DocumentoRN();
	private String [] valoresWebService = new String[50];
	private Layout_EmpresaRN Layout_EmpresaRN = new Layout_EmpresaRN();
   
	@PostConstruct
	public void init() {}
		
	@POST
	@Path("/cadastrar/{valores}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public void salvarEtiquetas(@PathParam("valores") String valores,
								@FormDataParam("file") java.io.InputStream uploadArquivo,
		    					@FormDataParam("file") FormDataContentDisposition detalhesArquivo) throws Exception{
		
		Documento doc = new Documento();
		
		System.out.println(detalhesArquivo.getFileName());
		
	    doc.setArquivo(IOUtils.toByteArray(uploadArquivo));
	    doc.setNome_arquivo(detalhesArquivo.getFileName());
	    
		
		if (detalhesArquivo.getFileName().contains(".ppt")) {
			doc.setExtensao_arq(".ppt");
		}
		
		if (detalhesArquivo.getFileName().contains(".pptx")) {
			doc.setExtensao_arq(".pptx");
		}
		
		if (detalhesArquivo.getFileName().contains(".pdf")) {
			doc.setExtensao_arq(".pdf");
		}

		if (detalhesArquivo.getFileName().contains(".xlsx")) {
			doc.setExtensao_arq(".xlsx");
		}

		if (detalhesArquivo.getFileName().contains(".docx")) {
			doc.setExtensao_arq(".docx");
		}
		
		if (detalhesArquivo.getFileName().contains(".txt")) {
		    doc.setExtensao_arq(".txt");
		}
		 
	    if (detalhesArquivo.getFileName().contains(".htm")) {
			doc.setExtensao_arq(".html");
	    }

		if (detalhesArquivo.getFileName().contains(".jpeg")) {
			doc.setExtensao_arq(".jpeg");
		}	

		if (detalhesArquivo.getFileName().contains(".png")) {
			doc.setExtensao_arq(".png");
		}
		
	    if (detalhesArquivo.getFileName().contains(".bmp")) {
			doc.setExtensao_arq(".bmp");
		}

	    if (detalhesArquivo.getFileName().contains(".zip")) {
			doc.setExtensao_arq(".zip");
		}
	    
		if (detalhesArquivo.getFileName().contains(".rar")) {
			doc.setExtensao_arq(".rar");
		}
				
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
							
		valoresWebService = valores.split(",");
									
		doc.getId_tipo_doc().setId_tipo_doc(BigInteger.valueOf(Long.parseLong(valoresWebService[0])));
																		
						for(Layout_Empresa layout_Empresa : Layout_EmpresaRN.listarPor_tipoDocumento(doc.getId_tipo_doc().getId_tipo_doc())){
					
							doc.getCod_empresa().setCod_empresa(layout_Empresa.getCod_empresa().getCod_empresa());
							doc.getCod_filial().setCod_filial(layout_Empresa.getCod_filial().getCod_filial());
							doc.getCod_unidade().setCod_unidade(layout_Empresa.getCod_unidade().getCod_unidade());
				
							java.lang.reflect.Field campoDocumento = Documento.class.getDeclaredField(layout_Empresa.getCod_campo());
							campoDocumento.setAccessible(true);
										
							try{
							
								if(campoDocumento.getName().equals("char_001")){
									
									doc.setChar_001(valoresWebService[1]);
								}
								
								if(campoDocumento.getName().equals("char_002")){
									
									doc.setChar_002(valoresWebService[2]);
								}
								
								if(campoDocumento.getName().equals("char_003")){
									
									doc.setChar_003(valoresWebService[3]);
								}
								
								if(campoDocumento.getName().equals("char_004")){
									
									doc.setChar_004(valoresWebService[4]);
								}
								
								if(campoDocumento.getName().equals("char_005")){
									
									doc.setChar_005(valoresWebService[5]);
								}
								
								if(campoDocumento.getName().equals("char_006")){
									
									doc.setChar_006(valoresWebService[6]);
								}
								
								if(campoDocumento.getName().equals("char_007")){
									
									doc.setChar_007(valoresWebService[7]);
								}
								
								if(campoDocumento.getName().equals("char_008")){
									
									doc.setChar_008(valoresWebService[8]);
								}
								
								if(campoDocumento.getName().equals("char_009")){
									
									doc.setChar_009(valoresWebService[9]);
								}
								
								if(campoDocumento.getName().equals("char_010")){
									
									doc.setChar_010(valoresWebService[10]);
								}
								
								if(campoDocumento.getName().equals("char_011")){
									
									doc.setChar_011(valoresWebService[11]);
								}
								
								if(campoDocumento.getName().equals("char_012")){
									
									doc.setChar_012(valoresWebService[12]);
								}
								
								if(campoDocumento.getName().equals("char_013")){
									
									doc.setChar_013(valoresWebService[13]);
								}
								
								if(campoDocumento.getName().equals("char_014")){
									
									doc.setChar_014(valoresWebService[14]);
								}
								
								if(campoDocumento.getName().equals("char_015")){
									
									doc.setChar_015(valoresWebService[15]);
								}
								
								if(campoDocumento.getName().equals("char_016")){
									
									doc.setChar_016(valoresWebService[16]);
								}
								
								if(campoDocumento.getName().equals("char_017")){
									
									doc.setChar_017(valoresWebService[17]);
								}
								
								if(campoDocumento.getName().equals("char_018")){
									
									doc.setChar_018(valoresWebService[18]);
								}
								
								if(campoDocumento.getName().equals("char_019")){
									
									doc.setChar_019(valoresWebService[19]);
								}
								
								if(campoDocumento.getName().equals("char_020")){
									
									doc.setChar_020(valoresWebService[20]);
								}
								
								if(campoDocumento.getName().equals("int_001")){
									
									doc.setInt_001(Integer.parseInt(valoresWebService[21]));
								}
								
								if(campoDocumento.getName().equals("int_002")){
									
									doc.setInt_002(Integer.parseInt(valoresWebService[22]));
								}
								
								if(campoDocumento.getName().equals("int_003")){
									
									doc.setInt_003(Integer.parseInt(valoresWebService[23]));
								}
								
								if(campoDocumento.getName().equals("int_004")){
									
									doc.setInt_004(Integer.parseInt(valoresWebService[24]));
								}
								
								if(campoDocumento.getName().equals("int_005")){
									
									doc.setInt_005(Integer.parseInt(valoresWebService[25]));
								}
								
								if(campoDocumento.getName().equals("int_006")){
									doc.setInt_006(Integer.parseInt(valoresWebService[26]));
								}							

								if(campoDocumento.getName().equals(" int_007")){
									
									doc.setInt_007(Integer.parseInt(valoresWebService[27]));
								}
								
								if(campoDocumento.getName().equals("int_008")){
									
									doc.setInt_008(Integer.parseInt(valoresWebService[28]));
								}								

								if(campoDocumento.getName().equals("int_009")){
									
									doc.setInt_009(Integer.parseInt(valoresWebService[29]));
								}
								
								if(campoDocumento.getName().equals("int_010")){
									
									doc.setInt_010(Integer.parseInt(valoresWebService[30]));
								}								

								if(campoDocumento.getName().equals("dec_001")){
									
									doc.setDec_001(Float.parseFloat(valoresWebService[31]));
								}
								
								if(campoDocumento.getName().equals("dec_002")){
									
									doc.setDec_002(Float.parseFloat(valoresWebService[32]));
								}								

								if(campoDocumento.getName().equals("dec_003")){
									
									doc.setDec_003(Float.parseFloat(valoresWebService[33]));
								}
								
								if(campoDocumento.getName().equals("dec_004")){
									
									doc.setDec_004(Float.parseFloat(valoresWebService[34]));
								}								

								if(campoDocumento.getName().equals("dec_005")){
									
									doc.setDec_005(Float.parseFloat(valoresWebService[35]));
								}
								
								if(campoDocumento.getName().equals("dec_006")){
									
									doc.setDec_006(Float.parseFloat(valoresWebService[36]));
								}
								
								if(campoDocumento.getName().equals("dec_007")){
									
									doc.setDec_007(Float.parseFloat(valoresWebService[37]));
								}								

								if(campoDocumento.getName().equals("dec_008")){
									
									doc.setDec_008(Float.parseFloat(valoresWebService[38]));
								}
								
								if(campoDocumento.getName().equals("dec_009")){
									
									doc.setDec_009(Float.parseFloat(valoresWebService[39]));
								}

								if(campoDocumento.getName().equals("dec_010")){									
								
									doc.setDec_010(Float.parseFloat(valoresWebService[40]));
								}
								
								if(campoDocumento.getName().equals("data_001")){
									
									doc.setData_001(formatter.parse(valoresWebService[41]));
								}
								
								if(campoDocumento.getName().equals("data_002")){
									
									doc.setData_002(formatter.parse(valoresWebService[42]));
								}
								
								if(campoDocumento.getName().equals("data_003")){
									
									doc.setData_003(formatter.parse(valoresWebService[43]));
								}
								
								if(campoDocumento.getName().equals("data_004")){
									
									doc.setData_004(formatter.parse(valoresWebService[44]));
								}
								
								if(campoDocumento.getName().equals("data_005")){
									
									doc.setData_005(formatter.parse(valoresWebService[45]));
								}
								
								if(campoDocumento.getName().equals("data_006")){
									doc.setData_006(formatter.parse(valoresWebService[46]));
								}
								
								if(campoDocumento.getName().equals("data_007")){
									
									doc.setData_007(formatter.parse(valoresWebService[47]));
								}
								
								if(campoDocumento.getName().equals("data_008")){
									
									doc.setData_008(formatter.parse(valoresWebService[48]));
								}
								
								if(campoDocumento.getName().equals("data_009")){
									doc.setData_009(formatter.parse(valoresWebService[49]));
								}
								
								if(campoDocumento.getName().equals("data_010")){
									doc.setData_010(formatter.parse(valoresWebService[50]));
								}
								
						}catch(Exception e){
								
								e.printStackTrace();
						}
							
					}
		
				documentoRN.cadastrarDocumentoWebService(doc);					
		
	}

	public DocumentoCadastroRest() {}

	public DocumentoRN getDocumentoRN() {
		return documentoRN;
	}

	public void setDocumentoRN(DocumentoRN documentoRN) {
		this.documentoRN = documentoRN;
	}

	public String[] getValoresWebService() {
		return valoresWebService;
	}

	public void setValoresWebService(String[] valoresWebService) {
		this.valoresWebService = valoresWebService;
	}


}
