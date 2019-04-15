package edu.israel.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Predicate {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		
		java.util.function.Predicate<String> predicate = x -> x.startsWith("T");
		
		System.out.println(list.stream().filter(predicate).collect(Collectors.toList()));
	}
	
}
