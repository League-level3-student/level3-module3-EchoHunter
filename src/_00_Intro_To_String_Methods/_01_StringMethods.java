package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if(s1.length() > s2.length()) {
        	return s1;
        }
    	return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
        String substring = "underscores";
        String ret = "";
       if(s.contains(substring)) {
    	   s = s.replace(' ','_');
   		ret = s;
       }
    	else {
    		ret = s;
    	}

        return ret;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
        char ret1 = s1.trim().charAt(s1.trim().length()-1);
        char ret2 = s2.trim().charAt(s2.trim().length()-1);
        char ret3 = s3.trim().charAt(s3.trim().length()-1);
      
    	if ((ret1<ret2)&&(ret1<ret3)) {
			return s1.trim();
		}
    	else if ((ret2<ret1)&&(ret2<ret3)) {
			return s2.trim();
		}
    	else if ((ret3<ret1)&&(ret3<ret2)) {
    		return s3.trim();
    	}
    	return null;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
        int returnInt = 0;
    	for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				returnInt += Integer.parseInt(""+s.charAt(i));
			}
		}
        
    	return returnInt;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int stringCount = 0;
        int index = 0;
        index = s.indexOf(substring);
        while( index != -1 ) {
            stringCount++;
            index = s.indexOf(substring, index + substring.length());
        }
    	return stringCount;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        
        byte[] text = new byte[s.length()];
        char [] c = s.toCharArray();
        for (int i = 0; i < text.length; i++) {
			text[i] = (byte) c[i];
		}
       
    	
    	return Utilities.encrypt(text, (byte)key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
         	
    	return Utilities.decrypt(s,(byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        int endcount = 0;
        String [] s1 = s.split(" ");
    	String checkEnd;
        for (int i = 0; i < s1.length; i++) {
			if (s1[i].length()-substring.length() > 0) {
        	checkEnd = s1[i].substring(s1[i].length()-substring.length(),s1[i].length());
			
        	if (checkEnd.contains(substring)) {
			endcount++;
		}
			}
        }
				
			
			
		
    	
    	return endcount;
}

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        int retDist = 0;
    	int fIndex = 0;
    	int lIndex = 0;
    	for (int i = 0; i < s.length()-substring.length(); i++) {
			if(s.substring(i, i+substring.length()).equals(substring)){
				fIndex = i;
				break;
			}
		}
    	for (int i = s.length(); i > 0; i--) {
			if (s.substring(i-substring.length(),i).equals(substring)) {
				lIndex = i-substring.length();
				break;
			}
		}
    	retDist = lIndex - (fIndex+substring.length());
    	return retDist;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        String replacer = " ";
        String replacer1 = ":";
        String replacer2 = "!";
        String replacer3 = "?";
        String replacer4 = ".";
        String replacer5 = ",";
        String replacer6 = "-";
        if(s.contains(replacer)) {
     	   s = s.replace(replacer,"");
        }
        if(s.contains(replacer1)) {
      	   s = s.replace(replacer1,"");
         }
        if(s.contains(replacer2)) {
      	   s = s.replace(replacer2,"");
         }
        if(s.contains(replacer3)) {
      	   s = s.replace(replacer3,"");
         }
        if(s.contains(replacer4)) {
      	   s = s.replace(replacer4,"");
         }
        if(s.contains(replacer5)) {
      	   s = s.replace(replacer5,"");
         }
        if(s.contains(replacer6)) {
      	   s = s.replace(replacer6,"");
         }
        s=s.toLowerCase();
        char[] test = s.toCharArray();
        int trueCounter = 0;
    	for (int i = 0; i < (s.length())/2; i++) {
    		if (test[i] == test[s.length()-1-i]) {
				trueCounter++;
			}
		}
    	
    	if (trueCounter == (s.length())/2) {
			return true;
		}
    	return false;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
