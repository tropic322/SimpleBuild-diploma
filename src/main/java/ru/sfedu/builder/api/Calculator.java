package ru.sfedu.builder.api;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sfedu.builder.controller.InputController;
import ru.sfedu.builder.model.Template;

@Setter
@Getter
@NoArgsConstructor
@Component
public class Calculator {

    public static final Logger logger = LogManager.getLogger(Calculator.class);

    static  int cost;
    static  int buildingHours;
    @Autowired
    private Template template;

    @Autowired
    DataProvider dataProvider;

    public Calculator(long id) {
        logger.info("Calculator constructor");
        this.template = dataProvider.getById(Template.class,id).get();
    }

    public void calculateCost()
    {
        logger.info("Starting calculating cost");

        if(template!=null) {
            int fundamentCost = template.getFundamentMaterial().getCost();
            int partitionCost = template.getPartitionMaterial().getCost();
            int roofMaterialCost = template.getRoofMaterial().getCost();
            int subroofingMaterialCost = template.getSubroofingType().getCost();
            int wallFacingMaterialCost =template.getWallFacingMaterial().getCost();
            int wallMaterialCost =template.getWallMaterial().getCost();
            int windowCost=template.getWindow().getCost();
            int isolationCost=0;
            if (template.isNoiseIsolation()){
                isolationCost = isolationCost+ 10 ;
            }
            if (template.isVibrationIsolation()){
                isolationCost = isolationCost+ 12;
            }
            if (template.isWaterIsolation()){
                isolationCost = isolationCost+ 8;
            }
            cost= (fundamentCost+partitionCost+roofMaterialCost+subroofingMaterialCost+wallFacingMaterialCost+
                    wallMaterialCost+windowCost+isolationCost)*template.getSquare();
        }
        else{
            logger.error("template is null");
        }
    }
    public void calculateBuildingHours()
    {
        logger.info("Starting calculating hours");

        if(template!=null) {
            int fundamentHours = template.getFundamentMaterial().getBuildingHours();
            int partitionHours = template.getPartitionMaterial().getBuildingHours();
            int roofMaterialHours = template.getRoofMaterial().getBuildingHours();
            int subroofingMaterialHours = template.getSubroofingType().getBuildingHours();
            int wallFacingMaterialHours =template.getWallFacingMaterial().getBuildingHours();
            int wallMaterialHours =template.getWallMaterial().getBuildingHours();
            int windowHours=template.getWindow().getBuildingHours();
            int isolationHours=0;
            if (template.isNoiseIsolation()){
                isolationHours = isolationHours+ 1 ;
            }
            if (template.isVibrationIsolation()){
                isolationHours = isolationHours+ 1;
            }
            if (template.isWaterIsolation()){
                isolationHours = isolationHours+ 1;
            }
            buildingHours= (fundamentHours+partitionHours+roofMaterialHours+subroofingMaterialHours+wallFacingMaterialHours+
                    wallMaterialHours+windowHours+isolationHours)*template.getSquare();
        }
        else{
            logger.error("template is null");
        }
    }
}
