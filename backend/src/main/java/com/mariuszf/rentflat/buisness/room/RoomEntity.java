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

<<<<<<< HEAD:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
    @Column
    private Long flatId;


    public RoomEntity(double size, int peopleAmount, double cost, Long flatId) {
        this.size = size;
        this.peopleAmount = peopleAmount;
=======
    public RoomEntity(double surface, double cost, Long flatId) {
        this.surface = surface;
>>>>>>> relation:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
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

<<<<<<< HEAD:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
    public Long getFlatId() {
        return flatId;
    }

    public void setSize(double size) {
        this.size = size;
=======
    public void setSurface(double size) {
        this.surface = size;
>>>>>>> relation:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

<<<<<<< HEAD:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }
=======
>>>>>>> relation:backend/src/main/java/com/mariuszf/rentflat/buisness/room/RoomEntity.java
}
