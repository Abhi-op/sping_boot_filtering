package com.example.filtering.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "student")
public class Student {

    public Student() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name ="name")
    private String name;

      @OneToOne(cascade = {CascadeType.ALL})
      @JoinColumn(name = "address_id",referencedColumnName = "id")
      private Address address;

     @JsonManagedReference
     @OneToMany(mappedBy ="studentId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private Set<Subject> subjects;


}
