package hashtable;

import java.util.LinkedList;

class Cell<K, V>{
	private K key;
	private V value;
	public Cell(K key, V val){
		this.key = key;
		this.value = val;
	}
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public boolean equivalent(Cell<K,V> c){
		return equivalent(c.getKey());
	}
	public boolean equivalent(K k){
		return key.equals(k);
	}
}


public class HashTable<K, V> {
	private final int MAX_SIZE = 10;
	LinkedList<Cell<K,V>>[] items;
	
	public HashTable(){
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[MAX_SIZE];
	}
	
	public int hashCodeOfKey(K key){
		return key.toString().length() % items.length;
	}
	public void put (K key, V value){
		int x = hashCodeOfKey(key);
		if(items[x] == null){
			items[x] = new LinkedList<Cell<K, V>>();
		}
		
		LinkedList<Cell<K, V>> collided = items[x];
		for( Cell<K, V> c: collided){
			if(c.equivalent(key)){
				collided.remove(c);
				break;
			}
		}
		
		items[x].add(new Cell(key, value));
	}
	
	public V getValue(K key){
		int x = hashCodeOfKey(key);
		
		if(items[x] == null){
			return null;
		}
		
		LinkedList<Cell<K, V>> collided = items[x];
		for( Cell<K, V> c: collided){
			if(c.equivalent(key)){
				return c.getValue();
			}
		}
		return null;
	}
}
