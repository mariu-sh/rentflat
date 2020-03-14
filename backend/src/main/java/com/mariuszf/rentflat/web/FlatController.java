package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.business.FlatRoomService;
import com.mariuszf.rentflat.web.dto.FlatCreateDTO;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import com.mariuszf.rentflat.web.dto.FlatUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    private FlatRoomService flatRoomService;

    @Autowired
    public FlatController(FlatRoomService flatRoomService) {
        this.flatRoomService = flatRoomService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlatDTO create(@Valid @RequestBody FlatCreateDTO flatCreateDTO) {
        return flatRoomService.createFlat(flatCreateDTO.getCost(), flatCreateDTO.getSurface());
    }

    @GetMapping("/{id}")
    public FlatDTO getById(@PathVariable Long id){
        return flatRoomService.getFlatById(id);
    }

    @GetMapping
    public List<FlatDTO> getAll(){ return flatRoomService.getAllFlats(); }

    @PutMapping
    public FlatDTO updateById(@Valid @RequestBody FlatUpdateDTO flatUpdateDTO){
        return flatRoomService.updateFlatById(flatUpdateDTO.getId(),
                flatUpdateDTO.getCost(),
                flatUpdateDTO.getSurface());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){ flatRoomService.deleteFlatById(id); }

}
