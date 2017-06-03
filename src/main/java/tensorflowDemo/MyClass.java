package tensorflowDemo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class MyClass {

    private final String importantField;
    private final String anotherField;

    public MyClass(final String equalField, final String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    public String getEqualField() {
    	
    	Map<String, String> d = new Hashtable<>();
    	Map<String, String> d2 = new HashMap<>();
    	SortedMap<String, String> d3 = new TreeMap<>();
    	
    	
    	NavigableMap<String, String> dd4 = new TreeMap<>();
    	dd4.put("S", "DD");
    	
    	
    	
    	NavigableSet<String> dd5 = new TreeSet<>();
    	
    	List<String> d4 = new ArrayList<>();
    	List<String> d5 = new Vector<>();
    	List<String> d6 = new LinkedList<>();
    	
    	Queue<String> d7 = new LinkedList<>();
    	Deque<String> d8 = new LinkedList<>();
    	Queue<String> d9 = new PriorityQueue<>();
    	
    	Set<String> d10 = new HashSet<>();
    	Set<String> d11 = new LinkedHashSet<>();
    	Set<String> d12 = new TreeSet<>();
    	
        return importantField;
    }

    public String getAnotherField() {
        return anotherField;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MyClass other = (MyClass) obj;
        if (importantField == null) {
            if (other.importantField != null)
                return false;
        } else if (!importantField.equals(other.importantField))
            return false;
        return true;
    }

}


