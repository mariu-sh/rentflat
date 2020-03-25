package com.mariuszf.rentflat.web.dto;

public class RoomDTO {

    private final Long id;
    private final String uuid;
    private final Double surface;
    private final Long flatId;

    public RoomDTO(Long id, String uuid, Double surface, Long flatId) {
        this.id = id;
        this.uuid = uuid;
        this.surface = surface;
        this.flatId = flatId;
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

    public Long getFlatId() {
        return flatId;
    }
}
