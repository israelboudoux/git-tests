package edu.israel.regex;

import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		String regex = ".*|\\s*/default\\('/.*'\\)/";
		
		regex = "\\w{1,}\\s*\\|\\s*default\\('\\w{1,}'\\)\\s*";
		
		testAndPrint(regex, "wcas_dls_processor_write_check_wait | default('2s')"); // ok
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default('2s')"); // ok
		testAndPrint(regex, "wcas_dls_processor_write_check_wait|default('2s')"); // ok
		testAndPrint(regex, "wcas_dls_processor_write_check_wait|default('2s') "); // ok
		
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |   default('')"); // does not has value for the default function
		testAndPrint(regex, "wcas_dls_processor_write_check_wait"); // it does not has the pipe + default('...')
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default('2s)"); // not closed q.m.
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default(2s)"); // does not has the q.m.
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default("); // incorrect the parenthesis
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default)"); // incorrect the parenthesis 
		testAndPrint(regex, "wcas_dls_processor_write_check_wait |default()"); // does not has q.m. with 
		testAndPrint(regex, "wcas_dls_processor_write_check_wait default()"); // does not has the pipe
		
		// the followings does not has some word before the pipe or etc.
		testAndPrint(regex, "| default('')"); 
		testAndPrint(regex, "|       default('')"); 
		testAndPrint(regex, "|       default('2s')");  
		testAndPrint(regex, "|default('')"); 
		testAndPrint(regex, "default('')"); 
		testAndPrint(regex, "|       default(2s)");
	}
	
	private static void testAndPrint(String regex, String input) {
		System.out.println(Pattern.matches(regex, input) + " ===> " + input);
	}
}
