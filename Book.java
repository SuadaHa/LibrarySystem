public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private String status;

    public Book(int id, String title, String author, String category, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setStatus(String status) { this.status = status; }
}