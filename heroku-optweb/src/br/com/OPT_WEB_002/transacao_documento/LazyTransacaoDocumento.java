package br.com.OPT_WEB_002.transacao_documento;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


public class LazyTransacaoDocumento extends LazyDataModel<Transacao_Documento>{
		
	private static final long serialVersionUID = 1L;
	
	private List<Transacao_Documento> lista;
	
	
	public LazyTransacaoDocumento(List<Transacao_Documento> lista) {
		
		this.lista = lista;
					
	}	
	
	   @Override
	    public Transacao_Documento getRowData(String rowKey) {
		   
	        for(Transacao_Documento transacao_Documento : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        		        	
	            if(transacao_Documento.getId_transacao_doc() == BigInteger.valueOf(id)){
	            	
	                return transacao_Documento;
	            }
	        }
	        
	        return null;
	    }
	 
	    @Override
	    public Object getRowKey(Transacao_Documento transacao_Documento) {
	    		    	
	        return transacao_Documento.getId_transacao_doc();
	    }

	    
	    @Override
	    public List<Transacao_Documento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	       	
	    	List<Transacao_Documento> data = new ArrayList<Transacao_Documento>();
	    	    	
	        //filter
	        for(Transacao_Documento transacao_Documento : lista) {
	        	 	        	
	        	boolean match = true;
	        	        	
	            if (filters != null) {
	            
	            	for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	            	
	                	try {
	                		
	                        String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                                                 
	                        String fieldValue = (String) filters.put(filterProperty,filterValue);
	                                                
	                        if(filterValue == null || fieldValue.contentEquals(transacao_Documento.getId_transacao_doc().toString())) {
	                        	match = true;
	                        }
	                        
	                        else {	                    	  
	                            match = false;
	                            break;
	                        }
	                        
	                    } catch(Exception e) {
	                    	
	                        match = false;
	                    }
	                }
	            }
	            
	        if(match) {
	                data.add(transacao_Documento);	            
	        }
	        
	        }
	        //rowCount
	        int dataSize = data.size();
	        this.setRowCount(dataSize);
	 
	        //paginate
	        if(dataSize > pageSize) {
	        	        
	            try {
	                return data.subList(first, first + pageSize);
	           
	            }
	            catch(IndexOutOfBoundsException e) {
	                return data.subList(first, first + (dataSize % pageSize));
	            }
	        }
	        else {
	            return data;
	        }
	      
	        
	 	     
	    }


		public List<Transacao_Documento> getLista() {
			return lista;
		}


		public void setLista(List<Transacao_Documento> lista) {
			this.lista = lista;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		   

}
