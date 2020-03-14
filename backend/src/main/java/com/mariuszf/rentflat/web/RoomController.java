package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.business.FlatRoomService;
import com.mariuszf.rentflat.web.dto.RoomCreateDTO;
import com.mariuszf.rentflat.web.dto.RoomDTO;
import com.mariuszf.rentflat.web.dto.RoomUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private FlatRoomService flatRoomService;

    @Autowired
    public RoomController(FlatRoomService flatRoomService) {
        this.flatRoomService = flatRoomService;
    }

    @GetMapping("/{id}")
    public RoomDTO getById(@PathVariable Long id){
        return flatRoomService.getRoomById(id);
    }

    @GetMapping
    public List<RoomDTO> getAll(){
        return flatRoomService.getAllRooms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDTO create(@Valid @RequestBody RoomCreateDTO roomCreateDTO){
        return flatRoomService.createRoom(roomCreateDTO.getSurface(), roomCreateDTO.getFlatId());
    }

    @PutMapping
    public RoomDTO update(@Valid @RequestBody RoomUpdateDTO roomUpdateDTO){
        return flatRoomService.updateRoomById(roomUpdateDTO.getId(), roomUpdateDTO.getSurface());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        flatRoomService.deleteRoomById(id);
    }

}
