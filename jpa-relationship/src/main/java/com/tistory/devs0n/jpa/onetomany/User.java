package com.tistory.devs0n.jpa.onetomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<>();

    public User() {
    }

    public User addAddress(Address address) {
        this.addresses.add(address);
        return this;
    }

    public User removeAllAddresses() {
        this.addresses.clear();
        return this;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OMUser{" +
            "id=" + id +
            ", addresses=" + addresses +
            '}';
    }
}
