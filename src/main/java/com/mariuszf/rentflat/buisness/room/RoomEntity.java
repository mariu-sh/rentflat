package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.web.room.RoomDTO;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private double size;
    @Column
    private int people;
    @Column
    private double cost;

    public RoomEntity(double size, int people, double cost) {
        this.size = size;
        this.people = people;
        this.cost = cost;
    }

    public RoomEntity() {
    }

    public RoomDTO buildDTO() {
        return new RoomDTO(size, people, cost);
    }

    public Long getId() {
        return id;
    }

    public double getSize() {
        return size;
    }

    public int getPeople() {
        return people;
    }

    public double getCost() {
        return cost;
    }
}
