package com.mapper;

import com.model.Items;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemsMapper implements RowMapper<Items> {

    @Override
    public Items mapRow(ResultSet rs, int row) throws SQLException {
        Items items = new Items();
        items.setId(rs.getInt("id"));
        items.setProduct(rs.getString("product"));
        items.setSold(rs.getString("sold"));
        items.setDate(rs.getString("date"));
        return items;
    }
}
