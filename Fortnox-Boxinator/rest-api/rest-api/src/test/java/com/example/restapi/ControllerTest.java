package com.example.restapi;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void testShipcost() {
		assertEquals("80.0 SEK",Controller.calcShipcost("20", "China"));
		assertEquals("26.0 SEK",Controller.calcShipcost("20", "Sweden"));
		assertEquals("43.0 SEK",Controller.calcShipcost("5", "Brazil"));
		assertEquals("576.0 SEK",Controller.calcShipcost("80", "Australia"));
		assertNotEquals("576.0 SEK",Controller.calcShipcost("-80", "Australia"));
		assertEquals("Something went wrong, negative weigth or invalide Country!",Controller.calcShipcost("80", "fel land"));
		System.out.println("testShipcost done");
	}

	
}
