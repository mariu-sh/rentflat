package com.mariuszf.rentflat.flatroomcrud.web;

import com.mariuszf.rentflat.flatroomcrud.business.FlatRoomCRUDService;
import com.mariuszf.rentflat.flatroomcrud.web.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomsForFlatController {

    private FlatRoomCRUDService flatRoomCRUDService;

    @Autowired
    public RoomsForFlatController(FlatRoomCRUDService flatRoomCRUDService) {
        this.flatRoomCRUDService = flatRoomCRUDService;
    }

    @GetMapping("/flat/{flatId}/rooms")
    public List<RoomDTO> getRoomsByFlatId(@PathVariable Long flatId){
        return flatRoomCRUDService.getRoomsByFlatId(flatId);
    }

}
