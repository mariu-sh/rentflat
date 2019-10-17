package com.mariuszf.rentflat.database;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
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

    public long getId() {
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
