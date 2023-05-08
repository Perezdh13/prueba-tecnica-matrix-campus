package com.example.purebaBackend.service;

import com.example.purebaBackend.entity.CModel;
import com.example.purebaBackend.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CService {

    @Autowired
    private IRepository iRepository;

    public void createItem(CModel model) {
        iRepository.save(model);
    }

    public List<CModel> readItem(){
        List<CModel> model = new ArrayList<>(iRepository.findAll());
        return model;
    }

    public Optional<CModel> findByProductId(int productId) {
        return iRepository.findByProductId(productId);
    }
    public Optional<CModel> findByBrandId( int brandId) {
        return iRepository.findByBrandId(brandId);
    }
    public Optional<CModel> findByStartDate(Timestamp startDate){
        return iRepository.findByStartDate(startDate);
    }
}
