package com.mariuszf.rentflat.flatroomservice.business;

import com.mariuszf.rentflat.flatroomservice.web.dto.FlatDTO;

import java.util.List;

public interface FlatService {

    FlatDTO getFlatById(Long id);
    List<FlatDTO> getAllFlats();
    FlatDTO createFlat(Double cost, Double surface);
    FlatDTO updateFlatById(Long id, Double cost, Double surface);
    void deleteFlatById(Long id);

}
