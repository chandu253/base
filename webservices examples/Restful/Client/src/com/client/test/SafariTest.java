package com.client.test;

import com.client.dto.Acknowledge;
import com.client.dto.Book;
import com.client.invoker.Safari;
import com.client.invoker.SafariService;

public class SafariTest {
	public static void main(String[] args) {
		/*SafariService safari = new SafariService();
		String message = safari.addBook("isbn2", "let us c", "yaswanth");
		System.out.println(message);*/
		
		Safari safari = new Safari();
		Book book = new Book();
		book.setIsbn("isbn39");
		book.setTitle("let us c");
		book.setAuthor("yaswanth");
		
		Acknowledge ack = safari.addBook(book);
		System.out.println(ack.getReqNo());
	}
}










