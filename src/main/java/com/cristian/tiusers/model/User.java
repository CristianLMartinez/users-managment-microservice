package com.cristian.tiusers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastname;
    private String address;
    private String telephone;

    private String position;

    @Column(name = "residence_city")
    private String residenceCity;

    private boolean state;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        User user = (User) other;
        return id == user.id &&
                state == user.state &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(address, user.address) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(position, user.position) &&
                Objects.equals(residenceCity, user.residenceCity) &&
                Objects.equals(company, user.company) &&
                Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, address, telephone, position, residenceCity, state, company, department);
    }

}
