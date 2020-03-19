package br.com.OPT_WEB_002.tipo_documento_transacao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTipo_Documento_Transacao extends LazyDataModel<Tipo_Documento_Transacao> {

		
	private static final long serialVersionUID = 1L;
	private List<Tipo_Documento_Transacao> lista;
	
	public LazyTipo_Documento_Transacao(List<Tipo_Documento_Transacao> lista) {
	        
		this.lista = lista;
	}
	
	public LazyTipo_Documento_Transacao() {}

	 
	    public Tipo_Documento_Transacao getRowData(String rowKey) {
	        for(Tipo_Documento_Transacao tipo_Documento_Transacao : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        	
	            if(tipo_Documento_Transacao.getId_tipo_doc_trans() == BigInteger.valueOf(id))
	                return tipo_Documento_Transacao;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Tipo_Documento_Transacao tipo_Documento_Transacao) {
	        return tipo_Documento_Transacao;
	    }
	 
	    @Override
	    public List<Tipo_Documento_Transacao> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Tipo_Documento_Transacao> data = new ArrayList<Tipo_Documento_Transacao>();
	 
	        for(Tipo_Documento_Transacao tipo_Documento_Transacao : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(tipo_Documento_Transacao.getId_tipo_doc_trans().toString())) {
	                                                 
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
	            	
	                data.add(tipo_Documento_Transacao);
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

		public List<Tipo_Documento_Transacao> getLista() {
			return lista;
		}

		public void setLista(List<Tipo_Documento_Transacao> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
