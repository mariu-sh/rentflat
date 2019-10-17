package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.buisness.FlatRoomService;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flat")
public class FlatController {

    private FlatRoomService flatRoomService;

    @Autowired
    public FlatController(FlatRoomService flatRoomService) {
        this.flatRoomService = flatRoomService;
    }

    @GetMapping("/{id}")
    public FlatDTO getById(@PathVariable Long id){
        return flatRoomService.getFlatById(id);
    }

}
