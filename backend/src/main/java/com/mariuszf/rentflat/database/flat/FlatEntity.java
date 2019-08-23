package com.mariuszf.rentflat.database.flat;


import com.mariuszf.rentflat.database.room.RoomEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private double surface;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatEntity", orphanRemoval = true)
    private List<RoomEntity> roomEntityList = new ArrayList<>();

    public FlatEntity(double cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatEntity() {
    }

    public double getCostPerSurface() {
        return cost/surface;
    }

    public void addRoom(RoomEntity roomEntity) {
        this.roomEntityList.add(roomEntity);
        roomEntity.setFlatEntity(this);
    }

    public void update(double cost, double surface){
        this.cost = cost;
        this.surface = surface;
    }

    public Long getId() {
        return id;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public double getCost() {
        return cost;
    }

    public double getSurface() {
        return surface;
    }
}
