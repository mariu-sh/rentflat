package com.mariuszf.rentflat.flatroomservice.database;

import com.mariuszf.rentflat.flatroomservice.web.dto.RoomDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "room")
@NoArgsConstructor
@Getter
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private Double surface;

    @ManyToOne
    @JoinColumn(name = "flat_id", insertable = false, updatable = false)
    private FlatEntity flatEntity;

    @Column(name = "flat_id")
    private Long flatId;

    public RoomEntity(Double surface, Long flatId) {
        this.surface = surface;
        this.flatId = flatId;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public RoomDTO toDto(){
        return new RoomDTO(id, uuid, surface, flatEntity.getId());
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
