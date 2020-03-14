package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.business.FlatRoomService;
import com.mariuszf.rentflat.web.dto.FlatCostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cost")
public class CostController {

    private FlatRoomService flatRoomService;

    @Autowired
    public CostController(FlatRoomService flatRoomService) {
        this.flatRoomService = flatRoomService;
    }

    @GetMapping("/flat")
    public List<FlatCostDTO> getAllFlatsCost() {return flatRoomService.getAllFlatsCost(); }

    @GetMapping("/flat/{id}")
    public FlatCostDTO getById(@PathVariable Long id) { return flatRoomService.getFlatCostById(id);}

}
