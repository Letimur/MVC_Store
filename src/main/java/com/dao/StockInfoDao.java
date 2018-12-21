package com.dao;

import com.mapper.ItemsMapper;
import com.mapper.StockInfoMapper;
import com.model.Items;
import com.model.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StockInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StockInfo> getStockInfo(){
        String SQL = "SELECT * FROM ITEM_TYPES";
        List<StockInfo> stockInfos = jdbcTemplate.query(SQL, new StockInfoMapper());
        return stockInfos;
    }

    public List<Items> getItems(){
        String SQL = "SELECT * FROM ITEMS";
        List<Items> items= jdbcTemplate.query(SQL, new ItemsMapper());
        return items;
    }
    @Transactional
    public void SaveOrUpdateStockInfo(StockInfo stockInfo){
        if(stockInfo.getId() > 0) {
            String SQL = "UPDATE ITEM_TYPES SET PRODUCT = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";
            jdbcTemplate.update(SQL, stockInfo.getProduct(), stockInfo.getPrice(), stockInfo.getQuantity(), stockInfo.getId());
            SQL = "SELECT COUNT(*) FROM ITEMS WHERE PRODUCT = ?";
            List<Integer> numbers = jdbcTemplate.query(SQL, (resultSet, i) -> resultSet.getInt(1), stockInfo.getProduct());
            int oldQuantity = numbers.get(0);
            if(oldQuantity > stockInfo.getQuantity()) {
                SQL = "SELECT * FROM ITEMS WHERE PRODUCT = ?";
                List<Items> items= jdbcTemplate.query(SQL, new ItemsMapper(), stockInfo.getProduct());
                SQL = "DELETE FROM ITEMS WHERE ID = ?";
                for (int i = 0; i < oldQuantity - stockInfo.getQuantity(); i++) {
                    jdbcTemplate.update(SQL, items.get(i).getId());
                }
            }
            else{
                SQL = "INSERT INTO ITEMS(PRODUCT, SOLD, DATE) VALUES (?,?,CURRENT_TIMESTAMP)";
                for(int i = 1; i <= stockInfo.getQuantity() - oldQuantity; i++){
                    jdbcTemplate.update(SQL, stockInfo.getProduct(), "FALSE");
                }
            }

        }
        else{
            String SQL = "INSERT INTO ITEM_TYPES(PRODUCT, PRICE, QUANTITY) VALUES (?,?,?)";
            jdbcTemplate.update(SQL, stockInfo.getProduct(), stockInfo.getPrice(), stockInfo.getQuantity());
            SQL = "INSERT INTO ITEMS(PRODUCT, SOLD, DATE) VALUES (?,?,CURRENT_TIMESTAMP)";
            for(int i = 1; i<=stockInfo.getQuantity(); i++){
                jdbcTemplate.update(SQL, stockInfo.getProduct(), "FALSE");
            }

        }
    }

    public StockInfo get(int id){
        String SQL = "SELECT * FROM ITEM_TYPES WHERE ID = ?";
        List<StockInfo> product = jdbcTemplate.query(SQL, new StockInfoMapper(), id);
        StockInfo stockInfo = product.get(0);
        return stockInfo;
    }

    public void delete(int id){
        StockInfo stockInfo = get(id);
        String SQL = "DELETE FROM ITEMS WHERE PRODUCT = ?";
        jdbcTemplate.update(SQL, stockInfo.getProduct());
        SQL = "DELETE FROM ITEM_TYPES WHERE ID = ?";
        jdbcTemplate.update(SQL, id);

    }
}
