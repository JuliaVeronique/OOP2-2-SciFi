package domain.news;

import domain.person.Organization;

import java.util.SortedSet;
import java.util.TreeSet;

public class Source extends Organization {
    private SortedSet<News> news;

    public Source(String name, String description) {
        super(name, description);
        this.news = new TreeSet<>();
    }

    public boolean addNews(News news) {
        return this.news.add(news);
    }

    public SortedSet<News> getNews() {
        SortedSet<News> result = new TreeSet<>();
        result.addAll(news);
        return result;
    }

    @Override
    public String getIdentity() {
        return this.getName();
    }
}
