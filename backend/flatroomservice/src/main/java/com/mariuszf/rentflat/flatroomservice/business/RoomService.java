package com.mariuszf.rentflat.flatroomservice.business;

import com.mariuszf.rentflat.flatroomservice.web.dto.RoomDTO;

import java.util.List;

public interface RoomService {

    RoomDTO getRoomById(Long id);
    List<RoomDTO> getAllRooms();
    List<RoomDTO> getRoomsByFlatId(Long flatId);
    RoomDTO createRoom(Double surface, Long flatId);
    RoomDTO updateRoomById(Long id, Double surface);
    void deleteRoomById(Long id);
}
