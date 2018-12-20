package com.dao;

import com.mapper.StockInfoMapper;
import com.model.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StockInfo> getStockInfo(){
        String SQL = "SELECT * FROM ITEM_TYPES";
        List<StockInfo> stockInfos = jdbcTemplate.query(SQL, new StockInfoMapper());
        return stockInfos;
    }

    public void SaveOrUpdateStockInfo(StockInfo stockInfo){
        if(stockInfo.getId() > 0) {
            String SQL = "UPDATE ITEM_TYPES SET PRODUCT = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";
            jdbcTemplate.update(SQL, stockInfo.getProduct(), stockInfo.getPrice(), stockInfo.getQuantity(), stockInfo.getId());
        }
        else{
            String SQL = "INSERT INTO ITEM_TYPES(PRODUCT, PRICE, QUANTITY) VALUES (?,?,?)";
            jdbcTemplate.update(SQL, stockInfo.getProduct(), stockInfo.getPrice(), stockInfo.getQuantity());
        }
    }

}
