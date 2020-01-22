package com.cursor.model;

public class Node {
    int key;
    String news;
    int frequency;
    Node prev;
    Node next;

    public Node(int key, String news, int frequency) {
        this.key = key;
        this.news = news;
        this.frequency = frequency;
    }
}
