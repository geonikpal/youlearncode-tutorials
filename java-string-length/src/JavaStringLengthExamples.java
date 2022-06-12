public class JavaStringLengthExamples {

    public static void main(String[] args) {
        simpleExample();
		
		System.out.println();
		
		lengthEqualityExample("red", "blue");
		System.out.println();
		lengthEqualityExample("green", "brown");
		
		System.out.println();
		
		isEmptyString("Dimitris");
		isEmptyString("");
    }
    
    private static void simpleExample() {
        String clh = "Code Learn Hub";
        String numbers = "123456";
        String symbols = "!@#$%^&*()_+-=.,";
		String specialCharacters = "\n\r\0";
        
        System.out.println("clh length: " + clh.length());
        System.out.println("numbers length: " + numbers.length());
        System.out.println("symbols length: " + symbols.length());
		System.out.println("specialCharacters length: " + specialCharacters.length());
    }
	
	private static void lengthEqualityExample(String firstString, String secondString) {
		int firstStringLength = firstString.length();
		int secondStringLength = secondString.length();
		
		System.out.println("Comparing \"" + firstString + "\" and \"" + secondString + "\":");
		
		if (firstStringLength == secondStringLength) {
			System.out.println("The Strings have equal length.");
		} else {
			System.out.println("Their length isn't equal.");
        }
    }
	
	private static void isEmptyString(String theString) {
		if (theString.length() == 0) {
			System.out.println("The string \"" + theString + "\" is empty.");
		} else {
			System.out.println("The string \"" + theString + "\" is not empty.");
        }
    }
}