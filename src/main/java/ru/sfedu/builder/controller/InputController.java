package ru.sfedu.builder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sfedu.builder.api.Calculator;
import ru.sfedu.builder.api.DataAccessManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.sfedu.builder.api.DataProvider;

@Controller
@RequestMapping
public class InputController {
    public static final Logger logger = LogManager.getLogger(InputController.class);
    @Autowired
    DataAccessManager dataAccessManager;


    @GetMapping  ("/inputFundament")
    public ResponseEntity<?> inputFundament(@RequestParam("id") int id, @RequestParam("square") int square) {
        logger.info("inputFundament");

        dataAccessManager.getTemplate().getFundamentMaterial().setId(id);
        dataAccessManager.getTemplate().setSquare(square);

        logger.info(dataAccessManager.getTemplate().getFundamentMaterial().getId()+" "+ dataAccessManager.getTemplate().getSquare());
       return new ResponseEntity<>("Fundament successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputWallMaterial")
    public ResponseEntity<?> inputWallMaterial(@RequestParam("id") int id) {
        logger.info("inputWallMaterial");

        dataAccessManager.getTemplate().getWallMaterial().setId(id);

        logger.info(dataAccessManager.getTemplate().getWallMaterial().getId());
        return new ResponseEntity<>("WallMaterial successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputSubroofingMaterial")
    public ResponseEntity<?> inputSubroofingMaterial(@RequestParam("id") int id) {
        logger.info("inputSubroofingMaterial");

        dataAccessManager.getTemplate().getSubroofingType().setId(id);

        logger.info(dataAccessManager.getTemplate().getSubroofingType().getId());
        return new ResponseEntity<>("SubroofingMaterial successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputPartition")
    public ResponseEntity<?> inputPartition(@RequestParam("id") int id) {
        logger.info("inputPartition");

        dataAccessManager.getTemplate().getPartitionMaterial().setId(id);

        logger.info(dataAccessManager.getTemplate().getPartitionMaterial().getId());
        return new ResponseEntity<>("Partition successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputRoofMaterial")
    public ResponseEntity<?> inputRoofMaterial(@RequestParam("id") int id) {
        logger.info("inputRoofMaterial");

        dataAccessManager.getTemplate().getRoofMaterial().setId(id);

        logger.info(dataAccessManager.getTemplate().getRoofMaterial().getId());
        return new ResponseEntity<>("RoofMaterial successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputWindow")
    public ResponseEntity<?> inputWindow(@RequestParam("id") int id,@RequestParam("quantity") int quantity) {
        logger.info("inputWindow");

        dataAccessManager.getTemplate().getWindow().setId(id);
        dataAccessManager.getTemplate().setWindowQuantity(quantity);

        logger.info(dataAccessManager.getTemplate().getWindow().getId()+" "+ dataAccessManager.getTemplate().getWindowQuantity());
        return new ResponseEntity<>("Window successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputIsolation")
    public ResponseEntity<?> inputIsolation(@RequestParam("noise") String noise,@RequestParam("vibration") String vibration,@RequestParam("water") String water) {
        logger.info("inputIsolation");

        dataAccessManager.getTemplate().setVibrationIsolation(vibration.equals("true"));
        dataAccessManager.getTemplate().setWaterIsolation(water.equals("true"));
        dataAccessManager.getTemplate().setNoiseIsolation(noise.equals("true"));

        logger.info(dataAccessManager.getTemplate().isVibrationIsolation()+" " +
        dataAccessManager.getTemplate().isWaterIsolation()+" "+
        dataAccessManager.getTemplate().isNoiseIsolation());
        return new ResponseEntity<>("Isolation successfully was chosen", HttpStatus.OK);
    }

    @GetMapping("/inputWallFacingMaterial")
    public ResponseEntity<?> inputWallFacingMaterial(@RequestParam("id") int id) {
        logger.info("inputWallMaterialFacing");

        dataAccessManager.getTemplate().getWallFacingMaterial().setId(id);


        logger.info(dataAccessManager.getTemplate().getWallFacingMaterial().getId());
        return new ResponseEntity<>("WallMaterialFacing successfully was chosen", HttpStatus.OK);
    }

}