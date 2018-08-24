import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;



public class MySQLAdsDao implements Ads {

    private Connection conn;

    public MySQLAdsDao(Config config) {

        try {
        DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(query);
            return createAdlist(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem in all method of MySQLAdsDao!");
        }
    }


    private List<Ad> createAdlist(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description"))
            );
        }
        return ads;
    }


    @Override
    public Long insert(Ad ad) {

        try {
            Statement stmt = conn.createStatement();

        String insertQuery = String.format("INSERT INTO ads (user_Id, title, description) VALUES ('%d', '%s', '%s')",
            ad.getUserId(),
            ad.getTitle(),
            ad.getDescription()
//        Ad newAd = new Ad(4, "car", "good");
        );

        stmt.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
         return rs.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong in insert method of MySQLAdsDao");

        }
    }
}
