package com.mariuszf.rentflat.flatroomcrud.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class FlatUpdateDTO {
    @NotNull private final Long id;
    @NotNull private final Double cost;
    @NotNull private final Double surface;
}
