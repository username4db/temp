package com.example.demo.postgres.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.postgres.entity.PEntity;

public interface PRepo extends JpaRepository<PEntity, String> {

	PEntity findBySeq(String seq);

	List<PEntity> findAllByNum(BigDecimal num);
}
