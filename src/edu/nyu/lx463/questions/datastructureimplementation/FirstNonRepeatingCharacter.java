package edu.nyu.lx463.questions.datastructureimplementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LyuXie on 7/5/17.
 */
public class FirstNonRepeatingCharacter {
    static class Node {
        Node prev;
        Node next;
        Character ch;

        Node(Character ch) {
            this.ch = ch;
        }
    }

    private Node head;
    private Node tail;
    private final Map<Character, Node> map;

    public FirstNonRepeatingCharacter() {
        head = null;
        tail = null;
        map = new HashMap<Character, Node>();
    }

    // case1: if there is an key value pair in the hashmap
        // case1.1 : the value is null: do nothing
        // case 1.2 : the value is not null : set the value to null and remove the node
    // case 2 : if is not in the hashmap(which means it is the first time)
    // put the key value into the hashmap and create a node and put it to tail
    public void read(char ch) {
        if (map.containsKey(ch)) {
            Node node = map.get(ch);
            if (node != null) {
                remove(node);
            }
        }else {
            append(ch);
        }
    }

    public Character firstNonRepeating() {
        if (head != null) {
            return head.ch;
        }

        return null;
    }

    // put the key value into the hashmap and create a node and put it to tail
    private Node append(char ch) {
        Node node = new Node(ch);
        if (tail == null) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        map.put(ch, node);
        return node;
    }

    //set the value to null in the hashmap and remove the node
    private Node remove(Node node) {
        map.put(node.ch, null);
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
        return null;
    }


    public static void main(String[] args) {
        FirstNonRepeatingCharacter first = new FirstNonRepeatingCharacter();
        first.read('1');
        System.out.println(first.firstNonRepeating());
        first.read('2');
        System.out.println(first.firstNonRepeating());
        first.read('1');
        System.out.println(first.firstNonRepeating());

        first.read('3');
        System.out.println(first.firstNonRepeating());

        first.read('1');
        System.out.println(first.firstNonRepeating());

        first.read('4');
        System.out.println(first.firstNonRepeating());

        first.read('3');
        System.out.println(first.firstNonRepeating());



    }

}
