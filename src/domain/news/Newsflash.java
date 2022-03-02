package domain.news;

import domain.Observable;
import domain.Observer;

import java.time.LocalDateTime;

public class Newsflash extends News implements Observable {
	private final LocalDateTime expiresAt;

	public Newsflash(Source source, LocalDateTime datetime, LocalDateTime expiresAt, String content) {
		super(source, datetime, content);
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	
	@Override
	public String getContent() {
		if (LocalDateTime.now().isBefore(expiresAt)) {
			return super.getContent();
		}
		else {
			return null;
		}
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
