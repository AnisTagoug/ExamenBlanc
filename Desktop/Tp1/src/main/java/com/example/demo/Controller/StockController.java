package com.example.demo.Controller;

import com.example.demo.Entity.Stock;
import com.example.demo.Service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")

public class StockController {
    @Autowired
    IStockService StockService;
    @GetMapping()
    public List<Stock> retrieveAllStocks()
    {return StockService.retrieveAllStocks();}
    @PostMapping()
    public Stock addStock(@RequestBody Stock s){
        return StockService.addStock(s);
    }
    @PutMapping()
    public Stock updateStock(@RequestBody Stock s){
        return StockService.updateStock(s);
    }
    @GetMapping("{idStock}")
    public Stock retrieveStock(@PathVariable Long idStock){
        return StockService.retrieveStock(idStock);
    }
    @DeleteMapping("{idStock}")
    public void removeStock(@PathVariable Long idStock) {
        StockService.removeStock(idStock);
    }
        @PostMapping("/assignProduitToStock/{idProduit}/{idStock}")

        public void assignProduitToStock (@PathVariable Long idProduit, @PathVariable Long idStock){

            StockService.assignProduitToStock(idProduit, idStock);
        }
    }
