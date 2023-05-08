package com.example.purebaBackend.controller;

import com.example.purebaBackend.entity.CModel;
import com.example.purebaBackend.service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CController {

    @Autowired
    CService cService;

    @GetMapping("all")
    private List <CModel> readItem(){
        return  cService.readItem();
    }

    @GetMapping("/search")
    public Optional<CModel> searchItem(
            @RequestParam(name = "productId", required = false) Integer productId,
            @RequestParam(name = "brandId", required = false) Integer brandId,
            @RequestParam(name = "startDate", required = false) Timestamp startDate
    ) {
        if (productId != null) {
            return cService.findByProductId(productId);
        } else if (brandId != null) {
            return cService.findByBrandId(brandId);
        } else if (startDate != null) {
            return cService.findByStartDate(startDate);
        } else {
            throw new IllegalArgumentException("Por favor ingresa un parametro de busqueda");
        }
    }


}
