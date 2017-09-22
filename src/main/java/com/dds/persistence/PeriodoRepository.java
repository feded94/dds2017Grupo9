package com.dds.persistence;

import com.dds.persistence.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PeriodoRepository extends JpaRepository <Periodo, Long>{

}

