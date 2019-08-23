package com.mariuszf.rentflat.database.room;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private double surface;
    @Column
    private double cost;
    @Column
    private Long flatId;

    public RoomEntity(double surface, double cost, Long flatId) {
        this.surface = surface;
        this.cost = cost;
        this.flatId = flatId;
    }

    public RoomEntity() {
    }

    public void update(double cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public long getId() {
        return id;
    }

    public double getSurface() {
        return surface;
    }

    public double getCost() {
        return cost;
    }
}
