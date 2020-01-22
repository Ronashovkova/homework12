package com.cursor;

import com.cursor.model.LFUCache;
import com.cursor.model.NewsService;

import java.util.stream.IntStream;

public class Executor {
    public static void start() {
        NewsService news = new NewsService();
        news.addNews();

        LFUCache cache = new LFUCache(7);
        cache.put(1, news.getNews("Politics"));
        cache.put(2, news.getNews("Sport"));
        cache.put(3, news.getNews("Arts"));
        cache.put(4, news.getNews("Show-business"));
        cache.put(5, news.getNews("Scandals"));
        cache.put(6, news.getNews("Army"));
        cache.put(7, news.getNews("Announcement"));
        cache.put(8, news.getNews("Cookery"));
        cache.put(9, news.getNews("Funeral"));
        cache.put(10, news.getNews("Business"));

        IntStream.rangeClosed(1, 10)
                .filter(i -> cache.get(i) != null)
                .mapToObj(i -> "News " + i + ": " + cache.get(i))
                .forEach(System.out::println);
    }
}
