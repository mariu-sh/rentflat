package com.mariuszf.rentflat.database;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(nullable = false, precision = 2)
    private BigDecimal cost;

    @Column(nullable = false, precision = 2)
    private BigDecimal surface;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatEntity", orphanRemoval = true)
    private List<RoomEntity> roomEntityList = new ArrayList<>();

    public FlatEntity(double cost, double surface) {
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.CEILING);
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
    }

    public FlatEntity() {
    }

    public BigDecimal getCommonPartCostPerRoom() {
        return getCommonPartCost()
                .divide(new BigDecimal(getRoomsAmount()),
                        2, RoundingMode.CEILING);
    }

    public BigDecimal getCommonPartCost() {
        return getCostPerSurface().multiply(getCommonPartSurface());
    }

    public BigDecimal getCostPerSurface() {
        return cost.divide(surface, 2, RoundingMode.CEILING);
    }

    public BigDecimal getCommonPartSurface() {
        double roomsSurface = getRoomEntityList().stream()
                .map(RoomEntity::getSurface)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        return getSurface().subtract(new BigDecimal(roomsSurface));
    }

    public int getRoomsAmount() {
        return getRoomEntityList().size();
    }

    public void update(double cost, double surface){
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.CEILING);
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
    }

    public Long getId() {
        return id;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getSurface() {
        return surface;
    }
}
