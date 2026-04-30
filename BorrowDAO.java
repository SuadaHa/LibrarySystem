import java.sql.*;

public class BorrowDAO {

    public void borrowBook(int bookId, int memberId, String borrowDate, String dueDate) {
        String sql = "INSERT INTO borrow_records(book_id, member_id, borrow_date, due_date, return_status) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            stmt.setInt(2, memberId);
            stmt.setString(3, borrowDate);
            stmt.setString(4, dueDate);
            stmt.setString(5, "Borrowed");

            stmt.executeUpdate();
            System.out.println("Borrow record created.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}