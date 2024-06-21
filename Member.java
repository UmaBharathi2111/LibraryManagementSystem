import java.util.ArrayList;
import java.util.List;

class Member extends Person {
    private final List<Book> issuedBooks;

    public Member(String name, String id) {
        super(name, id);
        this.issuedBooks = new ArrayList<>();
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

   public void issueBook(Book book) throws BookNotAvailableException {
    for(Book books: Library.books)
    {
        if(books.getId()==book.getId())
        {
            return;
        }
        
    }
    throw new BookNotAvailableException("Book not found...Please enter another Book ID");
}
}

      //  throw new UnsupportedOperationException("Unimplemented method 'issueBook'");
    //}

   /*  public void issueBook(Book book) throws BookNotAvailableException {
      // library.issueBook(book, this);
    }

    public void returnBook(Book book) {
        library.returnBook(book, this);
    }*/
