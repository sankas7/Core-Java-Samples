package com.prog.samples.java14;

public class SwitchExpression {

	
	public static  String findDayForWeek(int day)
	{
		String dayOfWeek=switch(day) {
		case 0 -> "Sunday";
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "Wednesday";
		default -> throw new IllegalArgumentException("Invalid day");
		};
		return dayOfWeek;
	}
	public static void main(String args[])
	{
		System.out.println(findDayForWeek(3));
	}
}
