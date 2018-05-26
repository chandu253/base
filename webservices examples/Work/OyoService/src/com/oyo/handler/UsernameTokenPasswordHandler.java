package com.oyo.handler;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class UsernameTokenPasswordHandler implements CallbackHandler {
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (((WSPasswordCallback) callbacks[i]).getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
				String un = ((WSPasswordCallback)callbacks[i]).getIdentifier();
				if(un.equals("john")) {
					((WSPasswordCallback)callbacks[i]).setPassword("welcome1");
				}
			}
		}
	}
}





