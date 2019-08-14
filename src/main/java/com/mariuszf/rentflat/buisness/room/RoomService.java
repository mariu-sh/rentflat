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
        return createRoom(createRoomDTO.getSize(), createRoomDTO.getPeopleAmount(), createRoomDTO.getCost());
    }

    private RoomDTO createRoom(double size, int peopleAmount, double cost) {
        RoomEntity roomEntity = new RoomEntity(size, peopleAmount, cost);
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
        roomEntity.setSize(updateRoomDTO.getSize());
        roomEntity.setPeopleAmount(updateRoomDTO.getPeopleAmount());
        roomEntity.setCost(updateRoomDTO.getCost());
        return roomRepository.save(roomEntity).buildDTO();
    }

    public void deleteRoomById(Long id) {
        roomRepository.delete(
                roomRepository.findById(id).orElseThrow(RoomNotFoundException::new)
        );
    }
}
