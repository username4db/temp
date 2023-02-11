package com.example.demo.oracle.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.oracle.entity.OEntity;

public interface ORepo extends JpaRepository<OEntity, String> {

	OEntity findBySeq(String seq);

	List<OEntity> findAllByNum(BigDecimal num);
}
