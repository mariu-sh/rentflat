package com.mariuszf.rentflat.database;

import com.mariuszf.rentflat.buisness.RoomEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
    @Override
    List<RoomEntity> findAll();
}
