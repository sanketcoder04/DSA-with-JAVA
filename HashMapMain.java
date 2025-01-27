import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings({ "unchecked", "rawtypes", "unused"})
class MyHashMap<Key, Value> {

    private class Entity {
        Key key;
        Value value;

        public Entity(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int bucketSize;
    private LinkedList<Entity> bucket[];

    public MyHashMap() {
        this.size = 0;
        this.bucketSize = 4;
        this.bucket = new LinkedList[bucketSize];

        for(int i=0;i<4;i++) {
            this.bucket[i] = new LinkedList();
        }
    }

    private int hashFunction(Key key) {
        int code = key.hashCode();
        return Math.abs(code) % bucket.length;  // hashing
    }

    private int searchEntity(Key key, int index) {
        LinkedList<Entity> list = bucket[index];
        int dataIndex = 0;

        for(int i=0;i<list.size();i++) {
            Entity entity = list.get(i);
            if(entity.key.equals(key)) {
                return dataIndex;
            }
            dataIndex++;
        }
        return -1;
    }

    private void reHash() {
        LinkedList<Entity> temp[] = bucket;
        bucket = new LinkedList[bucketSize * 2];
        bucketSize *= 2;

        for(int i=0;i<bucketSize;i++) {
            bucket[i] = new LinkedList<>();
        }

        for(int i=0;i<temp.length;i++) {
            LinkedList<Entity> list = temp[i];
            for(int j=0;j<list.size();i++) {
                Entity entity = list.get(i);
                put(entity.key, entity.value);
            }
        }
    }

    public void put(Key key, Value value) {
        int bucketIndex = hashFunction(key);
        int entityIndex = searchEntity(key, bucketIndex);

        if(entityIndex == -1) {
            Entity entity = new Entity(key, value);
            bucket[bucketIndex].add(entity);
            size++;
        }
        else {
            Entity entity = bucket[bucketIndex].get(entityIndex);
            entity.value = value;
        }
        double alpha = (double) size / bucketSize;
        if(alpha > 2.0) {
            reHash();
        }
    }

    public boolean containsKey(Key key) {
        int bucketIndex = hashFunction(key);
        int entityIndex = searchEntity(key, bucketIndex);
        return entityIndex != -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        int bucketIndex = hashFunction(key);
        int entityIndex = searchEntity(key, bucketIndex);

        if(entityIndex == -1) {
            return null;
        }
        else {
            Entity entity = bucket[bucketIndex].get(entityIndex);
            return entity.value;
        }
    }

    public void remove(Key key) {
        int bucketIndex = hashFunction(key);
        int entityIndex = searchEntity(key, bucketIndex);

        if(entityIndex == -1) {
            return;
        }
        else {
            Entity entity = bucket[bucketIndex].remove(entityIndex);
            size--;
        }
    }

    public ArrayList<Key> ketSet() {
        ArrayList<Key> result = new ArrayList<>();
        for(int i=0;i<bucketSize;i++) {
            LinkedList<Entity> list = bucket[i];
            for(Entity entity : list) {
                result.add(entity.key);
            }
        }
        return result;
    }
}
 
public class HashMapMain {
    public static void main(String[] args) {

        // Custom created HashMap

        

        // HashMap - Collection Framework

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "One");
        hm.put(2, "Two");
        hm.put(3, "Three");

        System.out.println(hm);

        Set<Integer> keys = hm.keySet();
        System.out.println(keys);

        for (Integer key : keys) {
            System.out.print(hm.get(key) + "\t");
        }
        System.out.println();

        Set<Entry<Integer, String>> pairs = hm.entrySet();
        System.out.println(pairs);

        // Other HashSets : 
        TreeMap<Integer, String> tm = new TreeMap<>();
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        tm.put(1, "One");
        tm.put(2, "Two");
        tm.put(3, "Three");

        lhm.put(1, "One");
        lhm.put(2, "Two");
        lhm.put(3, "Three");
    }
}
