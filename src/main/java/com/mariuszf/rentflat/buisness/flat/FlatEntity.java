package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.buisness.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;
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
    private double totalSurface;
    @Column
    private int roomsAmount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatId")
    private Set<RoomEntity> rooms = new HashSet<RoomEntity>();

    FlatEntity(double cost, double totalSurface, int roomsAmount) {
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

    public FlatEntity() {
    }

    public FlatDTO buildDTO(){
        return new FlatDTO(id, cost, totalSurface, roomsAmount, buildRoomDTOList());
    }

    private List<RoomDTO> buildRoomDTOList() {
        return rooms.stream().map(RoomEntity::buildDTO).collect(Collectors.toList());
    }

    public double getCost() {
        return cost;
    }

    public double getTotalSurface() {
        return totalSurface;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setTotalSurface(double totalSurface) {
        this.totalSurface = totalSurface;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }
}
