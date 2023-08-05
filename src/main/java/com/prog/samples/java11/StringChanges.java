package com.prog.samples.java11;

public class StringChanges {

	public static void main(String args[]) {
		System.out.println("".isBlank());
		System.out.println(" ".isBlank());
		System.out.println(" Space".strip());
		System.out.println("Space ".stripTrailing());
		"I am line\nLine1\nLine2\nLine3".lines().forEach(System.out::println);
		System.out.println("I am %s , my age is %d".formatted("Pramit", 34));
		System.out.println("I am here".transform(s -> s.toLowerCase()));

	}
}
