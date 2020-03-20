package com.mariuszf.rentflat.flatroomcrud.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomDTO {
    private final Long id;
    private final String uuid;
    private final Double surface;
    private final Long flatId;
}
