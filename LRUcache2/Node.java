package LRUcache2;

public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;
    Node(K key, V value){
        this.key = key;
        this.value = value;
    }

}
