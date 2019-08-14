package com.mariuszf.rentflat.web.room;

import com.mariuszf.rentflat.buisness.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping
    public List<RoomDTO> getRooms() {
        return roomService.getRooms();
    }


}
