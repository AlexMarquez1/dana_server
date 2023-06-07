package com.isae.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isae.web.entity.VistaDatosMatchValores;

@Repository
public interface IVistaDatosMatchISSSTE extends JpaRepository<VistaDatosMatchValores,Integer> {
	
	

}
