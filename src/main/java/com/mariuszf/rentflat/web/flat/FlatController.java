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

    @GetMapping
    public List<FlatDTO> getFlats() {
        return flatService.getFlats();
    }

    @GetMapping("/{id}")
    public FlatDTO getFlatById(@PathVariable Long id) {
        return flatService.getFlatById(id);
    }

    @PostMapping("/create")
    public FlatDTO createFlat(@RequestBody CreateFlatDTO createFlatDTO)
    {
        return flatService.createFlat(createFlatDTO);
    }

}