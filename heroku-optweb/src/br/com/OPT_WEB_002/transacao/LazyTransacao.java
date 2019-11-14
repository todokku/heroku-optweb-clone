package br.com.OPT_WEB_002.transacao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTransacao extends LazyDataModel<Transacao> {
			
	private static final long serialVersionUID = 1L;
	private List<Transacao> lista;
	
	public LazyTransacao(List<Transacao> lista) {
	        
		this.lista = lista;
	}
	
	public LazyTransacao() {}

	 
	    public Transacao getRowData(String rowKey) {
	        for(Transacao transacao : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        	
	        	
	            if(transacao.getId_transacao() == BigInteger.valueOf(id))
	                return transacao;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Transacao transacao) {
	        return transacao;
	    }
	 
	    @Override
	    public List<Transacao> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Transacao> data = new ArrayList<Transacao>();
	 
	        for(Transacao transacao: lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        
	                        System.out.println(filterProperty);
	                        System.out.println(filterValue.toString());
	                        if(filterValue == null || fieldValue.contentEquals(transacao.getId_transacao().toString())) {
	                                               
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
	            	
	                data.add(transacao);
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

		public List<Transacao> getLista() {
			return lista;
		}

		public void setLista(List<Transacao> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
