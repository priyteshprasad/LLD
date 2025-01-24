package LRUcache2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, Node<K, V>> cache;
    Node<K, V> head;
    Node<K, V> tail;
    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<K, Node<K, V>>(3);
        this.head = new Node<K, V>(null, null);
        this.tail = new Node<K, V>(null, null);
        this.tail.next = head;
        this.head.prev = tail;
    }

    /**
     * Most recently used will be close to head
     * head --- node1,      node2, ...       --- tail
     * head---- head.prev,  head.prev.prev   
     * node1.next  node1    node1.prev
     */

     public V get(K key){
        // if not present return null
        Node<K, V> node = cache.get(key);
        if(node == null) return null;
        //  if present, take if out of the chain, and add to the head
        removeNode(node);
        addNodeToHead(node);
        return node.value;
     }

     public void put(K key, V value){
         // if existing value is update
            // update the cache, remove the node from chain and add to the head

        Node<K, V> node = cache.get(key);
        if(node != null){
            node.value = value;
            // cache.put(key, node);
            removeNode(node);
            addNodeToHead(node);
        }
        
        // if new value is getting added
            // cache has capacity => add to head in chain, add to cache
            // cache is full => add to cache, add node near head, remove tail
        else{
            node = new Node<>(key, value);
            cache.put(key, node);
            addNodeToHead(node);
            if(cache.size() > capacity){
                Node<K, V> removedNode = removeTail();
                cache.remove(removedNode.key);
            }
        }   
     }
     private Node<K, V> removeTail(){
        Node<K, V> removedNode = tail.next;
        removeNode(removedNode);
        return removedNode;

     }

     private void removeNode(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
     }

     private void addNodeToHead(Node<K, V> node){
        // head  --   -- head.prev
        node.next = head;
        node.prev = head.prev;
        node.prev.next = node;
        head.prev = node;
     }

}
