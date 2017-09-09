package edu.nyu.lx463.questions.datastructureimplementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LyuXie on 7/5/17.
 */
public class LRUCache<K, V> {
    static class Node<K, V> {
        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int limit;
    private final Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>();
    }

    public void set(K key, V value) {
        Node<K, V> node;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            node.value = value;
        } else if (map.size() < limit) {
            node = new Node<K, V>(key, value);
        } else {
            node = remove(tail);
            node.update(key, value);
        }
        append(node);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        append(node);
        return node.value;
    }


    private Node<K, V> remove(Node<K, V> node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == head) {
            head = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        }

        node.next = null;
        node.prev = null;
        return node;
    }

    private Node<K, V> append(Node<K, V> node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        return node;
    }


}
