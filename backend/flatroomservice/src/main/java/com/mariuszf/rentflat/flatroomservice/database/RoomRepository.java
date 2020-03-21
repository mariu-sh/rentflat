package com.mariuszf.rentflat.flatroomservice.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query(value = "SELECT * FROM room WHERE room.flat_id = :flat_id", nativeQuery = true)
    List<RoomEntity> findAllByFlatId(@Param("flat_id") Long flatId);
}
