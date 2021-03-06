package com.mariuszf.rentflat.flatroomservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class RoomUpdateDTO {
    @NotNull private final Long id;
    @NotNull private final Double surface;
}
