package com.isae.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.isae.web.entity.Perfile;

@Repository
public interface IPerfilesDAO extends JpaRepository<Perfile,Integer>{

}
