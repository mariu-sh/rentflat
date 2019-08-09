package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.RoomRepository;
import com.mariuszf.rentflat.web.RoomDTO;
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
}
