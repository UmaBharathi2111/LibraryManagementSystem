abstract class Item {
    protected String AuthorName;
    protected String title;
    protected String id;

    public Item(String AuthorName,String title, String id) {
        this.AuthorName=AuthorName;
        this.title = title;
        this.id = id;
    }
    public String getAuthorName() {
        return AuthorName;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
