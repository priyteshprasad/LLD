package LRUcache;

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "Value 1");
        cache.put(2, "Value 2");
        cache.put(3, "Value 3");

        System.out.println(cache.get(1)); // Value 1
        System.out.println(cache.get(2)); // Value 2

        cache.put(4, "Value 4");
        System.out.println(cache.get(3)); // null
        System.out.println(cache.get(4)); // Value 4

        cache.put(2, "Updated Value 2");

        System.out.println(cache.get(1)); // Value 1
        System.out.println(cache.get(2)); // Updated Value 2
    }
}
