package com.hms.dep;
import com.hmsext.dep.*;
public class HMSExtensionRunner {
  public static void main(String[] args) {
    Messenger messenger = new Messenger();
    String message = messenger.getMessage();
    System.out.println(message);
  }
}