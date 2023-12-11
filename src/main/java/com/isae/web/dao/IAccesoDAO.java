package com.isae.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isae.web.entity.Acceso;


@Repository
public interface IAccesoDAO extends JpaRepository<Acceso,Integer>{
	

}
