package com.dds.Metodologias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CondicionRepository extends JpaRepository<Condicion, Long> {

}
