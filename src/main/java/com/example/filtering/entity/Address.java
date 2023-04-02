package com.example.filtering.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "address")
public class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long addressId;

        private String city;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
        private Student student;

    public Address() {
        super();
    }
}
