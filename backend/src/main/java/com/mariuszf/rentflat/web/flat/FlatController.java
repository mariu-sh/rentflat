package com.mariuszf.rentflat.web.flat;

import com.mariuszf.rentflat.buisness.flat.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @PostMapping
    public FlatDTO createFlat(@RequestBody CreateFlatDTO createFlatDTO)
    {
        return flatService.createFlat(createFlatDTO);
    }

    @GetMapping
    public List<FlatDTO> getFlats() {
        return flatService.getFlatDTOList();
    }

    @GetMapping("/{id}")
    public FlatDTO getFlatById(@PathVariable Long id) {
        return flatService.getFlatDTOById(id);
    }

    @PutMapping("/{id}")
    public FlatDTO updateFlatById(@PathVariable Long id, @RequestBody UpdateFlatDTO updateFlatDTO) {
        return flatService.updateFlatById(id, updateFlatDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFlatById(@PathVariable Long id) {
        flatService.deleteFlatById(id);
    }

}
