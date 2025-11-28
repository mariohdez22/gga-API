package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="color_tarjeta")
public class Color_tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColor;

    private String color;

}
