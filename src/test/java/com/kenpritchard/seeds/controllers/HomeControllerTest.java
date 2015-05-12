package com.kenpritchard.seeds.controllers;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kenpritchard.seeds.Application;
import com.kenpritchard.seeds.domain.GloveRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class HomeControllerTest {
	
	@Autowired
	HomeController homeController;
	
	@Test
	public void testLearnText() {
		String testDataFile = "src/test/resources/raw_sentences.txt";
		GloveRequest request;
		List<String> inputStrings = new ArrayList<String>();
		try (BufferedReader input = new BufferedReader(new FileReader(testDataFile))){
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
		request = new GloveRequest();
		request.setInputStrings(inputStrings);
		request.setTargetWord("day");
		assertNotNull(this.homeController.learnText(request));
	}
}
