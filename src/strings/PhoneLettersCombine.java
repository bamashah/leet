package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) can be seen in keypad.png
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class PhoneLettersCombine {
    public static List<String> result = new ArrayList<String>();
    
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        
        String[] mappings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> strings = new ArrayList<String>();
        
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int num = Character.getNumericValue(c);
            if (num < 2) return result;
            
            strings.add(mappings[num]);
        }
        
        combine (strings,"");
        return result;
    }
    
    
    public static void combine (ArrayList<String> strings, String combo) {
        
        if (strings.isEmpty()) {
            result.add(combo);
            return;
        }
        
        ArrayList<String> newStrings = new ArrayList<String>(strings);
        String s = newStrings.remove(0);

        for (int i = 0; i < s.length(); i++) {
            String newCombo = new String(combo);
            newCombo = newCombo + s.charAt(i);
            combine (newStrings, newCombo);
        }
    }
    
	public static void main(String[] args) {
		System.out.println (letterCombinations("34")); // 1001110

	}    
    
}
