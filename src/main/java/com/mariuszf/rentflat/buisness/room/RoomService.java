package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.database.room.RoomRepository;
import com.mariuszf.rentflat.web.room.RoomDTO;
import com.mariuszf.rentflat.web.room.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> getRooms() {
        return roomRepository.findAll().stream()
                .map(RoomEntity::buildDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO getRoomById(long id) {
        return roomRepository.findById(id)
                .map(RoomEntity::buildDTO)
                .orElseThrow(RoomNotFoundException::new);
    }
}
