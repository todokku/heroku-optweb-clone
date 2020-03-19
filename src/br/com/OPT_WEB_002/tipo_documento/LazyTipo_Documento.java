package br.com.OPT_WEB_002.tipo_documento;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTipo_Documento extends LazyDataModel<Tipo_Documento> {

			
	private static final long serialVersionUID = 1L;
	private List<Tipo_Documento> lista;
	
	public LazyTipo_Documento(List<Tipo_Documento> lista) {
	        
		this.lista = lista;
	}
	
	public LazyTipo_Documento() {}

	 
	    public Tipo_Documento getRowData(String rowKey) {
	        for(Tipo_Documento tipo_Documento : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        		        	
	        	
	            if(tipo_Documento.getId_tipo_doc() == BigInteger.valueOf(id))
	                return tipo_Documento;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Tipo_Documento tipo_Documento) {
	        return tipo_Documento;
	    }
	 
	    @Override
	    public List<Tipo_Documento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Tipo_Documento> data = new ArrayList<Tipo_Documento>();
	 
	        for(Tipo_Documento tipo_Documento : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(tipo_Documento.getId_tipo_doc().toString())) {
	                                                 
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
	            	
	                data.add(tipo_Documento);
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

		public List<Tipo_Documento> getLista() {
			return lista;
		}

		public void setLista(List<Tipo_Documento> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
