package com.mariuszf.rentflat.web;

import com.mariuszf.rentflat.buisness.FlatEntity;
import com.mariuszf.rentflat.buisness.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flat")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @GetMapping
    public FlatEntity getDefaultFlat()
    {
        return flatService.createDefaultFlat();
    }

}
