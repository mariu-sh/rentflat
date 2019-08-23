package com.mariuszf.rentflat.database.flat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
}
