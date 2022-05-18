package com.lhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.PatientPreData;
@Repository
public interface PatientPreDataRepo extends JpaRepository<PatientPreData, Integer> {

}
