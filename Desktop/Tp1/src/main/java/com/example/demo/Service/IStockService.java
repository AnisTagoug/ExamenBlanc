package com.example.demo.Service;

import com.example.demo.Entity.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock s);

    Stock retrieveStock(Long id);

    void removeStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);

}
