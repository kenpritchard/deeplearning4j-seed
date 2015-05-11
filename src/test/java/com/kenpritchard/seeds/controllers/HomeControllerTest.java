package com.kenpritchard.seeds.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kenpritchard.seeds.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class HomeControllerTest {
	
	@Autowired
	HomeController homeController;
	
	@Test
	public void testGetGreeting() {
		assertNotNull(this.homeController.getGreeting());
	}
}
