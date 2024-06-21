class Librarian extends Person {

    Library library;

    public Librarian(String name, String id) {
        super(name, id);
        library = new Library();
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(String bookId) {
        library.removeBook(bookId);
    }
    public void addMagazine(Magazine MagazineString) {
        library.addMagazine(MagazineString);
    }
    public void removeMagazine(String MagazineId) {
        library.removeMagazine(MagazineId);
    }

    public void addMember(Member member) {
        library.addMember(member);
    }

    public void removeMember(String memberId) {
        library.removeMember(memberId);
    }

    public void searchBookByTitle(String title) {
        library.searchBookByTitle(title);
    }

    public void searchBookById(String id) {
        library.searchBookById(id);
    }
    public void searchMagazineByTitle(String title){
        library.searchMagazineByTitle(title);
    }
    public void searchMagazineById(String MagazineString){
        library.searchMagazineById(MagazineString);
    }

    public void updateMemberDetails(String memberId, String newName) {
        library.updateMemberDetails(memberId, newName);
    }
}
