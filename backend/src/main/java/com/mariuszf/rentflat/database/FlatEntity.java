package com.mariuszf.rentflat.database;


import com.mariuszf.rentflat.web.dto.FlatCostDTO;
import com.mariuszf.rentflat.web.dto.FlatDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "flat")
public class FlatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private Double surface;

    @Column(nullable = false)
    private Double cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "flatEntity", orphanRemoval = true)
    private List<RoomEntity> roomEntityList;

    public FlatEntity(Double cost, Double surface) {
        this.cost = cost;
        this.surface = surface;
        this.roomEntityList = new ArrayList<>();
    }

    public FlatEntity() {
    }

    public FlatDTO toDto(){
        return new FlatDTO(id, uuid, surface, cost);
    }

    public FlatCostDTO toCostDto(){
        return new FlatCostDTO(id,
                uuid,
                cost,
                roomEntityList.stream()
                        .map(RoomEntity::toCostDto)
                        .collect(Collectors.toList())
        );
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSurface() {
        return surface;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatEntity that = (FlatEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
