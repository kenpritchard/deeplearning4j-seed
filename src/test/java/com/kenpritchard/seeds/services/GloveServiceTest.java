package com.kenpritchard.seeds.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GloveServiceTest {
	String testDataFile = "src/test/resources/raw_sentences.txt";
	List<String> inputStrings;
	
	@Before
	public void setup() {
		this.inputStrings = new ArrayList<String>();
		try (BufferedReader input = new BufferedReader(new FileReader(this.testDataFile))){
			String line = input.readLine();
			while(line != null) {
				this.inputStrings.add(line);
				line  = input.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetSimilarStrings() {
		GloveService service = new GloveService();
		String targetWord = "day";
		Collection<String> results = service.getSimilarStrings(this.inputStrings, targetWord);
		System.out.println(String.format("Result Size: %s", results.size()));
		for(String result : results) {
			System.out.println(String.format("Token: %s", result));
		}
	}
}
