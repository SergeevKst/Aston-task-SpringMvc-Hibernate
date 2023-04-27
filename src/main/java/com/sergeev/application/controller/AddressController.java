package com.sergeev.application.controller;

import com.sergeev.application.entity.Address;
import com.sergeev.application.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping(value = "/{id}/{flag}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Address> getAddressById(@PathVariable("id") int id,
                                                                @PathVariable("flag") boolean flag) {

        Address byId = addressService.findById(id, flag);
        return new ResponseEntity<>(byId, OK);
    }
}
