package com.singleton.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.singleton.pattern.TimeZoneL;

public class SerializeTest {
	public static void main(String[] args)
			throws InterruptedException, FileNotFoundException, IOException, ClassNotFoundException {
		/*TimeZoneL timeZone = TimeZoneL.getInstance();
		serialize(timeZone, "d:\\timezone.ser");*/
		TimeZoneL tzl1 = (TimeZoneL) deSerialize("d:\\timezone.ser");
		TimeZoneL tzl2 = (TimeZoneL) deSerialize("d:\\timezone.ser");

		System.out.println("tzl1 == tzl2 : " + (tzl1 == tzl2));

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
