package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word. 
 * 
 * Input: "word"
 * Output: ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Solution:
 * Use recursion to generate a list like : [word, wor1, wo1d, wo11, w1rd, w1r1, w11d, w111, 1ord, 1or1, 1o1d, 1o11, 11rd, 11r1, 111d, 1111]
 * The for each word, consolidate the numbers
 */
public class GeneralizedAbbreviation {
    static List<String> list = new ArrayList<String>();

    public static List<String> generateAbbreviations(String word) {
        recurse (word, "");
        List<String> newlist = new ArrayList<String>();
        
        for (String s : list) {
            newlist.add(consolidate(s));
        }
        
        return newlist;
    }
    
    public static void recurse (String s, String t) {
        if (s.length() == 0) {
            list.add(t);
            return;
        }
        
        char c = s.charAt(0);
        recurse (s.substring(1), t + c);
        recurse (s.substring(1), t + "1");
    }
    
    public static String consolidate (String word) {
        int i = 0;
        String s = "";
        
        while (i < word.length()) {
            char c = word.charAt(i);
            
            if (Character.isDigit(c)) {
                int sum = Character.getNumericValue(c);
                
                int j = i + 1;
                while (j < word.length()) {
                    char c2 = word.charAt(j);
                    if (Character.isDigit(c2)) {
                        sum = sum + Character.getNumericValue(c2);
                    } else 
                        break;
                    j++;
                }
                
                s = s + sum;
                i=j;
            } else {
                s = s + c;
                i++;
            }
            
    
        }
        
        return s;    
    }
	public static void main(String[] args) {
		System.out.println(generateAbbreviations("word"));
	}

}
