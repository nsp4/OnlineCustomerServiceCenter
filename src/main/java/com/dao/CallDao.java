package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Call;
@Repository
public interface CallDao extends JpaRepository<Call, Integer> {

}
