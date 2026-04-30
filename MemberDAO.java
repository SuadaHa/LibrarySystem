import java.sql.*;

public class MemberDAO {

    public void addMember(String name, String email, String type) {
        String sql = "INSERT INTO members(member_name, email, membership_type) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, type);
            stmt.executeUpdate();

            System.out.println("Member added.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewMembers() {
        String sql = "SELECT * FROM members";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("member_id") + " | " +
                        rs.getString("member_name") + " | " +
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}