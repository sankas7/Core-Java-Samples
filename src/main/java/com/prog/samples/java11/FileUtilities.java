package com.prog.samples.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilities {

	
	public static void main(String args[]) throws IOException
	{
		Path path=Paths.get("./resources/sample.txt");
		
		String sampleStr=Files.readString(path);
		
		System.out.println(sampleStr);
		
		Path writePath=Paths.get("./resources/sample-new.txt");
		Files.writeString(writePath, sampleStr.replace("Line", "Lines"));
		
	}
	
}
