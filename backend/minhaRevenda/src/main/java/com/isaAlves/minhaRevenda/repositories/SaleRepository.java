package com.isaAlves.minhaRevenda.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isaAlves.minhaRevenda.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT obj from Sale obj where obj.date BETWEEN :minDate AND :maxDate ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate minDate, LocalDate maxDate, Pageable pageable);
}
