package com.tistory.devs0n.jpa.onetomany;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    protected Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OMAddress{" +
            "id=" + id +
            ", address='" + address + '\'' +
            '}';
    }
}
