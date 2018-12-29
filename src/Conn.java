import java.sql.*;

public class Conn {
    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/stusoc?serverTimezone=GMT";
    private Connection connection=null;
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection() {
        return connection;
    }
    public Conn() {
        try {
            Class.forName(DBDRIVER);
            connection=DriverManager.getConnection(DBURL,"root","root");
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updata(String sql){
        Conn conn=new Conn();
        try {
            Statement statement=conn.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet select(String sql){
        Conn conn=new Conn();
        ResultSet resultSet=null;
        try {
            Statement statement=conn.getConnection().createStatement();
            resultSet=statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
