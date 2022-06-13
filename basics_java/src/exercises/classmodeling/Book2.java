package exercises.classmodeling;
/* Created by limxuanhui on 13/6/22 */

public class Book2 {

    private String title;
    private String description;
    private String author;
    private String catalogId;

    public Book2(String title, String description, String author, String catalogId) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.catalogId = catalogId;
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

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
