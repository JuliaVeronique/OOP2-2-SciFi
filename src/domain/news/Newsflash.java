package domain.news;

import java.time.LocalDateTime;

public class Newsflash extends News {
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
}
