package com.pe.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.pe.beans.Book;

public class PETest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/pe/common/application-context.xml"));
		Book book = factory.getBean("book", Book.class);
		System.out.println("publishedDate : " + book.getPublishedDate());
		System.out.println("site :" + book.getSite());
		System.out.println("Toc : " + book.getToc());
		System.out.println("authors : " + book.getAuthors());
		
	}
}





