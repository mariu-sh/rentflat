package com.mariuszf.rentflat.flatroomservice.web;

import com.mariuszf.rentflat.flatroomservice.business.FlatService;
import com.mariuszf.rentflat.flatroomservice.web.dto.FlatCreateDTO;
import com.mariuszf.rentflat.flatroomservice.web.dto.FlatDTO;
import com.mariuszf.rentflat.flatroomservice.web.dto.FlatUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    private FlatService flatService;

    @Autowired
    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlatDTO create(@Valid @RequestBody FlatCreateDTO flatCreateDTO) {
        return flatService.createFlat(flatCreateDTO.getCost(), flatCreateDTO.getSurface());
    }

    @GetMapping("/{id}")
    public FlatDTO getById(@PathVariable Long id){
        return flatService.getFlatById(id);
    }

    @GetMapping
    public List<FlatDTO> getAll(){ return flatService.getAllFlats(); }

    @PutMapping
    public FlatDTO updateById(@Valid @RequestBody FlatUpdateDTO flatUpdateDTO){
        return flatService.updateFlatById(flatUpdateDTO.getId(),
                flatUpdateDTO.getCost(),
                flatUpdateDTO.getSurface());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){ flatService.deleteFlatById(id); }

}
