package com.cursor.model;

import java.util.HashMap;
import java.util.Map;

public class NewsService {

    private Map<String, String> news = new HashMap<>();
    public void addNews() {
        news.put("Politics", "Ukraine's president rejects resignation of his prime minister.");
        news.put("Sport", "Ukrainian boxer Derevyanchenko tops WBC middleweight ranking.");
        news.put("Arts", "Ukrainian nationalists target lecture at Kiev arts centre as far-right activity rises.");
        news.put("Show-business", "Famous stars of Ukrainian show business celebrated their birthdays!");
        news.put("Scandals", "Ukraine rocked by leaked audio scandal.");
        news.put("Army", "Ukraine is willing to cooperate more closely with NATO.");
        news.put("Announcement", "Law of Ukraine.");
        news.put("Cookery", "The recipes of Ukrainian kutya.");
        news.put("Funeral", "Funeral procession of six martyrs of Ukrainian plane crash in Qom.");
        news.put("Business", "Azerbaijan plans to invest another $1.5 billion in Ukraine.");
    }

    public String getNews(String key) {
        return news.get(key);
    }
}
