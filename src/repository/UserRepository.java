package repository;

import loadingProperties.LoadingProperties;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.lang.StringTemplate.STR;

public class UserRepository {
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        LoadingProperties.loadingProperties();
        //SQL query
        String sql = "SELECT *FROM users";
        try(
                Connection connection = DriverManager.getConnection(
                        LoadingProperties.properties.getProperty("database_url"),
                        LoadingProperties.properties.getProperty("database_user_name"),
                        LoadingProperties.properties.getProperty("database_password")
                );
                //            create statement
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ){
            System.out.println("Connected database\n===");
            //
            // Process the results
            while (resultSet.next()) {
                // Handle other columns as needed
                userList.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_uuid"),
                        resultSet.getString("user_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_deleted")
                ));
            }
        }catch (SQLException sqlDataException){
            System.out.println(STR."Problem during selecting data from database: \{sqlDataException.getMessage()}");
        }
        return userList;
    }
    public int insertUser(User user){
        LoadingProperties.loadingProperties();
        //SQL query
        String sql = " INSERT INTO users (user_uuid,user_name, email, password, is_deleted) " +
                "Values (?,?,?,?,?)";

        try(
                Connection connection = DriverManager.getConnection(
                        LoadingProperties.properties.getProperty("database_url"),
                        LoadingProperties.properties.getProperty("database_user_name"),
                        LoadingProperties.properties.getProperty("database_password")
                );
                //            create statement
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            System.out.println("Connected database\n===");
            //insert
            preparedStatement.setString(1,user.getUserUuid());
            preparedStatement.setString(2,user.getUserName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setBoolean(5,user.getIsDeleted());
            return preparedStatement.executeUpdate();
        }catch (SQLException sqlDataException){
            System.out.println("Problem during selecting data from database: " + sqlDataException.getMessage());
        }
        return 0;
    }
    //
    public int deleteUserById(int id){
        LoadingProperties.loadingProperties();
        //SQL query
        String sql = "DELETE FROM users WHERE users.user_id = " + id;

        try(
                Connection connection = DriverManager.getConnection(
                        LoadingProperties.properties.getProperty("database_url"),
                        LoadingProperties.properties.getProperty("database_user_name"),
                        LoadingProperties.properties.getProperty("database_password")

                );
                //            create statement
                Statement statement = connection.createStatement();
        ){
            int rowAffected = statement.executeUpdate(sql);
            System.out.println("Connected database\n===");
            return rowAffected;
        }catch (SQLException sqlDataException){
            System.out.println("Problem during deleting data from database: " + sqlDataException.getMessage());
        }
        return 0;
    }
    public int updateUserById(int id, User user){
        LoadingProperties.loadingProperties();
        String sql = "UPDATE users SET user_name = '" + user.getUserName() + "' WHERE user_id = " + id ;
        try(
                Connection connection = DriverManager.getConnection(
                        LoadingProperties.properties.getProperty("database_url"),
                        LoadingProperties.properties.getProperty("database_user_name"),
                        LoadingProperties.properties.getProperty("database_password")

                );
                //            create statement
                Statement statement = connection.createStatement();
        ){
            int rowAffected = statement.executeUpdate(sql);
            System.out.println("Connected database to update\n===");
            return rowAffected;
        }catch (SQLException sqlDataException){
            System.out.println("Problem during updating data from database: " + sqlDataException.getMessage());
        }
        return 0;
    }
}
