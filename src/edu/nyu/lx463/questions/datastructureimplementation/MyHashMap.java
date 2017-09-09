package edu.nyu.lx463.questions.datastructureimplementation;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by LyuXie on 5/18/17.
 */
public class MyHashMap<K, V> {

    private static  class Node<K, V>{
        private final K key;
        private V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_FACTOR = 0.75f;

    private final Node<K, V>[] array;
    private double loadFactor;
    private int size;


    public MyHashMap() {
        this.loadFactor = DEFAULT_FACTOR;
        this.size = 0;
        array = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];

    }

    public MyHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("cap can not be less than 0");
        }

        this.loadFactor = DEFAULT_FACTOR;
        this.size = 0;
        array = (Node<K, V>[]) new Node[capacity];
    }

    public MyHashMap(int capacity, float factor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("cap can not be less than 0");
        }

        this.loadFactor = factor;
        this.size = 0;
        array = (Node<K, V>[]) new Node[capacity];
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> curr = head;

        while (curr != null) {
            if (equalsKey(curr.getKey(), key)) {
                V result = curr.getValue();
                curr.setValue(value);
                return result;
            }

            curr = curr.next;
        }

        Node<K, V> newNode = new Node<K, V>(key, value);
        newNode.next = head;
        array[index] = newNode;
        size ++;
        return null;
    }

    private boolean equalsKey(K k1, K k2) {
        if (k1 == null && k2 == null) {
            return true;
        }

        if (k1 == null || k2 == null) {
            return false;
        }

        return k1.equals(k2);
    }

    public boolean equalsValue(V v1, V v2) {
        if (v1 == null && v2 == null) {
            return true;
        }

        if (v1 == null || v2 == null) {
            return false;
        }

        return v1.equals(v2);
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        return key.hashCode() & 0X7FFFFFFF;

    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> curr = array[index];

        while (curr != null) {
            if (equalsKey(curr.getKey(), key)){
                return curr.getValue();
            }
            curr = curr.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        this.size = 0;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> curr = array[index];

        while (curr != null) {
            if (equalsKey(curr.getKey(), key)){
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }

        for (Node<K, V> curr : array) {
            while (curr != null) {
                if (equalsValue(curr.getValue(), value)) {
                    return true;
                }
            }
        }

        return false;
    }

    public V remove(K key) {
        if (containsKey(key)) {
            int index = getIndex(key);
            Node<K, V> head = array[index];

            if (head.next == null && equalsKey(head.getKey(), key)) {
                array[index] = null;
                size--;
                return head.getValue();
            }

            Node<K, V> prev = head;
            Node<K, V> curr = head.next;
            while (curr != null) {
                if (equalsKey(curr.getKey(), key)) {
                    prev.next = curr.next;
                    size--;
                    return curr.getValue();
                }

                prev = curr;
                curr = curr.next;
            }

            return null;
        }
        else {
            return null;
        }

    }



}
