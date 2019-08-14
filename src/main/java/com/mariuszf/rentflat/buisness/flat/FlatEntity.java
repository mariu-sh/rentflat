package com.mariuszf.rentflat.buisness.flat;


import com.mariuszf.rentflat.web.flat.FlatDTO;

import javax.persistence.*;

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

    FlatEntity(double cost, double totalSurface, int roomsAmount) {
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

    public FlatEntity() {
    }

    public FlatDTO buildDTO(){
        return new FlatDTO(id, cost, totalSurface, roomsAmount);
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
