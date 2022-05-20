package com.lhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.Nurse;
@Repository
public interface NurseRepo extends JpaRepository<Nurse, Integer> {

}
