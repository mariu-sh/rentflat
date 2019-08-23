package com.mariuszf.rentflat.web.flat;

import com.mariuszf.rentflat.buisness.FlatRoomService;
import com.mariuszf.rentflat.web.flat.dto.CreateFlatDTO;
import com.mariuszf.rentflat.web.flat.dto.FlatCostDTO;
import com.mariuszf.rentflat.web.flat.dto.FlatDTO;
import com.mariuszf.rentflat.web.flat.dto.UpdateFlatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    private FlatRoomService flatRoomService;

    @PostMapping
    public FlatDTO createFlat(@RequestBody CreateFlatDTO createFlatDTO)
    {
        return flatRoomService.createFlat(createFlatDTO);
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
    public FlatDTO updateFlatById(@PathVariable Long id, @RequestBody UpdateFlatDTO updateFlatDTO) {
        return flatRoomService.updateFlatById(id, updateFlatDTO);
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
