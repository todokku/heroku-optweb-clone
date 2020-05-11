package br.com.OPT_WEB_002.documento;


import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import br.com.OPT_WEB_002.layout_empresa.*;


public class LazyDocumento extends LazyDataModel<Documento> {

	private static final long serialVersionUID = 1L;
	private List<Documento> lista2;	
	private Integer dataSize;
	private Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
	private BigInteger id_tipo_doc;
	
 
	public LazyDocumento(List<Documento> lista) {
		
        this.lista2 = new ArrayList<Documento>();       
		this.lista2 = lista;		
		
	}

	public LazyDocumento() {}

	public Documento getRowData(String rowKey) {
		
		for (Documento documento : lista2) {

			String id = documento.getId_doc().toString();

			if (id.equals(rowKey)) {

				return documento;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(Documento documento) {

		return documento.getId_doc();
	}


   @Override
    public List<Documento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
      	
    	List<Documento> data2 = new ArrayList<Documento>();
    	   	      	
       for(Documento documento : lista2) {
      
        	/**	try {
        			
					Field field = documento.getClass().getDeclaredField(layout_Empresa.getCod_campo());
					

	        		if(String.valueOf(field.get(documento)).equals(layout_Empresa.getValor_filtro())){
	        			
	        			lista3.add(documento);
	        		}
	        				        			
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}**/
        		      		
        	
        	
        	boolean match = true;
 
            if (filters != null) {
            	
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    
                	try {
                		 
                    	String filterProperty = it.next();    
                    	Object filterValue = filters.get(filterProperty); 
                    	String fieldValue = null;
                    	System.out.println("teste1");
                    	for(Layout_Empresa layout_Empresa : layout_EmpresaRN.listarPorFlagFiltro(documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade())){
                    		System.out.println("teste2");		
	                    	if(filterProperty.equals(layout_Empresa.getCod_campo())){
	                    		System.out.println("teste3");
								Field campo =	documento.getClass().getDeclaredField(layout_Empresa.getCod_campo());
								campo.setAccessible(true);								              		
	                    		fieldValue = String.valueOf(campo.get(documento));		                    		
	                    	}
	                    
                    	}
                    	                    	                    	
                        if(filterValue == null || fieldValue.toString().toLowerCase().startsWith(filterValue.toString())  || fieldValue.toString().startsWith(filterValue.toString()) ) {
                
                        	match = true;
                        	
                        }else {
                    	    
                            match = false;
                            break;
                        }
                                                        
                    } catch(Exception e) {
                    	
                    	e.printStackTrace();
                        match = false;
                    }
                }
            }
            
            
           if(match){
        	   
        	   	
            	data2.add(documento);            	
        	   
           }
           
                
        }
           
        //rowCount
        int dataSize = data2.size();
        this.setRowCount(dataSize);
         
        //paginate
        if(dataSize > pageSize) {
            try {
                return data2.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data2.subList(first, first + (dataSize % pageSize));
            }
            
        }else {
        		        	
            return data2;
        }
    	
    }

	public List<Documento> getLista2() {
		return lista2;
	}

	public void setLista2(List<Documento> lista2) {
		this.lista2 = lista2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public Layout_EmpresaRN getLayout_EmpresaRN() {
		return layout_EmpresaRN;
	}

	public void setLayout_EmpresaRN(Layout_EmpresaRN layout_EmpresaRN) {
		this.layout_EmpresaRN = layout_EmpresaRN;
	}

	public BigInteger getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(BigInteger id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

}
