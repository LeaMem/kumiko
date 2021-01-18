package com.lea.leet;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class TestRegex {

	public static void main(String[] args) {
		String str = " from \n" +
				" tt info";

		Pattern.compile("(\\s+from\\s+(?:\\w+\\.)*\\w+\\s*\\w*\\s*,\\s*(?:\\w+\\.)*\\w+)|(\\s+from\\s+(?:\\w+\\.)*\\w+)|(\\s+join\\s+(?:\\w+\\.)*\\w+\\s+(?:\\w+\\s)*\\s*on\\s+)");
		Pattern pattern = Pattern.compile("FROM\\s+([^ ,]+)(\\s*,\\s*([^ ,]+))*\\s+", CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()){
			System.out.println(matcher.group(0));
		}
	}


}
