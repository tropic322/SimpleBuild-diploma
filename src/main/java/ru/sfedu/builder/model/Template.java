package ru.sfedu.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Component
@AllArgsConstructor
public class Template {
    @Id
    @Column(name = "id", nullable = false)
    private long id = System.currentTimeMillis();
    @OneToOne
    @Autowired
    private Fundament fundamentMaterial;
    @OneToOne
    @Autowired
    private WallMaterial wallMaterial;
    @OneToOne
    @Autowired
    private Partition partitionMaterial;
    @OneToOne
    @Autowired
    private SubroofingMaterial subroofingType;
    @OneToOne
    @Autowired
    private RoofMaterial roofMaterial;
    @OneToOne
    @Autowired
    private Window window;
    private long windowQuantity = 0;

    private boolean waterIsolation =true;
    private boolean vibrationIsolation =true;
    private boolean noiseIsolation =true;
    //private boolean[] isolationType = new boolean[]{false, false, false};
    @OneToOne
    @Autowired
    private WallFasingMaterial wallFacingMaterial;

    private int square;
    private int buildingHours;
}

