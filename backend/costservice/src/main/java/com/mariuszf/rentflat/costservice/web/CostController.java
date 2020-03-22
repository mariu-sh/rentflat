package com.mariuszf.rentflat.costservice.web;

import com.mariuszf.rentflat.costservice.business.CostService;
import com.mariuszf.rentflat.costservice.business.FlatCost;
import com.mariuszf.rentflat.costservice.business.RoomCost;
import com.mariuszf.rentflat.costservice.web.dto.FlatCostDTO;
import com.mariuszf.rentflat.costservice.web.dto.RoomCostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class CostController {

    private CostService costService;

    @Autowired
    public CostController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/flat/{id}")
    public FlatCostDTO getFlatCostById(@Valid @PathVariable Long id){
        return toCostDto(costService.getFlatCostById(id));
    }

    private FlatCostDTO toCostDto(FlatCost flatCost){
        return new FlatCostDTO(
                flatCost.getId(),
                flatCost.getCost(),
                flatCost.getRooms()
                        .stream()
                        .map(this::toCostDto)
                        .collect(Collectors.toList())
                );
    }

    private RoomCostDTO toCostDto(RoomCost roomCost){
        return new RoomCostDTO(roomCost.getId(), roomCost.getCost());
    }

}
