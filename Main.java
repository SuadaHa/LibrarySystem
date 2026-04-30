import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowDAO borrowDAO = new BorrowDAO();

        JFrame frame = new JFrame("Library System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 1));

        // Buttons
        JButton addBookBtn = new JButton("Add Book");
        JButton viewBooksBtn = new JButton("View Books");
        JButton deleteBookBtn = new JButton("Delete Book");

        JButton addMemberBtn = new JButton("Add Member");
        JButton viewMembersBtn = new JButton("View Members");

        JButton borrowBtn = new JButton("Borrow Book");

        JButton exitBtn = new JButton("Exit");

        addBookBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Title:");
            String author = JOptionPane.showInputDialog("Author:");
            String category = JOptionPane.showInputDialog("Category:");

            bookDAO.addBook(new Book(0, title, author, category, "Available"));

            JOptionPane.showMessageDialog(frame, "Book Added!");
        });

        viewBooksBtn.addActionListener(e -> {
            bookDAO.getAllBooks();
            JOptionPane.showMessageDialog(frame, "Check terminal for books list");
        });

        deleteBookBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Book ID:"));
            bookDAO.deleteBook(id);
            JOptionPane.showMessageDialog(frame, "Book Deleted!");
        });

        addMemberBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Name:");
            String email = JOptionPane.showInputDialog("Email:");
            String type = JOptionPane.showInputDialog("Type:");

            memberDAO.addMember(name, email, type);
            JOptionPane.showMessageDialog(frame, "Member Added!");
        });

        viewMembersBtn.addActionListener(e -> {
            memberDAO.viewMembers();
            JOptionPane.showMessageDialog(frame, "Check terminal for members list");
        });

        borrowBtn.addActionListener(e -> {
            int bookId = Integer.parseInt(JOptionPane.showInputDialog("Book ID:"));
            int memberId = Integer.parseInt(JOptionPane.showInputDialog("Member ID:"));
            String borrowDate = JOptionPane.showInputDialog("Borrow Date:");
            String dueDate = JOptionPane.showInputDialog("Due Date:");

            borrowDAO.borrowBook(bookId, memberId, borrowDate, dueDate);

            JOptionPane.showMessageDialog(frame, "Borrow Recorded!");
        });

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(addBookBtn);
        frame.add(viewBooksBtn);
        frame.add(deleteBookBtn);
        frame.add(addMemberBtn);
        frame.add(viewMembersBtn);
        frame.add(borrowBtn);
        frame.add(exitBtn);

        frame.setVisible(true);
    }
}