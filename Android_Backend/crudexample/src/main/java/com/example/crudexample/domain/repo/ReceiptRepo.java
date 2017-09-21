package com.example.crudexample.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudexample.domain.entity.Receipt;

public interface ReceiptRepo extends JpaRepository<Receipt, Long>{

}
