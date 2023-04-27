package com.sergeev.application.service;

import com.sergeev.application.entity.Address;

public interface AddressService {
    Address findById(Integer id, boolean flag);
}
