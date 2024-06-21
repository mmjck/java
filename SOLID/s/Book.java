public class Book implements Printable{
    private String name;
    private String text;
    private String author;
    

    public Book(String name, String author, String text) {
        this.name = name;
        this.author = author;
        this.text = text;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
   
}
