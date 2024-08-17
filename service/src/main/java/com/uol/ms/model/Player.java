package com.uol.ms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity(name = "players")
@Table(name = "players")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    private String codiName;

    private  GroupType groupType;

    public Player(String name, String email, String phoneNumber, GroupType groupType) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.groupType = groupType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCodiName() {
        return codiName;
    }

    public void setCodiName(String codiName) {
        this.codiName = codiName;
    }

    public GroupType getGroupType() {
        return groupType;
    }
}
