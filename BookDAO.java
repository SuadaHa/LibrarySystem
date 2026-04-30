import java.sql.*;


public class BookDAO {

    public void addBook(Book book) {
        String sql = "INSERT INTO books(title, author, category, availability_status) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setString(4, book.getStatus());
            stmt.executeUpdate();

            System.out.println("Book added successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("category") + " | " +
                        rs.getString("availability_status"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Book deleted.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}