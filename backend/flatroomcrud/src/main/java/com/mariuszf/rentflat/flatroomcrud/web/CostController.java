package com.mariuszf.rentflat.flatroomcrud.web;

import com.mariuszf.rentflat.flatroomcrud.business.FlatRoomCRUDService;
import com.mariuszf.rentflat.flatroomcrud.web.dto.FlatCostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cost")
public class CostController {

    private FlatRoomCRUDService flatRoomService;

    @Autowired
    public CostController(FlatRoomCRUDService flatRoomService) {
        this.flatRoomService = flatRoomService;
    }

    @GetMapping("/flat")
    public List<FlatCostDTO> getAllFlatsCost() {return flatRoomService.getAllFlatsCost(); }

    @GetMapping("/flat/{id}")
    public FlatCostDTO getById(@PathVariable Long id) { return flatRoomService.getFlatCostById(id);}

}
