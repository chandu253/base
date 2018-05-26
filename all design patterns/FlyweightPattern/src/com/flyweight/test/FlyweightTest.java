package com.flyweight.test;

import com.flyweight.channel.Channel;

public class FlyweightTest {
	public static void main(String[] args) {
		Channel channel = new Channel();
		channel.notify("john", "steve", "Tickets Confirmed", "Happy Journey");
	}
}
