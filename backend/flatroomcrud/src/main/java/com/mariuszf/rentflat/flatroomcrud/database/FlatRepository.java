package com.mariuszf.rentflat.flatroomcrud.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
}
