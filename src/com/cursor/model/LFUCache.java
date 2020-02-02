package com.cursor.model;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private Node head;
    private Node tail;
    private int capacity;

    private Map<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public String get(int key) {
        if (map.get(key) == null) {
            return null;
        }
        Node node = map.get(key);
        removeNode(node);
        node.frequency = node.frequency + 1;
        addNodeWithUpdatedFrequency(node);
        return node.news;
    }

    public void put(int key, String news) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.news = news;
            node.frequency = node.frequency + 1;
            removeNode(node);
            addNodeWithUpdatedFrequency(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, news, 1);
            addNodeWithUpdatedFrequency(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeWithUpdatedFrequency(Node node) {
        if (tail != null && head != null) {
            Node temp = head;
            while (true) {
                if (temp.frequency > node.frequency) {
                    if (temp == head) {
                        node.next = temp;
                        temp.prev = node;
                        head = node;
                        break;
                    } else {
                        node.next = temp;
                        node.prev = temp.prev;
                        temp.prev.next = node;
                        break;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        tail.next = node;
                        node.prev = tail;
                        node.next = null;
                        tail = node;
                        break;
                    }
                }
            }
        } else {
            tail = node;
            head = tail;
        }
    }

    public void iterateMap() {
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) != null) {
                System.out.println("News " + i + ": " + map.get(i));
            }
        }
    }
}
