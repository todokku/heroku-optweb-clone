package br.com.OPT_WEB_002.NodeDocumento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@FacesConverter(value = "streamedConverter", forClass = NodeDocumento.class)
	public class ConversorStreamed implements Converter {

	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
						
		return value.toString();
	}

	public Object getAsObject(FacesContext context, UIComponent component, byte[] value) {
		
		
		InputStream in = new ByteArrayInputStream(value);
		StreamedContent streamedContent = new DefaultStreamedContent(in,"xlsx","teste");
		
		return streamedContent;
	
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	  
	}


