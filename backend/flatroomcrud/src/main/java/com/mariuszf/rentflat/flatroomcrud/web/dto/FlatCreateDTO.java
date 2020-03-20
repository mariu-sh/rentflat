package com.mariuszf.rentflat.flatroomcrud.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlatCreateDTO {
    @NotNull private Double cost;
    @NotNull private Double surface;
}
