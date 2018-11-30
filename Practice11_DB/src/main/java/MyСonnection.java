import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyСonnection {
    Logger logger = Logger.getLogger(MyСonnection.class);
    public String url;
    public String user;
    public String pass;
    Connection connection = null;

    public MyСonnection(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection getMyConnection(){
        try {
            if (connection==null)
                connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            logger.error("SQL error: "+e.getMessage());
        }
        return connection;
    }
    public void close(){
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("SQL close error: "+e.getMessage());
            }
        }
    }
}
