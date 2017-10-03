package com.dds.persistence;

import com.dds.persistence.Metodologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MetodologiaRepository extends JpaRepository<Metodologia, Long> {

}