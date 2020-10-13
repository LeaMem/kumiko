package com.lea.kumiko.midware.others.customTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class FileReader {

	public static void main(String[] args) throws IOException {

		String path = "G:\\ajaxfileupload.code-search";

		try (BufferedReader br = new BufferedReader(new java.io.FileReader(new File(path)))) {

			String preLine;
			String line;
			while((line = br.readLine()) != null){
				if(!(line.length() > 0)){
					continue;
				}
				String trim = line.trim();
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
