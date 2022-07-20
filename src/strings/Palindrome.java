package strings;

public class Palindrome {

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i <= j) {
            System.out.println(s.charAt(i) +  "   " + s.charAt(j));
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (left != right)
                return false;

            j--;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println (isPalindrome("abcd"));
    }


}
