package com.xuan.dao;

import com.xuan.model.House;
import com.xuan.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 10:49  七月
 * @Description:
 * @ModifyBy:
 */
@Repository
public class HouseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        House house = new House();
        house.setName("name");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO t_house ( name, house_type, area, create_time, is_delete) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, house.getName(), "houseType", "area", MyUtil.localDateTimeFormatString(LocalDateTime.now()), 0);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,"1111");
                preparedStatement.setString(2,"2222");
                preparedStatement.setString(3,"3333");
                preparedStatement.setDate(4,Date.valueOf(LocalDate.now()));
                preparedStatement.setInt(5,0);

                return preparedStatement;
            }
        },keyHolder);

        System.out.println(keyHolder.getKey().longValue());
    }
}
