package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private double size;
    @Column
    private double cost;
    @Column
    private int peopleAmount;

    public RoomEntity(double size, int peopleAmount, double cost) {
        this.size = size;
        this.peopleAmount = peopleAmount;
        this.cost = cost;
    }

    public RoomEntity() {
    }

    public RoomDTO buildDTO() {
        return new RoomDTO(id, size, peopleAmount, cost);
    }

    public long getId() {
        return id;
    }

    public double getSize() {
        return size;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public double getCost() {
        return cost;
    }
}
