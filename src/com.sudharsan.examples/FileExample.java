package com.sudharsan.examples;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;

public class FileExample {
	
	static public void main(final String... arg) throws IOException {
		
		final Path path = Paths.get("/Users/sudharsanthumatti/Desktop/ipcu-passcode-and-wifi.mobileconfig");
		
		byte[] data = Files.readAllBytes(path);
		
		System.out.println(Arrays.toString(data));
	}
}
