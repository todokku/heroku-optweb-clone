package br.com.OPT_WEB_002.layout_empresa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyLayout_Empresa extends LazyDataModel<Layout_Empresa> {

			
	private static final long serialVersionUID = 1L;
	private List<Layout_Empresa> lista;
	
	public LazyLayout_Empresa(List<Layout_Empresa> lista) {
	        
		this.lista = lista;
	}
	
	public LazyLayout_Empresa() {}

	 
	    public Layout_Empresa getRowData(String rowKey) {
	        for(Layout_Empresa layout_Empresa : lista) {
	        	
	        	long id = Long.parseLong(rowKey);
	        	
	            if(layout_Empresa.getId_layout() == BigInteger.valueOf(id) )
	                return layout_Empresa;
	        }
	 
	        return null;
	    }
	    @Override
	    public Object getRowKey(Layout_Empresa layout_Empresa) {
	        return layout_Empresa;
	    }
	 
	    @Override
	    public List<Layout_Empresa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
	        List<Layout_Empresa> data = new ArrayList<Layout_Empresa>();
	 
	        for(Layout_Empresa layout_Empresa : lista) {
	            
	        	boolean match = true;
	 
	            if (filters != null) {
	            	
	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                    
	                	try {
	                        
	                    	String filterProperty = it.next();
	                        Object filterValue = filters.get(filterProperty);
	                        String fieldValue = (String) filters.put(filterProperty, filterValue);
	                        
	                        
	                        if(filterValue == null || fieldValue.contentEquals(layout_Empresa.getId_layout().toString())) {
	                                               
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
	            	
	                data.add(layout_Empresa);
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

		public List<Layout_Empresa> getLista() {
			return lista;
		}

		public void setLista(List<Layout_Empresa> lista) {
			this.lista = lista;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
