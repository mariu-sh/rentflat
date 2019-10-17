package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.FlatRepository;
import com.mariuszf.rentflat.database.RoomRepository;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import com.mariuszf.rentflat.web.exception.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatRoomService {

    private FlatRepository flatRepository;
    private RoomRepository roomRepository;

    @Autowired
    public FlatRoomService(FlatRepository flatRepository, RoomRepository roomRepository) {
        this.flatRepository = flatRepository;
        this.roomRepository = roomRepository;
    }

    public FlatDTO getFlatById(Long id) {
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new).toDto();
    }
}
