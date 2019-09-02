package com.mariuszf.rentflat.database;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(nullable = false, precision = 2)
    private BigDecimal surface;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatEntity flatEntity;

    public RoomEntity(double surface, FlatEntity flatEntity) {
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
        this.flatEntity = flatEntity;
    }

    public RoomEntity() {
    }

    public BigDecimal getCost(){
        return getCostForSurface().add(getCostForCommonPartSurface());
    }

    private BigDecimal getCostForSurface(){
        return flatEntity.getCostPerSurface().multiply(getSurface());
    }

    private BigDecimal getCostForCommonPartSurface() {
        return flatEntity.getCommonPartCostPerRoom();
    }

    public void update(double surface) {
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public FlatEntity getFlatEntity() {
        return flatEntity;
    }

    public Long getFlatId() {
        return flatEntity.getId();
    }

    public void setSurface(double surface) {
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
    }
}
