package LRUcache2;

import LRUcache2.LRUCache;

public class LRUCacheDemo {
   public static void main(String[] args) {
      LRUCache<Integer, String> cache = new LRUCache<>(3); // 3 is capacity
      cache.put(1, "Value 1");
      cache.put(2, "Value 2");
      cache.put(3, "Value 3");
      cache.put(4, "Value 4");

      System.err.println();
      System.err.println(cache.get(1)); // null
      System.err.println(cache.get(3)); // 3
      System.err.println(cache.get(2)); // 2
      System.err.println(cache.get(4)); // 4

      cache.put(5, "value 5"); // removes 3
      cache.put(2, "Updated 2");
      System.err.println(cache.get(3)); // null
      System.err.println(cache.get(2)); // Updated 2
      System.err.println(cache.get(4)); // value 4
      System.err.println(cache.get(5)); // value 5

   }
}
