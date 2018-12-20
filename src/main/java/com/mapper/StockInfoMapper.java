package com.mapper;

import com.model.StockInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StockInfoMapper implements RowMapper<StockInfo>{

    @Override
    public StockInfo mapRow(ResultSet rs, int row) throws SQLException {
        StockInfo stockInfo = new StockInfo();
        stockInfo.setId(rs.getInt("id"));
        stockInfo.setProduct(rs.getString("product"));
        stockInfo.setPrice(rs.getInt("price"));
        stockInfo.setQuantity(rs.getInt("quantity"));
        return stockInfo;
    }
}
