
package br.com.OPT_WEB_002.NodeDocumento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;
import br.com.OPT_WEB_002.campo_adicional.*;
import br.com.OPT_WEB_002.documento.*;
import br.com.OPT_WEB_002.layout_empresa.*;
import br.com.OPT_WEB_002.tipo_documento.*;
import br.com.OPT_WEB_002.transacao.Transacao;
import br.com.OPT_WEB_002.transacao_documento.*;
import br.com.OPT_WEB_002.val_campos_trans_doc.*;

@ManagedBean(name = "nodeDocumentoBean")
@SessionScoped
public class NodeDocumento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String valor;
	private List<String> lista = new ArrayList<String>();
	private BigInteger id;
	private boolean expandirNodeTrans = false;
	private List<byte[]> listaAnexos = new ArrayList<byte[]>();
	private StreamedContent downloadNode = new DefaultStreamedContent();
		
	TreeNode nodePrincipal = new DefaultTreeNode();

	public TreeNode criarDocumento(BigInteger id_doc) throws IllegalArgumentException, ParseException{
		
		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
		Campo_AdicionalRN campo_AdicionalRN = new Campo_AdicionalRN();	
		Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		Tipo_DocumentoRN tipo_DocumentoRN = new Tipo_DocumentoRN();
		Documento documento = new Documento();
		
		DocumentoRN documentoRN = new DocumentoRN();
			
		TreeNode nodeDadosDocumento = new DefaultTreeNode();
		
		TreeNode nodeCamposlayout = new DefaultTreeNode();

		TreeNode nodeCamposDoc = new DefaultTreeNode();

		TreeNode nodeArcDoc = new DefaultTreeNode();

		TreeNode nodeCamposTrans = new DefaultTreeNode();

		TreeNode nodeCamposAdicionais = new DefaultTreeNode();

		TreeNode nodeCamposCampAdic = new DefaultTreeNode();

		TreeNode nodeDadosTransacoes = new DefaultTreeNode();

		TreeNode nodeTransacoes = new DefaultTreeNode();

		TreeNode nodeValorTransDocDataIni = new DefaultTreeNode();

		TreeNode nodeValorTransDocDataFim = new DefaultTreeNode();

		TreeNode nodeValorTransDocHorIni = new DefaultTreeNode();

		TreeNode nodeValorTransDocHorFim = new DefaultTreeNode();	

		TreeNode nodeValorTransDocObs = new DefaultTreeNode();

		TreeNode nodeValorTransDocArquivo = new DefaultTreeNode();

		TreeNode nodeValCampTransDocArquivo = new DefaultTreeNode();
		
		try{
							
			if(tipo != null && valor != null && id_doc == null){
				
				String[] teste = valor.split(",");
				
				for(String val : teste){
					
					lista.add(val);
				}			
									
						for(Layout_Empresa layout_Emp1 : layout_EmpresaRN.listarPorIdTipoDoc(BigInteger.valueOf(Long.parseLong(tipo)))){
							
							for(Documento doc : documentoRN.listarPorIdTipoDoc(layout_Emp1.getId_tipo_doc().getId_tipo_doc())){
							
										java.lang.reflect.Field  field = Documento.class.getDeclaredField(layout_Emp1.getCod_campo());				
										field.setAccessible(true);
										
										for(String campo : lista){
										
											if(String.valueOf(field.get(doc)).equals(campo)){
											
												documento = doc;
																		
											}		
										}
							}
				
						}					
					
				
			}else{
				
				 documento = documentoRN.carregar(id_doc);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		this.id = documento.getId_doc();

		if (documento.getId() != null) {
		
			nodePrincipal = new DefaultTreeNode("ROOT", null);
						
			nodeDadosDocumento = new DefaultTreeNode(new Documento("DADOS", ""), nodePrincipal);
		
			nodeDadosDocumento.setExpanded(true);
			nodeDadosDocumento.setSelectable(false);
		            			
			if (documento.getArquivo() != null) {

				nodeArcDoc = new DefaultTreeNode("doc_arq",new Documento("ANEXO",documento.getNome_arquivo(),documento.getId_doc().toString()),nodeDadosDocumento);
			    nodeArcDoc.setExpanded(true); 	
			}
						
			for (Tipo_Documento tipo_Documento : tipo_DocumentoRN.listarPorIdTipoDoc(documento.getId_tipo_doc().getId_tipo_doc(),documento.getCod_empresa().getCod_empresa(),
				
					documento.getCod_filial().getCod_filial(), documento.getCod_unidade().getCod_unidade())) {

				if (documento.getId_tipo_doc().getId_tipo_doc() != null) {

					nodeCamposDoc = new DefaultTreeNode("tipo_doc",new Documento("TIPO DOCUMENTO", tipo_Documento.getDescricao()), nodeDadosDocumento);

				} else {

					nodeCamposDoc = new DefaultTreeNode("tipo_doc", new Documento("TIPO DOCUMENTO", ""),nodeDadosDocumento);
				}

			}
			
			nodeCamposDoc.setSelectable(false);

			for (Layout_Empresa layout_Empresa : layout_EmpresaRN.listarPorIdTipoDoc(documento.getId_tipo_doc().getId_tipo_doc(), documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(), documento.getCod_unidade().getCod_unidade())) {
														
				if(layout_Empresa.getCod_campo().equals("char_001")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_001()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("char_002")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_002()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("char_003")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_003()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("char_004")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_004()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
							            			

				if(layout_Empresa.getCod_campo().equals("char_005")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_005()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("char_006")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_006()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("char_007")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_007()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("char_008")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_008()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("char_009")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_009()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("char_010")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_010()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("char_011")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_011()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("char_012")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_012()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("char_013")){		
				 nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_013()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("char_014")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_014()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("char_015")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_015()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("char_016")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_016()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("char_017")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_017()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("char_018")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_018()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("char_019")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_019()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("char_020")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),documento.getChar_020()),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("int_001")){	
				
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_001())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("int_002")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_002())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("int_003")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_003())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("int_004")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_004())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("int_005")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_005().toString())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("int_006")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_006().toString())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("int_007")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_007())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("int_008")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_008())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("int_009")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_009())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
							
				if(layout_Empresa.getCod_campo().equals("int_010")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getInt_010())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("dec_001")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_001())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
							
				if(layout_Empresa.getCod_campo().equals("dec_002")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_002())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("dec_003")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_003())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			
				if(layout_Empresa.getCod_campo().equals("dec_004")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_004())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				            			

				if(layout_Empresa.getCod_campo().equals("dec_005")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_005())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
			
				if(layout_Empresa.getCod_campo().equals("dec_006")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_006())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("dec_007")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_007())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			

				if(layout_Empresa.getCod_campo().equals("dec_008")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_008())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
			    			
			
				if(layout_Empresa.getCod_campo().equals("dec_009")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_009())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
							
				if(layout_Empresa.getCod_campo().equals("dec_010")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_010())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					
				if(layout_Empresa.getCod_campo().equals("data_001")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_001())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
			    }
						
				
				if(layout_Empresa.getCod_campo().equals("data_002")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_002())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				    			
				
				if(layout_Empresa.getCod_campo().equals("data_003")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_003())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				
				if(layout_Empresa.getCod_campo().equals("data_004")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_004())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
					            			

			    if(layout_Empresa.getCod_campo().equals("data_005")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getDec_005())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
			    }
							
				if(layout_Empresa.getCod_campo().equals("data_006")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_006())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
							
				if(layout_Empresa.getCod_campo().equals("data_007")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_007())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				
				if(layout_Empresa.getCod_campo().equals("data_008")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_008())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
				    			
				
				if(layout_Empresa.getCod_campo().equals("data_009")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_009())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}
								
				if(layout_Empresa.getCod_campo().equals("data_010")){		
					nodeCamposlayout = new DefaultTreeNode("layout",new Documento(layout_Empresa.getDescricao(),String.valueOf(documento.getData_010())),nodeDadosDocumento);
					nodeCamposlayout.setSelectable(false);
				}					
				
			}
						
			nodeTransacoes = new DefaultTreeNode("transacao", new Transacao_Documento("TRANSAÇÕES", "", ""),nodePrincipal);		
			nodeTransacoes.setSelectable(false);
			nodeTransacoes.setExpanded(true);
			
					for (Transacao_Documento transacao_Documento : transacao_DocumentoRN.listarPorIdDoc(documento.getId_doc(),documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade())) {
						
						if (transacao_Documento.getEstado().contentEquals("Nao Iniciado")) {

						nodeCamposTrans = new DefaultTreeNode("transacao_valores",new Transacao_Documento(transacao_Documento.getId_transacao().getId_transacao() + " - "+ transacao_Documento.getId_transacao().getDescricao(), "", ""),nodeTransacoes);
						nodeCamposTrans.setSelectable(false);
						
						
						
						} else {

							if (transacao_Documento.getEstado().contentEquals("Iniciado")) {

								nodeCamposTrans = new DefaultTreeNode("transacao_valores",new Transacao_Documento(transacao_Documento.getId_transacao().getId_transacao() + " - "+ transacao_Documento.getId_transacao().getDescricao(),transacao_Documento.getEstado() + " - "+ transacao_Documento.getData_ini().toString() + "  "+ transacao_Documento.getHorario_ini().toString(),""),nodeTransacoes);
								nodeCamposTrans.setSelectable(false);
								
							
							} else {

								if (transacao_Documento.getEstado().contentEquals("Parado")) {
									
									nodeCamposTrans = new DefaultTreeNode("transacao_valores",new Transacao_Documento(transacao_Documento.getId_transacao().getId_transacao()+ " - " + transacao_Documento.getId_transacao().getDescricao(), "", ""),nodeTransacoes);
									nodeCamposTrans.setSelectable(false);	
									
									
								} else {

									if (transacao_Documento.getEstado().contentEquals("Finalizado")) {
										nodeCamposTrans = new DefaultTreeNode("transacao_valores",new Transacao_Documento(transacao_Documento.getId_transacao().getId_transacao() + " - "+ transacao_Documento.getId_transacao().getDescricao(),transacao_Documento.getEstado() + " - "+ transacao_Documento.getData_fim().toString() + "  "+ transacao_Documento.getHorario_fim().toString(),""),nodeTransacoes);
										nodeCamposTrans.setSelectable(false);
										
									}
								}
							}
						}
						
						nodeCamposTrans.setExpanded(expandirNodeTrans);
						nodeDadosTransacoes = new DefaultTreeNode("trans_doc", new Transacao_Documento("DADOS", "", ""),nodeCamposTrans);
						nodeDadosTransacoes.setSelectable(true);
						nodeDadosTransacoes.setExpanded(true);
				    
						if (transacao_Documento.getData_ini() != null) {
							nodeValorTransDocDataIni = new DefaultTreeNode("trans_doc", new Transacao_Documento("DATA INICIAL",transacao_Documento.getData_ini().toString(), ""), nodeDadosTransacoes);
						} else {
							nodeValorTransDocDataIni = new DefaultTreeNode("trans_doc",new Transacao_Documento("DATA INICIAL", "", ""), nodeDadosTransacoes);
						}

						nodeValorTransDocDataIni.setSelectable(false);
						nodeValorTransDocDataIni.setExpanded(true);

						if (transacao_Documento.getHorario_ini() != null) {
							nodeValorTransDocHorIni = new DefaultTreeNode("trans_doc",new Transacao_Documento("HORARIO INICIAL",transacao_Documento.getHorario_ini().toString(), ""),nodeDadosTransacoes);
						} else {
							nodeValorTransDocHorIni = new DefaultTreeNode("trans_doc",new Transacao_Documento("HORARIO INICIAL", "", ""), nodeDadosTransacoes);
						}
					
						nodeValorTransDocHorIni.setSelectable(false);
						nodeValorTransDocHorIni.setExpanded(true);

						if (transacao_Documento.getData_fim() != null) {
							nodeValorTransDocDataFim = new DefaultTreeNode("trans_doc",new Transacao_Documento("DATA FINAL", transacao_Documento.getData_fim().toString(), ""),nodeDadosTransacoes);
						} else {
							nodeValorTransDocDataFim = new DefaultTreeNode("trans_doc",new Transacao_Documento("DATA FINAL", "", ""), nodeDadosTransacoes);
						}
						
						nodeValorTransDocDataFim.setSelectable(false);
						nodeValorTransDocDataFim.setExpanded(true);			
												
						if (transacao_Documento.getHorario_fim() != null) {
							nodeValorTransDocHorFim = new DefaultTreeNode("trans_doc",new Transacao_Documento("HORARIO FINAL",transacao_Documento.getHorario_fim().toString(), ""),nodeDadosTransacoes);
						} else {
							nodeValorTransDocHorFim = new DefaultTreeNode("trans_doc",new Transacao_Documento("HORARIO FINAL", "", ""), nodeDadosTransacoes);
						}
						nodeValorTransDocHorFim.setSelectable(false);
						nodeValorTransDocHorFim.setExpanded(true);

						if (transacao_Documento.getObservacao() != null) {nodeValorTransDocObs = new DefaultTreeNode("trans_doc",new Transacao_Documento("OBSERVACAO", transacao_Documento.getObservacao(), ""),nodeDadosTransacoes);
						} else {
							nodeValorTransDocObs = new DefaultTreeNode("trans_doc",new Transacao_Documento("OBSERVAÇÃO", "", ""), nodeDadosTransacoes);
						}

						nodeValorTransDocObs.setSelectable(false);
						nodeValorTransDocObs.setExpanded(true);

						if (transacao_Documento.getArquivo() != null) {
	                     
							nodeValorTransDocArquivo = new DefaultTreeNode("trans_doc_arq",new Transacao_Documento("ANEXO", transacao_Documento.getNome_arquivo(),transacao_Documento.getId_transacao_doc().toString()),nodeDadosTransacoes);
							nodeValorTransDocArquivo.setSelectable(true);
						}
					

						nodeCamposAdicionais = new DefaultTreeNode("camp",new Transacao_Documento("CAMPOS ADICIONAIS", "", ""), nodeDadosTransacoes);
						nodeCamposAdicionais.setExpanded(true);
						nodeCamposAdicionais.setSelectable(true);
						
						for (Campo_Adicional campo_Adicional : campo_AdicionalRN.listarPorIdTransCodEmCodFiCodUni(transacao_Documento.getId_transacao().getId_transacao())) {
							
							if (val_Campos_Trans_DocRN.carregarPorIdCampAdic(campo_Adicional.getId_camp_adic(),transacao_Documento.getId_transacao_doc(),transacao_Documento.getCod_empresa().getCod_empresa(),transacao_Documento.getCod_filial().getCod_filial(),transacao_Documento.getCod_unidade().getCod_unidade()).isEmpty()) {
								
								nodeCamposCampAdic = new DefaultTreeNode("camp_adic",new Transacao_Documento(campo_Adicional.getId_camp_adic().toString() + " - "+ campo_Adicional.getDescricao(), "", ""),nodeCamposAdicionais);
								nodeCamposCampAdic.setSelectable(false);
								nodeCamposCampAdic.setExpanded(true);
							}

							for (Val_Campos_Trans_Doc val_Campos_Trans_Doc2 : val_Campos_Trans_DocRN.carregarPorIdCampAdic(
								campo_Adicional.getId_camp_adic(), transacao_Documento.getId_transacao_doc(),campo_Adicional.getCod_empresa().getCod_empresa(),
								campo_Adicional.getCod_filial().getCod_filial(),campo_Adicional.getCod_unidade().getCod_unidade())) {

								nodeCamposCampAdic = new DefaultTreeNode("camp_adic",new Transacao_Documento(
								campo_Adicional.getId_camp_adic().toString() + " - "+ campo_Adicional.getDescricao(),
								val_Campos_Trans_Doc2.getResultado(), ""),nodeCamposAdicionais);
								
								nodeCamposCampAdic.setSelectable(false);
								nodeCamposCampAdic.setExpanded(true);

								if (val_Campos_Trans_Doc2.getArquivo() != null) {
									
									nodeValCampTransDocArquivo = new DefaultTreeNode("val_camp_arq",new Transacao_Documento("ANEXO", val_Campos_Trans_Doc2.getNome_arquivo(),
									val_Campos_Trans_Doc2.getId_val_camp_trans_doc().toString()),nodeCamposAdicionais);
									
									nodeValCampTransDocArquivo.setSelectable(true);
									nodeValCampTransDocArquivo.setExpanded(true);
								} else {
									
									nodeValCampTransDocArquivo = new DefaultTreeNode("val_camp_arq",new Transacao_Documento("ANEXO", "", ""), nodeCamposAdicionais);
								    nodeValCampTransDocArquivo.setExpanded(true);
								}

							} /** FimForValCamp **/

							/** FimForCampAdic **/
						}
					} /** FimForTransacaoDocumento**/
			           
				return nodePrincipal;			
			

		} else {

			return null;
		}

	}


	public String expandeNodeTransRastreabilidade(){
		
		if(expandirNodeTrans == false){
			expandirNodeTrans = true;
			return "Expandir";
		}else{
			
			expandirNodeTrans = false;
			return "Voltar";
		}
		
		
	}
	
	
	public List<byte[]> retornaAnexos(BigInteger id){
		
	
		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
		DocumentoRN documentoRN = new DocumentoRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		
		for(Documento documento : documentoRN.listarPorIdDoc(id)){
			
			if(listaAnexos.isEmpty()){
		
			if(!documento.getNome_arquivo().equals("")){
			
					System.out.println("msg2");
                    System.out.println(documento.getNome_arquivo());
					InputStream in = new ByteArrayInputStream(documento.getArquivo());
					System.out.println("msg3");
					StreamedContent streamedContent = new DefaultStreamedContent(in, documento.getExtensao_arq(),documento.getNome_arquivo());
					System.out.println("msg4");
					listaAnexos.add(documento.getArquivo());
			}
								
				for(Transacao_Documento transacao : transacao_DocumentoRN.listarPorIdDoc(id,documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade())){
			
					if(!transacao.getNome_arquivo().equals("")) {
				
						System.out.println("msg1");
						System.out.println(transacao.getId_transacao_doc());
												
						System.out.println("msg2");

						InputStream in = new ByteArrayInputStream(transacao.getArquivo());
						System.out.println("msg3");
						StreamedContent streamedContent = new DefaultStreamedContent(in, transacao.getExtensaoarq(),transacao.getNome_arquivo());
						System.out.println("msg4");
						listaAnexos.add(transacao.getArquivo());
						System.out.println("msg5");
					}
					
					
						for(Val_Campos_Trans_Doc val_Campos_Trans_Doc : val_Campos_Trans_DocRN.listarPorIdTransDoc(transacao.getId_transacao_doc(),transacao.getCod_empresa().getCod_empresa(),transacao.getCod_filial().getCod_filial(),transacao.getCod_unidade().getCod_unidade())){
						
							if(val_Campos_Trans_Doc.getNome_arquivo() != null) {
								InputStream in = new ByteArrayInputStream(val_Campos_Trans_Doc.getArquivo());
								System.out.println("msg3");
								StreamedContent streamedContent = new DefaultStreamedContent(in, val_Campos_Trans_Doc.getExtensaoarq(),val_Campos_Trans_Doc.getNome_arquivo());
								System.out.println("msg4");
								listaAnexos.add(val_Campos_Trans_Doc.getArquivo());
								System.out.println("msg5");
							}
									
										
						}							
				}
			}
		}
		
	return listaAnexos;
	}
	
	public String redirecionaRastreabilidade() {
		
		return "/restrito/rastreabilidade/rastreabilidade.xhtml?faces-redirect=true";
	}
	  	 
	
	public void nomearq() {
		
		System.out.println(downloadNode.getName());
	}
	
	public NodeDocumento(){}


	public TreeNode getNodePrincipal() {
		return nodePrincipal;
	}


	public void setNodePrincipal(TreeNode nodePrincipal) {
		this.nodePrincipal = nodePrincipal;
	}



	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<String> getLista() {
		return lista;
	}


	public void setLista(List<String> lista) {
		this.lista = lista;
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public boolean isExpandirNodeTrans() {
		return expandirNodeTrans;
	}


	public void setExpandirNodeTrans(boolean expandirNodeTrans) {
		this.expandirNodeTrans = expandirNodeTrans;
	}


	public StreamedContent getDownloadNode() {
		return downloadNode;
	}


	public void setDownloadNode(StreamedContent downloadNode) {
		this.downloadNode = downloadNode;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}

