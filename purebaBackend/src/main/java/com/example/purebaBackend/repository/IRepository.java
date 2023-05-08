package com.example.purebaBackend.repository;
import com.example.purebaBackend.entity.CModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface IRepository extends JpaRepository<CModel, Long>{




    Optional<CModel> findByProductId(int productId);
    Optional<CModel> findByBrandId(int brandId);
    Optional<CModel> findByStartDate(Timestamp startDate);
}
