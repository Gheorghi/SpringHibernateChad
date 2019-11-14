package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	// private String fileName ="C:/repositories/git/SpringHibernateU/SpringHibernateChad/spring-demo-annotations/src/FortuneData.txt"
	private String fileName = "C:/repositories/git/SpringHibernateU/SpringHibernateChad/spring-demo-annotations/src/FortuneData.txt";
	private List<String> theFortunes;

	// create a random number generator
	private Random myRandom = new Random();

	public FileFortuneService() {
		System.out.println(">> FileFortuneService: inside default constructor");
	}

	@PostConstruct
	public void loadTheFortunesFile() throws FileNotFoundException, IOException {
		System.out.println(">> FileFortune: insude loadTheFortuneFile");

		File theFile = new File(fileName);

		System.out.println("Reading fortunes form the file: " + theFile);
		System.out.println("File exists: " + theFile.exists());

		theFortunes = new ArrayList<String>();
		
		try(BufferedReader br =new BufferedReader(new FileReader(theFile))) {
			String tempLine;
			
			while ((tempLine = br.readLine())!= null) {
				theFortunes.add(tempLine);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());
		return theFortunes.get(index);
	}

}
