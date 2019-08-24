package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.buisness.FlatRoomService;
import com.mariuszf.rentflat.web.dto.FlatCreateDTO;
import com.mariuszf.rentflat.web.dto.FlatCostDTO;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import com.mariuszf.rentflat.web.dto.FlatUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    private FlatRoomService flatRoomService;

    @PostMapping
    public FlatDTO createFlat(@RequestBody FlatCreateDTO flatCreateDTO)
    {
        return flatRoomService.createFlat(flatCreateDTO);
    }

    @GetMapping
    public List<FlatDTO> getFlats() {
        return flatRoomService.getFlats();
    }

    @GetMapping("/{id}")
    public FlatDTO getFlatById(@PathVariable Long id) {
        return flatRoomService.getFlatById(id);
    }

    @PutMapping("/{id}")
    public FlatDTO updateFlatById(@PathVariable Long id, @RequestBody FlatUpdateDTO flatUpdateDTO) {
        return flatRoomService.updateFlatById(id, flatUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlatById(@PathVariable Long id) {
        flatRoomService.deleteFlatById(id);
    }

    @GetMapping("/cost")
    public List<FlatCostDTO> getFlatsCost() {
        return flatRoomService.getFlatsCost();
    }

    @GetMapping("/{id}/cost")
    public FlatCostDTO getFlatCostById(@PathVariable Long id) {
        return flatRoomService.getFlatCostById(id);
    }

}
