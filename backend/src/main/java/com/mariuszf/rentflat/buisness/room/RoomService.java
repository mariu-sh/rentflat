package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.database.room.RoomRepository;
import com.mariuszf.rentflat.web.room.CreateRoomDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;
import com.mariuszf.rentflat.web.room.RoomNotFoundException;
import com.mariuszf.rentflat.web.room.UpdateRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO createRoom(CreateRoomDTO createRoomDTO) {
<<<<<<< HEAD:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomService.java
        return createRoom(createRoomDTO.getSize(), createRoomDTO.getPeopleAmount(), createRoomDTO.getCost(),
                createRoomDTO.getFlatId());
    }

    private RoomDTO createRoom(double size, int peopleAmount, double cost, Long flatId) {
        RoomEntity roomEntity = new RoomEntity(size, peopleAmount, cost, flatId);
=======
        return createRoom(createRoomDTO.getSurface(), createRoomDTO.getCost(), createRoomDTO.getFlatId());
    }

    private RoomDTO createRoom(double size, double cost, Long flatId) {
        RoomEntity roomEntity = new RoomEntity(size, cost, flatId);
>>>>>>> relation:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomService.java
        return roomRepository.save(roomEntity).buildDTO();
    }

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

    public RoomDTO updateRoomById(Long id, UpdateRoomDTO updateRoomDTO) {
        RoomEntity roomEntity = roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        roomEntity.update(updateRoomDTO);
        return roomRepository.save(roomEntity).buildDTO();
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    public void deleteRoomsByFlatId(Long id) {
        roomRepository.deleteAll(
                roomRepository.findAllByFlatIdIn(id)
        );
    }
}
