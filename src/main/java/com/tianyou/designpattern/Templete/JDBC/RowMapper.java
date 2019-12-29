package com.tianyou.designpattern.Templete.JDBC;

import java.sql.ResultSet;

public interface RowMapper<T> {

    /**
     * 将数据库对应行号的结果集处理成对象
     * @param resultSet 数据库结果集
     * @param rowNum    行号
     * @return
     */
    T mapRow(ResultSet resultSet,int rowNum);
}
