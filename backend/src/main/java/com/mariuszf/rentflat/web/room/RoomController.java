package com.mariuszf.rentflat.web.room;

import com.mariuszf.rentflat.buisness.FlatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private FlatRoomService flatRoomService;


    @PostMapping
    public RoomDTO createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
        return flatRoomService.createRoom(createRoomDTO);
    }

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable long id) {
        return flatRoomService.getRoomById(id);
    }

    @GetMapping
    public List<RoomDTO> getRooms() {
        return flatRoomService.getRooms();
    }

    @PutMapping("/{id}")
    public RoomDTO updateRoomById(@PathVariable Long id, @RequestBody UpdateRoomDTO updateRoomDTO) {
        return flatRoomService.updateRoomById(id, updateRoomDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
         flatRoomService.deleteRoomById(id);
    }

    @GetMapping("/cost")
    public List<RoomCostDTO> getRoomsCost() {
        return flatRoomService.getRoomsCost();
    }

    @GetMapping("/{id}/cost")
    public RoomCostDTO getRoomCostById(@PathVariable Long id) {
        return flatRoomService.getRoomCostById(id);
    }
}
