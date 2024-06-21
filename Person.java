abstract class Person {
    protected String name;
    protected String id;
   

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //public void searchBookByTitle(String title) {
    //    library.searchBookByTitle(title);
    //}

   // public void searchBookById(String id) {
     //   library.searchBookById(id);
    //}
}

