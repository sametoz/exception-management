package com.fsk.em.repositories;

import com.fsk.em.models.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, Long> {
}
