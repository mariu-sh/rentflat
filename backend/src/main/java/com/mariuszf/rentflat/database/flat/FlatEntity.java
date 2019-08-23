package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.buisness.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.flat.UpdateFlatDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private double cost;
    @Column
    private double surface;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatId", cascade = CascadeType.ALL)
    private Set<RoomEntity> rooms = new HashSet<RoomEntity>();

    FlatEntity(double cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatEntity() {
    }
    public FlatDTO buildDTO(){
        return new FlatDTO(id, cost, surface, buildRoomDTOList());
    }

    private List<RoomDTO> buildRoomDTOList() {
        return rooms.stream().map(RoomEntity::buildDTO).collect(Collectors.toList());
    }

    public void update(UpdateFlatDTO updateFlatDTO) {
        setCost(updateFlatDTO.getCost());
        setSurface(updateFlatDTO.getCost());
    }

    public double getCost() {
        return cost;
    }

    public double getSurface() {
        return surface;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }
}
