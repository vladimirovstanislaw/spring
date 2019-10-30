package core;

import java.util.HashMap;
import java.util.Map;

public class Runnable {
	public static void main(String[] args) {
		B b = new B();
		System.out.println("Before change b.ii = " + b.ii);

		Map<String, B> map = new HashMap<>();

		map.put("b", b);

		System.out.println("HashMap B() before change b.ii = " + map.get("b").ii);

		b.ii = 10;
		System.out.println("After change b.ii = " + b.ii);
		System.out.println("HashMap B() after change b.ii = " + map.get("b").ii);
	}
}
