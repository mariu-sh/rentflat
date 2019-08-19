package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.buisness.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;
<<<<<<< HEAD
import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;
import java.util.List;
=======
import com.mariuszf.rentflat.web.flat.UpdateFlatDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
>>>>>>> relation
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

<<<<<<< HEAD
    @OneToMany
    private List<RoomEntity> roomEntities;

    public FlatEntity(double cost, double surface) {
=======
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatId", cascade = CascadeType.ALL)
    private Set<RoomEntity> rooms = new HashSet<RoomEntity>();

    FlatEntity(double cost, double surface) {
>>>>>>> relation
        this.cost = cost;
        this.surface = surface;
    }

    public FlatEntity() {
    }

<<<<<<< HEAD
    public FlatDTO buildDTO() {
        return new FlatDTO(id, cost, surface, getRoomDTOSFromEntities());
    }

    public List<RoomDTO> getRoomDTOSFromEntities() {
        return roomEntities.stream().map(RoomEntity::buildDTO).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
=======
    public FlatDTO buildDTO(){
        return new FlatDTO(id, cost, surface, buildRoomDTOList());
    }

    private List<RoomDTO> buildRoomDTOList() {
        return rooms.stream().map(RoomEntity::buildDTO).collect(Collectors.toList());
    }

    public void update(UpdateFlatDTO updateFlatDTO) {
        setCost(updateFlatDTO.getCost());
        setSurface(updateFlatDTO.getCost());
>>>>>>> relation
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
<<<<<<< HEAD

    public void setRoomEntities(List<RoomEntity> roomEntities) {
        this.roomEntities = roomEntities;
    }
=======
>>>>>>> relation
}
