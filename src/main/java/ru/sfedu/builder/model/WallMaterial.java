package ru.sfedu.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@AllArgsConstructor
public class WallMaterial {
    @Id
    private long id;
    private String name;
    private int buildingHours;
    private int cost;
    private float heatLoss;

}
