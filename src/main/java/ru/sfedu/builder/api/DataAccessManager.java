package ru.sfedu.builder.api;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sfedu.builder.model.Template;

import java.io.Serializable;

@Setter
@Getter
@Component
public class DataAccessManager implements  Serializable{
    @Autowired
    public static final Logger logger = LogManager.getLogger(DataAccessManager.class);
    @Autowired
    public Template template;

    public DataAccessManager() {
        logger.info("DataAccessModule init");
    }


    /* public void setFundamentType(int idFundament){
       if(dataProvider.getById(Fundament.class,idFundament).isPresent()) {
          template.setFundamentType(dataProvider.getById(Fundament.class,idFundament).get());
           logger.info("Fundament successfully found");
       }
       else{
           logger.error("Fundament not found");
       }
    }

    public void setWallMaterialType(long idWallMaterial){

        if(dataProvider.getById(WallMaterial.class,idWallMaterial).isPresent()) {
            template.setWallMaterialType(dataProvider.getById(WallMaterial.class, idWallMaterial).get());
            logger.info("Wall material successfully found");
        }
        else{
            logger.error("Wall material not found");
        }
    }

    public void setPartitionMaterial(long idPartitionType){

        if(dataProvider.getById(Partition.class,idPartitionType).isPresent()) {
            template.setPartitionMaterial(dataProvider.getById(Partition.class, idPartitionType).get());
            logger.info("Partition material successfully found");
        }
        else{
            logger.error("Partition material not found");
        }
    }*/


}
