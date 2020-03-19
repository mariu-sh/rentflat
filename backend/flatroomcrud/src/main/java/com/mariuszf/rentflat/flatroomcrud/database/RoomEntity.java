package com.mariuszf.rentflat.flatroomcrud.database;

import com.mariuszf.rentflat.flatroomcrud.web.dto.RoomCostDTO;
import com.mariuszf.rentflat.flatroomcrud.web.dto.RoomDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private Double surface;

    @ManyToOne
    @JoinColumn(name = "flat_id")
    private FlatEntity flatEntity;

    public RoomEntity(Double surface, FlatEntity flatEntity) {
        this.surface = surface;
        this.flatEntity = flatEntity;
    }

    public RoomEntity() {
    }

    private Double calculateRentCost(){
        Double flatSurface = flatEntity.getSurface();
        List<RoomEntity> roomEntities = flatEntity.getRoomEntityList();
        Integer roomsAmount = roomEntities.size();
        Double commonPartSurface = flatSurface - roomEntities.stream().mapToDouble(RoomEntity::getSurface).sum();
        return (flatEntity.getCost()/flatSurface)*(commonPartSurface/roomsAmount + this.surface);
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public Double getSurface() {
        return surface;
    }

    public FlatEntity getFlatEntity() {
        return flatEntity;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public RoomDTO toDto(){
        return new RoomDTO(id, uuid, surface, flatEntity.getId());
    }

    public RoomCostDTO toCostDto(){
        return new RoomCostDTO(id, uuid, calculateRentCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
