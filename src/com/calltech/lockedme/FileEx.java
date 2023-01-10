package com.calltech.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileEx {

	private static String path;
	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		path = "D:\\caltech\\";
		sc = new Scanner(System.in);

		while (true) {
			System.out.println("Choose one of the following options:\n\n1. show all files in ascending order"
					+ "\n2. submenu\n3. exit of the program");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				showAllFiles();
				break;
			case 2:
				subMenu();
				break;
			case 3:
				exitProgram();
				break;
			
			}
		}

	}

	private static void subMenu() throws IOException {

		while (true) {
			System.out.println("Choose one of the following options:\n\n1. add the files"
					+ "\n2. delete the files\n3. search the file\n4. exit");

			int option = sc.nextInt();
			switch (option) {
			case 1:
				addFiles();
				break;
			case 2:
				deleteTheFiles();
				break;
			case 3:
				searchFile();
				break;
			case 4:
				return;

			default:
				break;
			}
		}

	}

	private static void searchFile() {
		System.out.println("enter the file to search");
		String filenamesearch=sc.next();
		File file=new File(path);
		//display operation
		File filename[]=file.listFiles();
		//for-each
		int flag=0;
		for(File ff:filename) {
			if(ff.getName().equals(filenamesearch)) {
				flag=1;
				break;
			}
			else {
				flag=0;
			}
		}
		
		if(flag==1) {
			System.out.println("file is found");
		}
		else {
			System.out.println("file is not found");
		}
	}

	private static void addFiles() throws IOException {
	 System.out.println("enter the file name");
		String filename = sc.next();
		String finalpath = path + filename;
		System.out.println(finalpath);
		// create a file
		File file = new File(finalpath);
		boolean res = file.createNewFile();
		if (res != true) {
			System.out.println("file is not created");
		} else {
			System.out.println("file is created ");
		}

	}

	private static void exitProgram() {
		System.exit(0);

	}

	private static void deleteTheFiles() {
		System.out.println("enter the file name");
		String filename=sc.next();
		String finalpath=path+filename;
		System.out.println(finalpath);
		
		File file=new File(finalpath);
		//delete operation
		file.delete();
		System.out.println("file gets deleted");

	}

	private static void showAllFiles() {
		// File file=new File(path);
		// display operation
		File file = new File(path);
		File filename[] = file.listFiles();
		// for-each
		System.out.println("the list of files in asscending order in the " + path + "is");
		for (File ff : filename) {
			System.out.println(ff.getName());
		}

	}

}
