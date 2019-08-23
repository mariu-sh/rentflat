package com.mariuszf.rentflat.database.room;

import com.mariuszf.rentflat.database.flat.FlatEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(nullable = false)
    private double surface;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatEntity flatEntity;

    public RoomEntity(double surface, FlatEntity flatEntity) {
        this.surface = surface;
        this.flatEntity = flatEntity;
    }

    public RoomEntity() {
    }

    public void update(double surface) {
        this.surface = surface;
    }

    public long getId() {
        return id;
    }

    public double getSurface() {
        return surface;
    }

    public FlatEntity getFlatEntity() {
        return flatEntity;
    }

    public Long getFlatId() {
        return flatEntity.getId();
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setFlatEntity(FlatEntity flatEntity) {
        this.flatEntity = flatEntity;
    }
}
