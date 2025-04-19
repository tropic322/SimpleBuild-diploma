package ru.sfedu.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@AllArgsConstructor
@Table(name ="window1")
public class Window {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    private int cost;
    private int buildingHours;
    private int durabilityYears;
    private double thermalConductivity;

}
