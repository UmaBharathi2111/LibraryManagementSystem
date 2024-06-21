import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.BookStock();
        library.MagazineStock();

        Scanner scanner = new Scanner(System.in);

        Librarian librarian = new Librarian("Ub", "66");
        System.out.println("Welcome to the Library Management System!");
        System.out.print("Enter your role (Librarian/Member): ");
        String role = scanner.nextLine();

        String name = "";
        String id = "";

        if (role.equalsIgnoreCase("Librarian")) {
            System.out.print("Enter Librarian name: ");
            name = scanner.nextLine();
            System.out.print("Enter Librarian ID: ");
            id = scanner.nextLine();
            while (true) 
            {
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Add Magazine");
                System.out.println("4. Remove Magazine");
                System.out.println("5. Add Member");
                System.out.println("6. Remove Member");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book ID: ");
                        id = scanner.nextLine();
                        Book book = new Book(null, title, id);
                        librarian.addBook(book);
                        System.out.println("Book added successfully");
                        break;
                    }
                    case 2: {
                        System.out.print("Enter book ID to remove: ");
                        id = scanner.nextLine();
                        librarian.removeBook(id);
                        System.out.println("Book removed successfully");
                        break;
                    }
                    case 3: {
                        System.out.print("Enter Magazine title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Magazine ID: ");
                        id = scanner.nextLine();
                        Magazine magazine = new Magazine(null, title, id);
                        librarian.addMagazine(magazine);
                        System.out.println("Magazine added successfully");
                        break;

                    }
                    case 4: {
                        System.out.print("Enter Magazine ID to remove: ");
                        id = scanner.nextLine();
                        librarian.removeMagazine(id);
                        System.out.println("Magazine removed successfully");
                        break;
                    }
                    case 5: {
                        System.out.print("Enter member name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter member ID: ");
                        id = scanner.nextLine();
                        Member member = new Member(name, id);
                        librarian.addMember(member);
                        System.out.println("Member added successfully");
                        break;
                    }
                    case 6: {
                        System.out.print("Enter member ID to remove: ");
                        id = scanner.nextLine();
                        librarian.removeMember(id);
                        System.out.println("Member removed successfully");
                        break;
                    }
                    case 7: {
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    }
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;

                }
            }

        } else if (role.equalsIgnoreCase("Member")) {
            System.out.print("Enter Member name: ");
            name = scanner.nextLine();
            System.out.print("Enter Member ID: ");
            id = scanner.nextLine();
            Member member = new Member(name, id);
            while (true) {
                System.out.println("1. Search Book by Title");
                System.out.println("2. Search Book by ID");
                System.out.println("3. Issue Book");
                System.out.println("4. Display All Books");
                System.out.println("5. Display All Members");
                System.out.println("6. Display Issued Books");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter book title to search: ");
                        String title = scanner.nextLine();
                        librarian.searchBookByTitle(title);
                        break;
                    case 2:
                        System.out.print("Enter book ID to search: ");
                        id = scanner.nextLine();
                        librarian.searchBookById(id);
                        break;
                    case 3:
                        System.out.print("Enter book ID to issue: ");
                        id = scanner.nextLine();
                        System.out.print("Enter member ID: ");
                        String memberId = scanner.nextLine();
                        member = Library.getMemberById(memberId);
                        Book book;
                        if (member != null) {
                            book = Library.getBookById(id);
                            try {
                                // throw new BookNotAvailableException();
                                member.issueBook(book);
                                System.out.println("Book issued successfully");
                            } catch (BookNotAvailableException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    case 4:
                        library.displayAllBooks();
                        break;
                    case 5:
                        library.displayAllMembers();
                        break;
                    case 6:
                        library.displayIssuedBooks();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;

                }

            }

        }

        else {
            System.out.println("Invalid role. Exiting...");
        }
       scanner.close();
    }
}
