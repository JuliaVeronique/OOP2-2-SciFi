package domain.news;

import java.util.SortedSet;
import java.util.TreeSet;

import domain.Observable;
import domain.Observer;
import domain.person.Organization;

public class Source extends Organization implements Observable {
	private SortedSet<News> news;

	public Source(String name, String description, SortedSet<News> news) {
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
	public void registerObserver(Observer o) {

	}

	@Override
	public void unregisterObserver(Observer o) {

	}

	@Override
	public void notifyObservers() {

	}

	@Override
	public String getIdentity() {
		return null;
	}
}
