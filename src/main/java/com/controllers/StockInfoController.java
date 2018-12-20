package com.controllers;

import com.dao.StockInfoDao;
import com.model.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockInfoController {

    @Autowired
    private StockInfoDao stockInfoDao;

    @RequestMapping(value = "/")
    public ModelAndView getStockInfo(ModelAndView stockInfoModel){
        List<StockInfo> stockInfo = stockInfoDao.getStockInfo();
        stockInfoModel.addObject("stockInfo", stockInfo);
        stockInfoModel.setViewName("stock-info");
        return stockInfoModel;
    }

    @RequestMapping(value = "/add/stock", method = RequestMethod.GET)
    public ModelAndView addStockInfo(ModelAndView stockInfoModel){
        StockInfo stockInfo = new StockInfo();
        stockInfoModel.addObject("productInfo", stockInfo);
        stockInfoModel.setViewName("add-stock-info");
        return stockInfoModel;
    }

    @RequestMapping(value = "/add/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute StockInfo stockInfo) {
        stockInfoDao.SaveOrUpdateStockInfo(stockInfo);
        return new ModelAndView("redirect:/");
    }
}
