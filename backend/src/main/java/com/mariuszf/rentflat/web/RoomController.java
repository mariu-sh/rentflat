package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.buisness.FlatRoomService;
import com.mariuszf.rentflat.web.dto.RoomCreateDTO;
import com.mariuszf.rentflat.web.dto.RoomCostDTO;
import com.mariuszf.rentflat.web.dto.RoomDTO;
import com.mariuszf.rentflat.web.dto.RoomUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private FlatRoomService flatRoomService;


    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomCreateDTO roomCreateDTO) {
        return flatRoomService.createRoom(roomCreateDTO);
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
    public RoomDTO updateRoomById(@PathVariable Long id, @RequestBody RoomUpdateDTO roomUpdateDTO) {
        return flatRoomService.updateRoomById(id, roomUpdateDTO);
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
        return flatRoomService.getRoomCostDTOById(id);
    }
}
