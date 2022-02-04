package arrays;

import java.util.LinkedList;

/**
 * My own HastTable implementation
 */
public class HashList {
	private final static int TABLE_SIZE = 32;

	LinkedList<Entry>[] table = new LinkedList[TABLE_SIZE];
    
	private int calculateHash(String key) {
	    int mod = key.hashCode() % TABLE_SIZE;
	    System.out.println ("mod - " + mod);
	    return mod < 0 ? mod + TABLE_SIZE : mod;
	}

	public Object get(String key) {
		Object retval = null;
	    int bucket = calculateHash(key);
	    LinkedList<Entry> entries = table[bucket];
	    
	    if (entries != null) {
		    for (Entry entry : entries) {
		   	 	if (key.equals(entry.getKey())) {
		   	 		retval = entry.getValue();
		   	 		break;
		   	 	}
		    }
	    }
	    
	    return retval;
	}

	public void put(String key, Object value) {
		int index = calculateHash(key);
		Entry newEntry = new Entry(key, value);
		
		LinkedList<Entry> entries = table[index];
		if (entries == null) {
			entries = new LinkedList<Entry>();
			entries.add(newEntry);
		    table[index] = entries;
		} else {
			// collision
		    for (Entry entry : entries) {
		   	 	if (key.equals(entry.getKey())) {
		   	 		// if the key already exists, replace it. cannot have dupes in a hashmap.
		   	 		entry.setValue(value);
		   	 		return;
		   	 	}
		    }
			
		    entries.add(newEntry);
		}
	}
	
	
	public void displayAll() {
		for (int bucket=0; bucket  < TABLE_SIZE; bucket++) {
		    LinkedList<Entry> entries = table[bucket];
		    System.out.print (bucket + " -");
		    
		    if (entries != null) {
			    for (Entry entry : entries) {
			    	System.out.print (" (" + entry.getKey() + "  " + entry.getValue() + ")");
			    }
		    }
		    
		    System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		HashList myHashList = new HashList();
		
		myHashList.put("Neel", "1");
		myHashList.put("Roman", "2");
		myHashList.put("Roman", "3");
		myHashList.put("Girish", "5");
		myHashList.put("Daphne", "77");
		myHashList.put("Gaurav", "23");
		myHashList.put("Bill", "1");
		myHashList.put("Ty", "190");

		
		
		//System.out.println (myHashList.get("Neel"));
		//System.out.println (myHashList.get("Roman"));
		
		myHashList.displayAll();
	}
}

