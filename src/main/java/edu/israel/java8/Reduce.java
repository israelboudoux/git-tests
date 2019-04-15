package edu.israel.java8;

import java.util.ArrayList;
import java.util.List;

public class Reduce {
	
	public static void main(String[] args) {
		List<String> testList = new ArrayList<>();
		
		testList.add("a");
		
		System.out.println("===> "+ testList.stream().reduce((r, s) -> r + ", " + s).get()); //a
		
		testList.add("b");
		testList.add("c");
		
		System.out.println("===> "+ testList.stream().reduce((r, s) -> r + ", " + s).get()); //a,b,c
		
		testList.clear();
		
		System.out.println("===> "+ testList.stream().reduce("0", (r, s) -> r + ", " + s)); 
	}
	
}
