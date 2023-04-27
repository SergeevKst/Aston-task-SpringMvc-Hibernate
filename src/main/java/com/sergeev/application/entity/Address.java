package com.sergeev.application.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "address", schema = "railway")
@NamedQueries({
        @NamedQuery(name = "Address.getAddressById", query = "select a from Address a left join fetch a.employeeList where a.id = :id"),
        @NamedQuery(name = "Address.getAddressByIdLazy", query = "select a from Address a where a.id = :id")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address", nullable = false)
    private int idAddress;

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Basic
    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Employee> employeeList = new ArrayList<>();
}
