package domain.news;

import domain.Observable;

import java.time.LocalDateTime;

public class News extends Observable {
    private final Source source;
    private final LocalDateTime datetime;
    private String content;

    public News(Source source, LocalDateTime datetime, String content) {
        super();
        this.source = source;
        this.datetime = datetime;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.notifyObservers();
    }

    public Source getSource() {
        return source;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    @Override
    public String getIdentity() {
        return "News{" +
                "source=" + source +
                ", datetime=" + datetime +
                ", content='" + content + '\'' +
                '}';
    }
}
