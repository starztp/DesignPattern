package com.tianyou.designpattern.Templete.JDBC;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCTemplete {

    private DataSource dataSource;

    public JDBCTemplete(DataSource dataSource){
        this.dataSource=dataSource;
    }

    /**
     * JDBC执行SQL
     * @param sql        SQL语句
     * @param values     SQL替换符对应的参数
     */
    public List<?> executeQuery(RowMapper<?> rowMapper,String sql,Object[] values) throws SQLException {

        //1.获取连接
        Connection connection=this.getConnection();

        //2.创建语句集
        PreparedStatement statement=this.createStatement(connection,sql);

        //3.执行语句集
        ResultSet resultSet=this.executeStatement(statement,values);

        //4.处理结果集
        List<?> results=this.parseResult(resultSet,rowMapper);

        //5.关闭结果集
        this.closeResultSet(resultSet);
        
        //6.关闭语句集
        this.closeStatement(statement);
        
        //7.关闭连接
        this.closeConnection(connection);
        return results;
    }

    protected void closeConnection(Connection connection) throws SQLException {
        connection.close();
    };

    protected void closeStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    };

    protected void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    };

    protected  List<?> parseResult(ResultSet resultSet,RowMapper<?> rowMapper) throws SQLException {
        List<Object> list=new ArrayList<Object>();
        int rownumber=1;
        while (resultSet.next()){
            Object obj=rowMapper.mapRow(resultSet,rownumber++);
            list.add(obj);
        }
        return list;
    };

    protected ResultSet executeStatement(PreparedStatement statement,Object[] values) throws SQLException {
        for(int i=0;i<values.length;i++){
            statement.setObject(i,values[i]);
        }
        ResultSet res=statement.executeQuery();
        return res;
    };

    protected  PreparedStatement createStatement(Connection connection,String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    protected  Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
