package com.kenpritchard.seeds.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kenpritchard.seeds.domain.GloveRequest;

public class GloveServiceTest {
	String testDataFile = "src/test/resources/raw_sentences.txt";
	GloveRequest request;
	
	@Before
	public void setup() {
		List<String> inputStrings = new ArrayList<String>();
		try (BufferedReader input = new BufferedReader(new FileReader(this.testDataFile))){
			String line = input.readLine();
			while(line != null) {
				inputStrings.add(line);
				line  = input.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.request = new GloveRequest();
		this.request.setInputStrings(inputStrings);
		this.request.setTargetWord("foo");
	}
	
	@Test
	public void testGetSimilarStrings() {
		GloveService service = new GloveService();
		this.request.setTargetWord("day");
		Collection<String> results = service.getSimilarStrings(this.request);
		System.out.println(String.format("Result Size: %s", results.size()));
		for(String result : results) {
			System.out.println(String.format("Token: %s", result));
		}
	}
}
