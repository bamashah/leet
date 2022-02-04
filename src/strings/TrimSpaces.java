package strings;

public class TrimSpaces {

	public static String normalizeI(String query) {
		char[] word = query.toCharArray();
		char[] result = new char[word.length];
	      int j = 0;

		for (int i = 0; i < word.length; i++) {
			if (i == 0) {
				if (word[i] == ' ') {
					continue;
				} else {
					result[j] = word[i];
					j++;
				}
			} else if (i == word.length-1) {
				if (word[i] == ' ') {
					continue;
				}else {
					result[j] = word[i];
				}
			} else {
				if (word[i] == ' ') {
					if (word[i-1] != ' ' && word[i+1] == ' ') {
						result[j] = word[i];
						j++;						
					} else if (word[i-1] != ' ' && word[i+1] != ' ') {
						result[j] = word[i];
						j++;
					} else 
					      continue;
				} else {
						result[j] = word[i];
						j++;
				}
			}	

		}
		
		return new String(result);
	}
	
	public static String normalizeII(String query) {
		String trimmedSt = query.trim();
		return trimmedSt.replaceAll("\\s+"," ");
	}
	
	public static void main(String[] args) {
		String st = "  Hello My    World    P  ";
		
		System.out.println(normalizeI(st));
		System.out.println(normalizeII(st));
	}

}
