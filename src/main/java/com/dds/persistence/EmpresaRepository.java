package com.dds.persistence;


import com.dds.persistence.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{

}

