import java.sql.*;

class test_DBConnect {
    public static void main(String[] args) {
        try {
            doQuery();
        } catch (SQLException e) {
            System.out.println("SQL exception occured!");
            System.out.println(e.toString());
        }
    }

    private static void doQuery() throws SQLException {
        String url = "jdbc:postgresql://localhost/evedb";
        String props = "?user=postgres&password=postgrespass";
        Connection conn = DriverManager.getConnection(url + props);
        Statement st = conn.createStatement();
        String query = "SELECT * FROM invtypes WHERE typeid=34";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
