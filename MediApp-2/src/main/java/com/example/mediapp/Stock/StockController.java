package com.example.mediapp.Stock;

import com.example.mediapp.Medi.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class StockController {

    @Autowired
    StockService stockService;
    @Autowired
    MedicineRepo medicineRepo;

    @PostMapping("/addNewStock")
    public Response addStock(@RequestBody StockDTO newStock){
        Stock stock =new Stock();
        stock.setStrength(newStock.strength);
        stock.setAvailableQTY(newStock.availableQTY);
        stock.setExpDate(newStock.expDate);
        stock.setType(newStock.type);
        stock.setUnit(newStock.unit);
        stock.setMedicine(medicineRepo.findMedicineByGenericNameAndBrandName(newStock.genericName,newStock.brandName));
        System.out.println(newStock.strength);
        return stockService.addNewStock(stock);
    }

    @PostMapping("/getAllBrandNames")
    public List<String> getAllBrandNames() {

        return medicineRepo.getAllBrandNames();
    }
    @PostMapping("/getAllStockDetails")
    public List<StockDTO> getAllStockDetails(){
        return stockService.getAllStockDetails();
    }
}
