package com.mariuszf.rentflat.flatroomcrud.database;


import com.mariuszf.rentflat.flatroomcrud.web.dto.FlatDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "flat")
@NoArgsConstructor
@Getter
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

    public FlatDTO toDto(){
        return new FlatDTO(id, uuid, surface, cost);
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
