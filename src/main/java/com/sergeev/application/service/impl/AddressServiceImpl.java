package com.sergeev.application.service.impl;

import com.sergeev.application.entity.Address;
import com.sergeev.application.repository.AddressRepository;
import com.sergeev.application.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public Address findById(Integer id, boolean flag) {
        return addressRepository.findById(id, flag);
    }

}
