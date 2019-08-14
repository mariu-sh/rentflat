package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.buisness.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int cost;
    @Column
    private double totalSurface;
    @Column
    private int roomsAmount;

    FlatEntity(int cost, double totalSurface, int roomsAmount) {
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

    public FlatEntity() {
    }

    public FlatDTO buildDTO(){
        return new FlatDTO(id, cost, totalSurface, roomsAmount);
    }

    public int getCost() {
        return cost;
    }

    public double getTotalSurface() {
        return totalSurface;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }
}
