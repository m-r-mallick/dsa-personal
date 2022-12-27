import java.util.*;
class MyHashSet {
    private LinkedList<Integer>[] chs;
    private int size;
    public MyHashSet() {
        size = 100;
        chs = new LinkedList[size];
        Arrays.fill(chs, new LinkedList<Integer>());
    }
    
    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (chs[index].contains(key)) return;
        chs[index].add(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (chs[index].contains(key)) chs[index].removeFirstOccurrence(key);
    }
    
    public boolean contains(int key) {
        return chs[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class CustomHashSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
}
