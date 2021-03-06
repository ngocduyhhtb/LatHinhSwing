package Controller;

import Config.DBConfig;
import View.HallOfFame;

import java.sql.*;

public class DatabaseController {
    private final Connection connection;
    private final Statement statement;

    public DatabaseController() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DBConfig.databaseUrl, DBConfig.dataBaselUsername, DBConfig.dataBasePassword);
        statement = connection.createStatement();
    }

    public HallOfFame getHistory() throws SQLException {
        ResultSet resultSet = statement.executeQuery("Select * from playerscore");
        return new HallOfFame("Game History", resultSet);
    }

    public void SaveGame(String username, String score, int level) throws SQLException {
        String query = "INSERT INTO playerscore(username, score, level) VALUES(? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, score);
        preparedStatement.setInt(3, level);
        preparedStatement.execute();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
