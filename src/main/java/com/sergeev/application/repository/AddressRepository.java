package com.sergeev.application.repository;

import com.sergeev.application.entity.Address;

public interface AddressRepository {
    Address findById(Integer id, boolean flag);
}
