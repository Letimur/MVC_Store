package com.controllers;

import com.dao.StockInfoDao;
import com.model.Items;
import com.model.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StockInfoController {

    @Autowired
    private StockInfoDao stockInfoDao;



    @RequestMapping(value = "/")
    public ModelAndView home(ModelAndView stockInfoModel){
        stockInfoModel.setViewName("home");
        return stockInfoModel;
    }

    @RequestMapping(value = "/stock")
    public ModelAndView getStockInfo(ModelAndView stockInfoModel){
        List<StockInfo> stockInfo = stockInfoDao.getStockInfo();
        stockInfoModel.addObject("stockInfo", stockInfo);
        stockInfoModel.setViewName("stock-info");
        return stockInfoModel;
    }

    @RequestMapping(value = "/details")
    public ModelAndView getItemsInfo(ModelAndView stockInfoModel){
        List<Items> items = stockInfoDao.getItems();
        stockInfoModel.addObject("items", items);
        stockInfoModel.setViewName("items-info");
        return stockInfoModel;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addStockInfo(ModelAndView stockInfoModel){
        StockInfo stockInfo = new StockInfo();
        stockInfoModel.addObject("productInfo", stockInfo);
        stockInfoModel.setViewName("add-stock-info");
        return stockInfoModel;
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute StockInfo stockInfo) {
        stockInfoDao.SaveOrUpdateStockInfo(stockInfo);
        return new ModelAndView("redirect:/stock");
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public ModelAndView editProduct(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        StockInfo stockInfo = stockInfoDao.get(id);
        ModelAndView model = new ModelAndView("add-stock-info");
        model.addObject("productInfo", stockInfo);

        return model;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public ModelAndView deleteProduct(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        stockInfoDao.delete(id);
        return new ModelAndView("redirect:/stock");
    }
}
