package com.tests.stream;

import java.util.ArrayList;
import java.util.List;

public class RemovingObjectFrom {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("A");
		list.add("B");
		
		// ConcurrentModificationException...
		list.stream().forEach(list::remove);
				
	}
	
}
