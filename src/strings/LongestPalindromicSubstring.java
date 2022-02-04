package strings;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Input: "babad", Output: "bab"
 * Input: "cbbd", Output: "bb"
 *
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            String temp = "" + s.charAt(i);
            
            for (int j = i+1; j < s.length(); j++) {
                temp = temp + s.charAt(j);
                if ((temp.length() > longest.length()) && isPalin(temp))
                    longest = temp;
            }    
        } 
        
        return longest;
    }
    
    public static boolean isPalin (String s) {
        char[] arr = s.toCharArray();
        
        int l = 0;
        int r = arr.length - 1;
        
        while (l <= r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            
            l++;
            r--;            
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		System.out.println (longestPalindrome ("cbbd"));
		System.out.println (longestPalindrome ("babad"));
		System.out.println (longestPalindrome ("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));		
		System.out.println (longestPalindrome ("babaddtattarrattatddetartrateedredividerb"));
	}

}
