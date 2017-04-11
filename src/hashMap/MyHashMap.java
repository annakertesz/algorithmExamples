package hashMap;

import balancedTree.RedBlackTree;

/**
 * Created by annakertesz on 4/10/17.
 */
public class MyHashMap<K, V> {

    private RedBlackTree<Entry>[] hashMap;

    public MyHashMap() {
        this.hashMap = new RedBlackTree[16];
    }

    public void put(K key, V value) {
        placeNode(key.hashCode(), new Entry<K,V>(key, value));
    }


    private void placeNode(int hashCode, Entry entry){

        int index = hashCode & hashMap.length-1;
        if (hashMap[index]==null) hashMap[index]=new RedBlackTree<Entry>(hashCode, entry);
        else hashMap[index].insert(hashCode, entry);

    }
}
