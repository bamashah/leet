package arrays;

public class Entry {
    private String key;
    private Object value;

    Entry(String key, Object value) {
          this.key = key;
          this.value = value;
    }     

    public String getKey() {
          return key;
    }

    public void setValue(Object value) {
    	this.value = value;
    }

    public Object getValue() {
          return value;
    }
}