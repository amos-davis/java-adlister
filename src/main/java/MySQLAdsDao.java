import java.sql.*;
import java.util.List;

public class MySQLAdsDao implements Ads {

    Connection conn;

    public MySQLAdsDao(Config config) {

        try {
            conn = DriverManager.getConnection(
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
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "SELECT * FROM ads";

        Statement statement = null;
        try {
            statement = conn.createStatement();

        Ad newAd = new Ad(4, "car", "good");


        String insertQuery = String.format("INSERT INTO ads (user_Id, title, description) VALUES (%d, %s, %s)",
            newAd.getUserId(),
            newAd.getTitle(),
            newAd.getDescription()
        );

        statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.executeQuery(query);
            rs = statement.getGeneratedKeys();
         return
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
