package com.mariuszf.rentflat.database.flat;

import com.mariuszf.rentflat.buisness.flat.FlatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepository extends CrudRepository<FlatEntity, Long> {

    @Override
    List<FlatEntity> findAll();
}
