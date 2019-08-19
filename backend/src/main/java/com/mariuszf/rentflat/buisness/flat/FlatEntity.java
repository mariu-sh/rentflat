package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.buisness.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany
    private List<RoomEntity> roomEntities;

    public FlatEntity(double cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatEntity() {
    }

    public FlatDTO buildDTO() {
        return new FlatDTO(id, cost, surface, getRoomDTOSFromEntities());
    }

    public List<RoomDTO> getRoomDTOSFromEntities() {
        return roomEntities.stream().map(RoomEntity::buildDTO).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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

    public void setRoomEntities(List<RoomEntity> roomEntities) {
        this.roomEntities = roomEntities;
    }
}
