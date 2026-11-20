package model;

public class Book extends Product{
    private String author;

    public Book(String id, String name, double price, int stock, String author) {
        super(id, name, price, stock);
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Tác giả không hợp lệ");
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Tên tác giả không được rỗng");
        }
        this.author = author;
    }

    @Override
    public String getDescription() {
        return getName() + "- tác giả: " + author;
    }
}
