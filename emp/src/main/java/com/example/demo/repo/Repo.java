package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.Empdata;

public interface Repo extends JpaRepository<Empdata,Long>{

}
