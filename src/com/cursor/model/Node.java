package com.cursor.model;

class Node {
    int key;
    String news;
    int frequency;
    Node prev;
    Node next;

    Node(int key, String news, int frequency) {
        this.key = key;
        this.news = news;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return news;
    }
}
