package com.lea.leet;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class RegexFinder {

	public static void main(String[] args) throws IOException {

		Pattern pattern = Pattern.compile("(\\s+from\\s+(\\w+\\.)*\\w+\\s*\\w*\\s*,\\s*(?:\\w+\\.)*\\w+)|(\\s+from\\s+(?:\\w+\\.)*\\w+)|(\\s+join\\s+(?:\\w+\\.)*\\w+\\s+(?:\\w+\\s)*\\s*on\\s+)", CASE_INSENSITIVE);

//		String path = "F:\\tsapi\\svc\\src\\main\\java\\com\\qingqing";
//		String path = "F:\\cr-svc\\svc\\src\\main\\java\\com\\qingqing";
//		String path = "F:\\taApi\\ta-api\\src\\main\\java\\com\\qingqing";
//		String path = "F:\\ta-ordersvc\\svc\\src\\main\\java\\com";
//		String path = "F:\\tcsvc\\tc-svc\\src\\main\\java";
//		String path = "F:\\traapi\\tra-svc\\src\\main\\java\\com";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\op";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\ta";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\tsweb";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\cr-web";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\tcweb";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\traweb";
//		String path = "C:\\Users\\cuijin03\\IdeaProjects\\amb-op";
		String path = "C:\\Users\\cuijin03\\IdeaProjects\\amb-svc";



		Set<String> set = new HashSet<>();

		List<File> files = iterateOverFiles(Objects.requireNonNull(new File(path).listFiles()));

		for (File file : files) {
			StringBuilder builder = new StringBuilder();
			try (Stream<String> lines = Files.lines(Paths.get(file.getPath()))) {
				lines.map(builder::append).collect(Collectors.toList());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String s = builder.toString();
			Matcher matcher = pattern.matcher(s);
			while (matcher.find()) {
				String str = matcher.group(0);
				String[] split = str.split("\\s+");
				for (String it : split) {
					if (it.matches("\\w+") && isValid(it)) {
						set.add(it);
					}
				}
			}
		}

		set.retainAll(TableNameContainer.teachingPlanTableSet);

		for (String s : set) {
			System.out.println(s);
		}

	}

	public static List<File> iterateOverFiles(File[] files){
		List<File> result = new LinkedList<>();
		for (File file : files) {
			if(file.isDirectory()){
				result.addAll(iterateOverFiles(Objects.requireNonNull(file.listFiles())));
			}else{
				boolean ifMapper = file.getName().toLowerCase().endsWith("xml");
				if(ifMapper){
					result.add(file);
				}
			}
		}
		return result;
	}

	public static boolean isValid(String str) {
		return !str.equalsIgnoreCase("from")
				&& !str.equalsIgnoreCase("join")
				&& !str.equalsIgnoreCase("on");
	}




}
