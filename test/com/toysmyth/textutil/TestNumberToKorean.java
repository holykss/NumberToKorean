package com.toysmyth.textutil;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestNumberToKorean {

	@Test
	public void testEquals() {
		assertEquals("영", NumberToKorean.convertNumber2Korean(0));
		assertEquals("일", NumberToKorean.convertNumber2Korean(1));
		assertEquals("삼만이천칠백육십칠", NumberToKorean.convertNumber2Korean(32767));
		assertEquals("오억천만", NumberToKorean.convertNumber2Korean(510000000));
		assertEquals("오억천만십일", NumberToKorean.convertNumber2Korean(510000011));
		assertEquals("삼만육천칠백", NumberToKorean.convertNumber2Korean(36700));
	}

	@Test
	public void testNotEquals() {
		assertNotEquals("영", NumberToKorean.convertNumber2Korean(0+1));
		assertNotEquals("일", NumberToKorean.convertNumber2Korean(1+1));
		assertNotEquals("삼만이천칠백육십칠", NumberToKorean.convertNumber2Korean(32767+1));
		assertNotEquals("오억천만", NumberToKorean.convertNumber2Korean(510000000+1));
		assertNotEquals("오억천만십일", NumberToKorean.convertNumber2Korean(510000011-100));
		assertNotEquals("삼만육천칠백", NumberToKorean.convertNumber2Korean(36700+1));
	}

}
