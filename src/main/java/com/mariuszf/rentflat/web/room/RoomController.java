package com.mariuszf.rentflat.web.room;

import com.mariuszf.rentflat.buisness.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public RoomDTO createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
        return roomService.createRoom(createRoomDTO);
    }

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping
    public List<RoomDTO> getRooms() {
        return roomService.getRooms();
    }

    @PutMapping("/{id}")
    public RoomDTO updateRoomById(@PathVariable Long id, @RequestBody UpdateRoomDTO updateRoomDTO) {
        return roomService.updateRoomById(id, updateRoomDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
         roomService.deleteRoomById(id);
    }
}
