package com.example.mediapp.Stock;

import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.Medi.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockService {
    @Autowired
    StockRepo stockRepo;
    @Autowired
    MedicineRepo medicineRepo;

    public Response addNewStock(Stock stock){

        stockRepo.save(stock);
        return new Response("success","New Stock Details Added Successfully",null);
    }

    public List<StockDTO> getAllStockDetails(){
        List<StockDTO> stockDTOList=new ArrayList<>();
        List<Stock> stockList=stockRepo.getStocks();

        for(Stock stock:stockList){
            StockDTO stockDTO=new StockDTO();
            Long mid=stock.medicine.getMid();
            System.out.println(mid);
            Medicine medicine=medicineRepo.getMedicineByMid(mid);
            System.out.println(medicine.getMid());
            System.out.println(medicine.getBrandName());
            stockDTO.availableQTY=(stock.availableQTY);
            stockDTO.expDate=(stock.expDate);
            stockDTO.strength=(stock.strength);
            stockDTO.unit=(stock.unit);
            stockDTO.type=(stock.type);
            stockDTO.supplierName=(medicine.getSupplierName());
            stockDTO.brandName=(medicine.getBrandName());
            stockDTO.genericName=(medicine.getGenericName());
            stockDTO.reOrderingLevel=(medicine.getReOrderingLevel());
            stockDTOList.add(stockDTO);


        }
        return stockDTOList;
    }
}
