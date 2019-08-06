package com.mariuszf.rentflat.database;

import com.mariuszf.rentflat.buisness.FlatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends CrudRepository<FlatEntity, Integer> {

}
