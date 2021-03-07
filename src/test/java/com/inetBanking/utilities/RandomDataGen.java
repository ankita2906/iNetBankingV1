package com.inetBanking.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGen {

	public static String randomStringGen()
	{
		return RandomStringUtils.randomAlphabetic(5);
		 
	}
	
	public static String randomPhoneNumberGen()
	{
		{
		    // First three numbers. It should not contain 8 or 9 
		     int num1, num2, num3;
		     // set2 and set3 of the phone number
		     int set2, set3;
		     // create object of Random class
		     Random generator = new Random();
		     // generates first 3 digit number
		     num1 = generator.nextInt(3)+7; //this is between 7-9 inclusive so i did any number (10-7) say 2 gthen add 7 
		     num2 = generator.nextInt(10);
		     num3 = generator.nextInt(10);
		     
		     // Set2 of the phone number should not be greater than 742.
		     // Randomize 643 gives a number between 0 to 642.
		     // To make it 3-digit number, we have to add 100 to it.
		     set2 = generator.nextInt(643) + 100;
		     
		     // Set3 of the phone number can be any 4-digit number
		     // Randomization of 8999 gives 0 to 8998. Adding 1000 to it 
		     // gives 4-digit number 
		     set3 = generator.nextInt(8999) + 1000;
		     String num= String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3)
		     +String.valueOf(set2)+String.valueOf(set3);
		     return num;
			}
	}
}
