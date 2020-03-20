package com.mariuszf.rentflat.costservice.dataaccess;


import com.mariuszf.rentflat.costservice.business.FlatCost;
import com.mariuszf.rentflat.costservice.business.RoomCost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CostDataAccessImpl implements CostDataAccess {

    @Value("${rent-flat.flat-room-crud.ip}")
    private String flatRoomCrudIP;

    @Value("${rent-flat.flat-room-crud.port}")
    private String flatRoomCrudPort;

    @Override
    public FlatCost getFlatCostById(Long id) {
        String url = "http://" + flatRoomCrudIP + ":" + flatRoomCrudPort + "/flat/" + id;
        return new RestTemplate().getForObject(url, FlatCost.class);
    }

    @Override
    public List<RoomCost> getRoomsByFlatId(Long id) {
        String url = "http://" + flatRoomCrudIP + ":" + flatRoomCrudPort + "/flat/" + id + "/rooms";
        RoomCost[] rooms = new RestTemplate().getForObject(url, RoomCost[].class);
        if (rooms != null) {
            return Arrays.asList(rooms);
        } else return Collections.emptyList();
    }
}
