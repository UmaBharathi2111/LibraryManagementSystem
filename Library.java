import java.util.ArrayList;
import java.util.List;
class Library {
    public static List<Book> books = new ArrayList<>();
    public static List<Magazine> magazines = new ArrayList<>();
    public  static List<Member> members = new ArrayList<>();
    public final int MAX_ISSUED_BOOKS = 5;


    public void BookStock()
    {
     
      addBook(new Book("Robert C. Martin", "Clean Code", "101"));
      addBook(new Book("Joshua Bloch", "Effective Java", "102"));
      addBook(new Book("Martin Fowler", "Refactoring", "103"));
      addBook(new Book("Eric Evans", "Domain-Driven Design", "104"));
      addBook(new Book("Kent Beck", "Test Driven Development", "105"));

    }
    public void MagazineStock()
    {
       
        addMagazine(new Magazine("National Geographic", "June 2024", "301"));
        addMagazine(new Magazine("Time", "May 2024", "302"));
        addMagazine(new Magazine("Scientific American", "April 2024", "303"));
        addMagazine(new Magazine("The New Yorker", "March 2024", "304"));
        addMagazine(new Magazine("Forbes", "February 2024", "305"));
       

    }

    public void addBook(Book book) {
        
        books.add(book);
   }

    public void removeBook(String bookId) {
       books.remove(searchBookById(bookId));
    }
    public void addMagazine(Magazine magazineString) {
        
        magazines.add(magazineString);
    }

    public void removeMagazine(String magazineId) {

        magazines.remove(searchMagazineById(magazineId));
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(String Member) {
        members.remove(Member);
    }

    public void updateMemberDetails(String memberId, String newName) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                member.setName(newName);
                break;
            }
        }
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + ", ID: " + book.getId());
                break;
            }
        }
        System.out.println("Book not found");
    }

    public Book searchBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                System.out.println("Book found: " + book.getTitle() + ", ID: " + book.getId());
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }
    public void searchMagazineByTitle(String title){
        for(Magazine magazine: Library.magazines){
            if(magazine.getTitle().equalsIgnoreCase(title)){
                System.out.println("Magazine found: "+magazine.getTitle()+",ID: "+magazine.getId());
                break;
            }
        }
    }

    public void issueBook(Book book, Member member) throws BookNotAvailableException {
        if (!books.contains(book)) {
            throw new BookNotAvailableException("Book not available in library");
        }
        if (member.getIssuedBooks().size() >= MAX_ISSUED_BOOKS) {
            throw new BookNotAvailableException("Member has reached the maximum limit of issued books");
        }
        member.getIssuedBooks().add(book);
        books.remove(book);
        //return;
    }

    public void returnBook(Book book, Member member) {
        member.getIssuedBooks().remove(book);
        books.add(book);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", ID: " + book.getId());
        }
    }

    public void displayAllMembers() {
        for (Member member : members) {
            System.out.println("Name: " + member.getName() + ", ID: " + member.getId());
        }
    }

    public void displayIssuedBooks() {
        for (Member member : members) {
            System.out.println("Member: " + member.getName());
            for (Book book : member.getIssuedBooks()) {
                System.out.println("  Book: " + book.getTitle() + ", ID: " + book.getId());
            }
        }
    }
    public int searchMagazineById(String magazineString) {

        throw new UnsupportedOperationException("Unimplemented method 'searchMagazineById'");
    }
    public static Book getBookById(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
    }
    public static Member getMemberById(String memberId) {

        throw new UnsupportedOperationException("Unimplemented method 'getMemberById'");
    }
}

