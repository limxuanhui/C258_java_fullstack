package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

import java.util.Date;

public class Book1 {

    private String title;
    private String description;
    private String author;
    private String[] body;
    private boolean isPublished;
    private Date lastPublished;

    public Book1(String title, String description, String author, String[] body, boolean isPublished, Date lastPublished) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.body = body;
        this.isPublished = isPublished;
        this.lastPublished = lastPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getBody() {
        return body;
    }

    public void setBody(String[] body) {
        this.body = body;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Date getLastPublished() {
        return lastPublished;
    }

    public void setLastPublished(Date lastPublished) {
        this.lastPublished = lastPublished;
    }
}
