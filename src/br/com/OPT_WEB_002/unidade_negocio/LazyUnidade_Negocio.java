package br.com.OPT_WEB_002.unidade_negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyUnidade_Negocio extends LazyDataModel<Unidade_Negocio> {

			
	private static final long serialVersionUID = 1L;
	private List<Unidade_Negocio> lista;
	
	public LazyUnidade_Negocio(List<Unidade_Negocio> lista) {
	        
		this.lista = lista;
	}
	
	public LazyUnidade_Negocio() {}

	 
	    public Unidade_Negocio getRowData(String rowKey) {
	        for(Unidade_Negocio unidade_Negocio : lista) {
	        	
	            if(unidade_Negocio.getCod_unidade() == Integer.parseInt(rowKey))
	                return unidade_Negocio;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Unidade_Negocio unidade_Negocio) {
	        return unidade_Negocio;
	    }
	 
	    @Override
	    public List<Unidade_Negocio> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Unidade_Negocio> data = new ArrayList<Unidade_Negocio>();
	 
	        for(Unidade_Negocio unidade_Negocio : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(unidade_Negocio.getCod_unidade().toString())) {
	                                                
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
	            	
	                data.add(unidade_Negocio);
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

		public List<Unidade_Negocio> getLista() {
			return lista;
		}

		public void setLista(List<Unidade_Negocio> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
