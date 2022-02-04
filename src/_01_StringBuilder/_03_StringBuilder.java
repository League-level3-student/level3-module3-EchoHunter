package _01_StringBuilder;


public class _03_StringBuilder {
	static StringBuilder newString;
    public static String append(String str, char[] characters) {
        newString = new StringBuilder(str);
    	
    	return newString.append(characters).toString();
    }
    
    public static String reverse(String str) {
    	newString = new StringBuilder(str);
    	
    	return newString.reverse().toString();
    }
    
    public static String insert(String str, int index, char newChar) {
    	newString = new StringBuilder(str);
    	
    	return newString.insert(index, newChar).toString();
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	newString = new StringBuilder(str);
    	
    	return newString.delete(startIndex, startIndex).toString();
    }
}