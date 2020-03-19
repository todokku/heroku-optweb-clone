package br.com.OPT_WEB_002.campo_adicional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCampo_Adicional extends LazyDataModel<Campo_Adicional> {

			
	private static final long serialVersionUID = 1L;
	private List<Campo_Adicional> lista;
	
	public LazyCampo_Adicional(List<Campo_Adicional> lista) {
	        
		this.lista = lista;
	}
	
	public LazyCampo_Adicional() {}

	 
	    public Campo_Adicional getRowData(String rowKey) {
	        for(Campo_Adicional campo_Adicional : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        	
	            if(campo_Adicional.getId_camp_adic() == BigInteger.valueOf(id))
	                return campo_Adicional;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Campo_Adicional campo_Adicional) {
	        return campo_Adicional;
	    }
	 
	    @Override
	    public List<Campo_Adicional> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Campo_Adicional> data = new ArrayList<Campo_Adicional>();
	 
	        for(Campo_Adicional campo_Adicional : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(campo_Adicional.getId_camp_adic().toString())) {
	                                               
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
	            	
	                data.add(campo_Adicional);
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

		public List<Campo_Adicional> getLista() {
			return lista;
		}

		public void setLista(List<Campo_Adicional> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
