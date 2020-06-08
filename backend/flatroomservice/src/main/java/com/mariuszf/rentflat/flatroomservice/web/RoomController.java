package com.mariuszf.rentflat.flatroomservice.web;

import com.mariuszf.rentflat.flatroomservice.business.RoomService;
import com.mariuszf.rentflat.flatroomservice.web.dto.RoomCreateDTO;
import com.mariuszf.rentflat.flatroomservice.web.dto.RoomDTO;
import com.mariuszf.rentflat.flatroomservice.web.dto.RoomUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public RoomDTO getById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @GetMapping
    public List<RoomDTO> getAll(@RequestParam(required = false) Long flatId){
        if(flatId == null){
            return roomService.getAllRooms();
        }else return roomService.getRoomsByFlatId(flatId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDTO create(@Valid @RequestBody RoomCreateDTO roomCreateDTO){
        return roomService.createRoom(roomCreateDTO.getSurface(), roomCreateDTO.getFlatId());
    }

    @PutMapping
    public RoomDTO update(@Valid @RequestBody RoomUpdateDTO roomUpdateDTO){
        return roomService.updateRoomById(roomUpdateDTO.getId(), roomUpdateDTO.getSurface());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        roomService.deleteRoomById(id);
    }

}
