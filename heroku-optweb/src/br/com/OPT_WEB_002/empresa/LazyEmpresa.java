package br.com.OPT_WEB_002.empresa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyEmpresa extends LazyDataModel<Empresa> {

			
	private static final long serialVersionUID = 1L;
	private List<Empresa> lista;
	
	public LazyEmpresa(List<Empresa> lista) {
	        
		this.lista = lista;
	}
	
	public LazyEmpresa() {}

	 
	    public Empresa getRowData(String rowKey) {
	        for(Empresa empresa : lista) {
	        	
	            if(empresa.getCod_empresa() == Integer.parseInt(rowKey))
	                return empresa;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Empresa empresa) {
	        return empresa;
	    }
	 
	    @Override
	    public List<Empresa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Empresa> data = new ArrayList<Empresa>();
	 
	        for(Empresa empresa : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty,filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(empresa.getCod_empresa().toString())) {
	                           	                     
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
	            	
	                data.add(empresa);
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

		public List<Empresa> getLista() {
			return lista;
		}

		public void setLista(List<Empresa> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
