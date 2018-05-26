package com.ser.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ser.bean.Subject;

public class SerTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Subject subject = new Subject();
		subject.setSubjectCode("Java");
		subject.setDuration(180);
		//serialize(subject, "d:\\subject.ser");
		Subject dSubject = (Subject) deSerialize("d:\\subject.ser");
		System.out.println(dSubject);
	}

	private static void serialize(Object obj, String fileName) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(obj);
		oos.close();
	}

	private static Object deSerialize(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		Object obj = null;

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		obj = ois.readObject();
		return obj;
	}

}
