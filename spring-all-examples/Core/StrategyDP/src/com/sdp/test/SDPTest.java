package com.sdp.test;

import java.io.IOException;

import com.sdp.beans.IMessageConverter;
import com.sdp.beans.MessageWriter;
import com.sdp.helper.AppFactory;

public class SDPTest {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		MessageWriter messageWriter = (MessageWriter) AppFactory.createObject("messageWriter.class");
		IMessageConverter messageConverter = (IMessageConverter) AppFactory.createObject("messageConverter.class");
		messageWriter.setMessageConverter(messageConverter);

		messageWriter.writeMessage("Strategy Design Pattern, made my classes loosely coupled");
	}
}





