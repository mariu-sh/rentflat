package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.web.room.RoomDTO;
import com.mariuszf.rentflat.web.room.UpdateRoomDTO;

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

    public RoomDTO buildDTO() {
        return new RoomDTO(id, surface, cost);
    }

    public void update(UpdateRoomDTO updateRoomDTO) {
        setCost(updateRoomDTO.getCost());
        setSurface(updateRoomDTO.getSurface());
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

    public void setSurface(double size) {
        this.surface = size;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
