package com.tianyou.designpattern.Templete.JDBC;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDao extends JDBCTemplete{



    public OrderDao(DataSource dataSource) {
        super(null);
    }

    public List<?> selectAll() throws SQLException {
        String sql="select * from order where OrderId=1";
        return super.executeQuery(new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int rowNum) {
                Order order=new Order();
                try {
                    order.setOrderId(resultSet.getInt("OrderId"));
                    order.setOrderNumber(resultSet.getString("OrderNumber"));
                    order.setAmount(resultSet.getFloat("amount"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return order;
            }

        },sql,null);
    }



}
