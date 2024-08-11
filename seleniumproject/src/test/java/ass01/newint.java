package ass01;

import java.util.HashMap;
import java.util.Map;

public class newint {

	public static void main(String[] args) {
		
		 
        String str = "I love my india";
        
        // Convert the string to lowercase to treat 'I' and 'i' as the same character
        str = str.toLowerCase();
        
        // Create an array to store counts of each character
        int[] count = new int[256]; // Assuming ASCII characters
        
        // Convert the string to a char array
        char[] arr = str.toCharArray();
        
        // Iterate through each character in the array
        for(char c : arr) {
            // Ignore spaces
            if(c != ' ') {
                count[c]++;
            }
        }
        
        // Print the character counts
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                System.out.println((char)i + "=" + count[i] + ",");
            }
        }
    }
}
