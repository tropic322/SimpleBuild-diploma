package ru.sfedu.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@AllArgsConstructor
public class Partition {
    @Id
    private long id;
    private String name;
    private int cost;
    private int buildingHours;
    private boolean fireResistance;

}
