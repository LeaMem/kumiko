package com.lea.kumiko.midware.others.customTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {

		String str = "ssdfalkwierudfgndfghzxxvqerqpwerovai";
		String ctmk = str;

		Pattern compile = Pattern.compile("(\\w)(.*?)\\1+");
		Matcher matcher = compile.matcher(str);
		System.out.println(matcher.find());

		String it;
		while (!(it = str.replaceAll("(\\w)(.*?)\\1+", "$1$2")).equals(str)) {
			System.out.println(it);
			str = it;
		}

		System.out.println("it is : " + it);
		System.out.println("ctmk is : " + ctmk);
		System.out.println("str is : " + str);
	}

}
