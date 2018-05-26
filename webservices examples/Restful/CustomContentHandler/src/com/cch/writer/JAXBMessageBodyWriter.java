package com.cch.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

/*@Provider
@Produces(MediaType.APPLICATION_XML)*/
public class JAXBMessageBodyWriter implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object obj, Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType) {
		if (classType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream os) throws IOException, WebApplicationException {
		JAXBContext jContext = null;
		Marshaller marshaller = null;

		try {
			System.out.println("writeTo()");
			jContext = JAXBContext.newInstance(classType);
			marshaller = jContext.createMarshaller();
			marshaller.marshal(object, os);
			os.close();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}
