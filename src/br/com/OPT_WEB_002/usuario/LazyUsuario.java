package br.com.OPT_WEB_002.usuario;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyUsuario extends LazyDataModel<Usuario> {

			
	private static final long serialVersionUID = 1L;
	private List<Usuario> lista;
	
	public LazyUsuario(List<Usuario> lista) {
	        
		this.lista = lista;
	}
	
	public LazyUsuario() {}

	 
	    public Usuario getRowData(String rowKey) {
	        for(Usuario usuario : lista) {
	        
	        	long id = Long.parseLong(rowKey);
	        	
	        	
	            if(usuario.getId_usuario() == BigInteger.valueOf(id))
	                return usuario;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Usuario usuario) {
	        return usuario;
	    }
	 
	    @Override
	    public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Usuario> data = new ArrayList<Usuario>();
	 
	        for(Usuario usuario : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	 
	                        if(filterValue == null || fieldValue.contentEquals(usuario.getId_usuario().toString())) {
	                                               
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
	            	
	                data.add(usuario);
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

		public List<Usuario> getLista() {
			return lista;
		}

		public void setLista(List<Usuario> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
