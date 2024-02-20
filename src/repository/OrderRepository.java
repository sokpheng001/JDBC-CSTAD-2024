package repository;

import loadingProperties.LoadingProperties;
import model.Item;
import model.Order;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public List<Order> getAllOrders(){
        List<Order> orderList = new ArrayList<>();
        LoadingProperties.loadingProperties();
        //SQL query
        String sql = "SELECT * FROM orders as o " +
                "JOIN users as u on u.user_id = o.user_id " +
                "JOIN items i on i.item_id = o.item_id";
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
                orderList.add(
                        new Order(resultSet.getInt("order_id"),
                                resultSet.getString("order_uuid"),
                                resultSet.getDate("ordered_date"),
                                //
                                new User(
                                        resultSet.getInt("user_id"),
                                        resultSet.getString("user_uuid"),
                                        resultSet.getString("user_name"),
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        resultSet.getBoolean("is_deleted")
                                ),
                                //
                                new ArrayList<>(
                                        List.of(
                                                new Item(resultSet.getInt("item_id"),
                                                        resultSet.getString("item_uuid"),
                                                        resultSet.getString("item_name")
                                                        )
                                        )
                                )
                ));
            }
        }catch (SQLException sqlException){
            System.out.println("Problem during select order from database:" + sqlException.getMessage());
        }
        return orderList;
    }
}
