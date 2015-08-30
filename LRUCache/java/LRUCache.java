import java.util.*;

public class LRUCache {

    final Map<Integer, Node> cache;
    //time -> key
    final TreeMap<Long, Integer> lru;
    final int capacity;
    public long time = 0;

    public LRUCache(int capacity) {
	cache = new HashMap<>();
	lru = new TreeMap<>();
	this.capacity = capacity;
    }

    public int get(int key) {
	final Node curNode = cache.get(key);
	if(curNode == null) return -1;
	else {
	    lru.remove(curNode.time);
	    curNode.time = ++time;
	    lru.put(curNode.time, key);
	    return curNode.value;
	}
    }

    public void set(int key, int value) {
	final Node oldNode;
	final long newTime = ++time;
	if((oldNode = cache.get(key)) != null) {
	    lru.remove(oldNode.time);
	    oldNode.time = newTime;
	    lru.put(newTime, key);
	    oldNode.value = value;
	}
	else { 
	    if(cache.size() == capacity) {
		final long lowestTime = lru.firstKey();
		final int lowestKey = lru.get(lowestTime);

		cache.remove(lowestKey);
		lru.remove(lowestTime);
	    }
	    final Node newNode = new Node(value, newTime);
	    cache.put(key, newNode);
	    lru.put(newTime, key);
	}
    }

    private class Node {

	int value;
	long time;
	
	public Node(int value, long time) {
	    this.value = value;
	    this.time = time;
	}
    }

}
`
