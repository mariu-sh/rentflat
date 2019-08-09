package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.buisness.FlatService;
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
    public FlatDTO createSomeFlat(@RequestBody CreateFlatDTO createFlatDTO)
    {
        return flatService.createFlat(createFlatDTO);
    }

}
