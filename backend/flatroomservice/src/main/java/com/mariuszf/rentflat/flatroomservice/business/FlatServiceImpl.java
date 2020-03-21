package com.mariuszf.rentflat.flatroomservice.business;

import com.mariuszf.rentflat.flatroomservice.database.FlatEntity;
import com.mariuszf.rentflat.flatroomservice.database.FlatRepository;
import com.mariuszf.rentflat.flatroomservice.web.dto.FlatDTO;
import com.mariuszf.rentflat.flatroomservice.web.exception.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatServiceImpl implements FlatService {

    private FlatRepository flatRepository;

    @Autowired
    public FlatServiceImpl(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Override
    public FlatDTO getFlatById(Long id) {
        return getFlatEntityById(id).toDto();
    }

    @Override
    public List<FlatDTO> getAllFlats() {
        return getAllFlatEntities()
                .stream()
                .map(FlatEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlatDTO createFlat(Double cost, Double surface) {
        return flatRepository.save(new FlatEntity(cost, surface)).toDto();
    }

    @Override
    public FlatDTO updateFlatById(Long id, Double cost, Double surface){
        FlatEntity flatEntity = getFlatEntityById(id);
        flatEntity.setCost(cost);
        flatEntity.setSurface(surface);
        return flatRepository.save(flatEntity).toDto();
    }

    @Override
    public void deleteFlatById(Long id){
        flatRepository.delete(getFlatEntityById(id));
    }

    private List<FlatEntity> getAllFlatEntities() {
        return flatRepository.findAll();
    }

    private FlatEntity getFlatEntityById(Long id){
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
    }

}
