package br.com.OPT_WEB_002.documento;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.sun.research.ws.wadl.Doc;

import br.com.OPT_WEB_002.layout_empresa.Layout_Empresa;
import br.com.OPT_WEB_002.layout_empresa.Layout_EmpresaRN;
import br.com.OPT_WEB_002.usuario.Usuario;

public class LazyDocumento extends LazyDataModel<Documento> {

	private static final long serialVersionUID = 1L;
	private List<Documento> lista2;
	private List<Documento> lista3;
	private Integer dataSize;
	private Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
	private BigInteger id_tipo_doc;
	private Usuario usuario = new Usuario();
	
 
	public LazyDocumento(List<Documento> lista) {
		
        this.lista2 = new ArrayList<Documento>();
		this.lista2 = lista;		
		
	}

	public LazyDocumento() {}

	public Documento getRowData(String rowKey) {
		
		for (Documento documento : lista2) {

			String id = documento.getId_doc().toString();

			if (id.equals(rowKey)) {

				return documento;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(Documento documento) {

		return documento.getId_doc();
	}


    @Override
    public List<Documento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
      	
    	List<Documento> data2 = new ArrayList<Documento>();
       	
        for(Documento documento : lista2) {
        
        	boolean match = true;
 
            if (filters != null) {
            	
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    
                	try {
                		 
                    	String filterProperty = it.next();    
                    	Object filterValue = filters.get(filterProperty); 
                    	String fieldValue = null;
                    	                    
                    	if(filterProperty.equals("id_doc")){
                    	                    
                    		fieldValue = String.valueOf(documento.getId_doc());
                    	}
                       	
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                
                        	match = true;
                        	
                        }else {
                    	    
                            match = false;
                            break;
                        }
                                                        
                    } catch(Exception e) {
                    	e.printStackTrace();
                        match = false;
                    }
                }
            }
            
           if(match){
        	  
        	   
            	data2.add(documento);
            	
        	   
           }
       
                
        }
           

        //rowCount
        int dataSize = data2.size();
        this.setRowCount(dataSize);
        
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data2.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data2.subList(first, first + (dataSize % pageSize));
            }
            
        }else {
        		        	
            return data2;
        }
    	
    }

	public List<Documento> getLista2() {
		return lista2;
	}

	public void setLista2(List<Documento> lista2) {
		this.lista2 = lista2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public Layout_EmpresaRN getLayout_EmpresaRN() {
		return layout_EmpresaRN;
	}

	public void setLayout_EmpresaRN(Layout_EmpresaRN layout_EmpresaRN) {
		this.layout_EmpresaRN = layout_EmpresaRN;
	}

	public BigInteger getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(BigInteger id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Documento> getLista3() {
		return lista3;
	}

	public void setLista3(List<Documento> lista3) {
		this.lista3 = lista3;
	}



}
