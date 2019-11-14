package br.com.OPT_WEB_002.filial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyFilial extends LazyDataModel<Filial> {

			
	private static final long serialVersionUID = 1L;
	private List<Filial> lista;
	
	public LazyFilial(List<Filial> lista) {
	        
		this.lista = lista;
	}
	
	public LazyFilial() {}
	 
	    public Filial getRowData(String rowKey) {
	    	
	        for(Filial filial : lista) {
	        	
	            if(filial.getCod_filial() == Integer.parseInt(rowKey))
	                return filial;
	        }
	 
	        return null;
	    }
	    
	    @Override
	    public Object getRowKey(Filial filial) {
	        return filial;
	    }
	 
	    @Override
	    public List<Filial> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Filial> data = new ArrayList<Filial>();
	 
	        for(Filial filial : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty,filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(filial.getCod_filial().toString())) {
	                                                 
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
	            	
	                data.add(filial);
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

		public List<Filial> getLista() {
			return lista;
		}

		public void setLista(List<Filial> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
