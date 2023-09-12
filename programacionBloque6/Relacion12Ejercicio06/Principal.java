

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {

	private static final String pattern= "([A-Z]{2,}[ ]){3}[1-9]{1}[A-Z]+";
	private static Scanner keyboard= new Scanner (System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Write the file name:");
		String fileName = keyboard.nextLine();
		
		File file= new File (fileName);
		
		deletePreviosCourses();
		
		createDirectories(file);
	}

	private static void deletePreviosCourses() {

		File root=new File(".");
		
		File[] subFolders=root.listFiles();
		
		for (int i = 0; i < subFolders.length; i++) {
			
			
			if ( subFolders[i].isDirectory() && ! subFolders[i].getName().equals("src")) {				
				deleteFilesInDirectory( subFolders[i]);
				
			}
		}
		
	}

	private static void deleteFilesInDirectory(File direc) {
		File[] subFolders=direc.listFiles();
		
		for (int i = 0; i < subFolders.length; i++) {
			if (subFolders[i].isFile()) {
				subFolders[i].delete();
			}
		}
		
	}

	private static void createDirectories(File file) {
		boolean correct=true;
		
		try (BufferedReader readFilter = new BufferedReader(new FileReader (file));) {
			
			String line = readFilter.readLine();
			
			while(line!=null && correct) {
				
				correct=lineTreatment(line);
				
				line = readFilter.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e1) {
			System.out.println("Error");
		}
		
		
	}
	
	private static boolean lineTreatment (String line) {
		
		boolean created=false;
		boolean correct=line.matches(pattern);
		
		if(correct) {
			String[] lineWords = line.split(" ");	
			StringBuilder studentName = new StringBuilder();
			String courseName=lineWords[lineWords.length-1];
		
			studentName.append(lineWords[1] + lineWords[2] + lineWords[0]);		
			
			File mainDirectory = new File(courseName + "/"+studentName.toString());
	
			
			created = mainDirectory.mkdirs();
			
			if(created) {
				System.out.println("Folder sucessfully created " + studentName.toString());
			}
			
			
			// The file is opened in "append mode" not to lose the previous information 
			try ( PrintWriter bufferW= new PrintWriter( new FileWriter ( courseName + "/" + courseName + ".txt" ,true ));){
				
				bufferW.println( lineWords[0] + " " + lineWords[1] + " " + lineWords[2]);
			
				
			}catch ( IOException e) {
				System.out.println("Error, it is not possible no create the file "  + courseName + ".txt");
			}
			
		}
		
		return correct;
	}
}
