package com.sergeev.application.repository.impl;

import com.sergeev.application.repository.AddressRepository;
import com.sergeev.application.entity.Address;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Address findById(Integer id, boolean flag) {
        Address address;
        TypedQuery<Address> query;
        if (flag) {
            query = sessionFactory.getCurrentSession()
                    .createNamedQuery("Address.getAddressById", Address.class)
                    .setParameter("id", id);
            address = query.getSingleResult();
            return address;
        }
        query = sessionFactory.getCurrentSession()
                .createNamedQuery("Address.getAddressByIdLazy", Address.class)
                .setParameter("id", id);
        address = query.getSingleResult();
        address.setEmployeeList(null);
        return address;
    }
}
