package com.hcl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class accessFile {
	
	//File textFile = new File(constants.filePath);
	
	public void startAccessFile() throws IOException{
		
		File textFile = new File(constants.filePath);
		Scanner input = new Scanner(System.in);
		String overwriteChoice = "";
		String addLine = "";
		List<String> addInputs = new ArrayList<String>();		
		
		System.out.println("File Handling Practice");
		
		// Request user to overwrite previous text file
		do {
			
			System.out.println("Would you like to create new file or access previous file?");
			System.out.println("NOTE: Creating new file will overwrite previous file");
			System.out.println("To create new file enter 'yes' or 'no' - will keep current file:");
			overwriteChoice = (input.nextLine().toLowerCase());
			System.out.println(overwriteChoice);
			
		} while ( !(overwriteChoice.equals("yes")) && !(overwriteChoice.equals("no")));
		
		// check for previous file / if user requested to overwrite then overwrite
		if (textFile.exists()) {
			System.out.println("-----Previous File does exist");
			if (overwriteChoice.equals("yes")) {
				textFile.delete();
				System.out.println("-----Previous File deleted, new file created");
				textFile.createNewFile();
			}
		} else {
			textFile.createNewFile();
		}
		
		// allow user to enter multiple lines until user enters "finish"  // APPEND 
		do {
			System.out.println("Please enter a line into text file, type 'finish' to stop:");
			addLine = input.nextLine().toLowerCase();
			if ( !addLine.equals("finish")) {
				addInputs.add(addLine + "\n");
			}
			
		} while (!addLine.equals("finish"));
		
		input.close();
		
		
		// WRITE to textfile
		FileOutputStream out = new FileOutputStream(textFile, true );
		for (String inputStrings: addInputs) { out.write(inputStrings.getBytes() ); }
		
		out.close();
		
		System.out.println("-----Current File contains:");
		
		
		// READ from textfile
		List<String> readLines = Collections.emptyList();
		
	
		readLines = Files.readAllLines(Paths.get(textFile.getAbsolutePath()), StandardCharsets.UTF_8);
		
		for (String lines: readLines) {
			System.out.println(lines);
		}
		
		
	}
	
}