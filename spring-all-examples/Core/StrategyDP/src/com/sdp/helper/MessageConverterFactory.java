package com.sdp.helper;

import com.sdp.beans.HTMLMessageConverterImpl;
import com.sdp.beans.IMessageConverter;
import com.sdp.beans.PDFMessageConverterImpl;

public class MessageConverterFactory {
	public static IMessageConverter createMessageConverter(String type) {
		IMessageConverter messageConverter = null;

		if (type.equals("html")) {
			messageConverter = new HTMLMessageConverterImpl();
		} else if (type.equals("pdf")) {
			messageConverter = new PDFMessageConverterImpl();
		}

		return messageConverter;
	}
}
