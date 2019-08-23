package com.mariuszf.rentflat.database.flat;


import com.mariuszf.rentflat.database.room.RoomEntity;

import javax.persistence.*;
import java.util.*;

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
    private List<RoomEntity> rooms = new ArrayList<>();

    FlatEntity(double cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatEntity() {
    }

    public void update(double cost, double surface){
        this.cost = cost;
        this.surface = surface;
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
