package com.example.mediapp.Stock;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StockRepo extends CrudRepository<Stock,Long> {
   // availableQTY,expDate,type, strength, unit, genericName, brandName,supplierName, reOrderingLevel

    //here you need to code to find stock (genaricname,unit, c,exp) for update stock

    @Query(value = "select  s from Stock s ")
    List<Stock> getStocks();

}
