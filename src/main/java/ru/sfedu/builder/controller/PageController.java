package ru.sfedu.builder.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sfedu.builder.api.DataProvider;
import ru.sfedu.builder.model.*;

@Controller
@RequestMapping
public class PageController {
    public static final Logger logger = LogManager.getLogger(PageController.class);
    @Autowired
    DataProvider dataProvider;
    @GetMapping("/")
    public String main(Model model) {
        logger.info("index page");
        Fundament lineFundament = dataProvider.getById(Fundament.class,1L).get();
        Fundament monolithFundament = dataProvider.getById(Fundament.class,2L).get();
        Fundament svaiFundament = dataProvider.getById(Fundament.class,3L).get();


        // WallFasingMaterial wallBrick = new WallFasingMaterial(1,"Сайдинговый кирпич",150,4,40);
       // WallFasingMaterial wallSide =new WallFasingMaterial(2,"Пластиковый сайдинг",60,2,10);

        // dataProvider.insert(wallBrick);
        // dataProvider.insert(wallSide);


        model.addAttribute("lineFundament", lineFundament);
        model.addAttribute("monolithFundament", monolithFundament);
        model.addAttribute("svaiFundament", svaiFundament);

        return "index";
    }


    @GetMapping("/secondPage")
    public String secondPage(Model model){
        logger.info("second page");

        WallMaterial wallMaterialOne = dataProvider.getById(WallMaterial.class,1L).get();
        WallMaterial wallMaterialTwo = dataProvider.getById(WallMaterial.class,2L).get();
        WallMaterial wallMaterialThree = dataProvider.getById(WallMaterial.class,3L).get();

        model.addAttribute("kerm_b", wallMaterialOne);
        model.addAttribute("kermch_b", wallMaterialTwo);
        model.addAttribute("monolit", wallMaterialThree);

        return "page2";}
    @GetMapping("/thirdPage")
    public String thirdPage(Model model){
        logger.info("third page");

        SubroofingMaterial subroofingMaterialOne =  dataProvider.getById(SubroofingMaterial.class,1).get();
        SubroofingMaterial subroofingMaterialTwo = dataProvider.getById(SubroofingMaterial.class,2).get();

        model.addAttribute("monolit", subroofingMaterialOne);
        model.addAttribute("wood", subroofingMaterialTwo);

        return "page3";
    }
    @GetMapping("/forthPage")
    public String forthPage(Model model){
        logger.info("forth page");

        Partition partitionBrick = dataProvider.getById(Partition.class,1).get();
        Partition partitionGips = dataProvider.getById(Partition.class,2).get();
        Partition partitionPgp = dataProvider.getById(Partition.class,3).get();

        model.addAttribute("brick", partitionBrick);
        model.addAttribute("gips", partitionGips);
        model.addAttribute("pgp", partitionPgp);

        return "page4";
    }
    @GetMapping("/fifthPage")
    public String fifthPage(Model model){
        logger.info("fifth page");

        RoofMaterial roofMaterialGip = dataProvider.getById(RoofMaterial.class,1).get();
        RoofMaterial roofMaterialKomp = dataProvider.getById(RoofMaterial.class,2).get();
        RoofMaterial roofMaterialMetal = dataProvider.getById(RoofMaterial.class,3).get();

        model.addAttribute("gip_ch", roofMaterialGip);
        model.addAttribute("komp_ch", roofMaterialKomp);
        model.addAttribute("metal_ch", roofMaterialMetal);

        return "page5";
    }
    @GetMapping("/sixthPage")
    public String sixthPage(Model model){
        Window windowPlastic = dataProvider.getById(Window.class,1L).get();
        Window windowWood = dataProvider.getById(Window.class,2L).get();

        model.addAttribute("plastic", windowPlastic);
        model.addAttribute("wood", windowWood);
        return "page6";
    }
    @GetMapping("/seventhPage")
    public String seventhPage(){
        return "page7";
    }
    @GetMapping("/eighthPage")
    public String eighthPage(Model model){
        WallFasingMaterial wallBrick = dataProvider.getById(WallFasingMaterial.class,1).get();
        WallFasingMaterial wallSide = dataProvider.getById(WallFasingMaterial.class,2).get();

        model.addAttribute("brick", wallBrick);
        model.addAttribute("side", wallSide);
        return "page8";
    }
    @GetMapping("/ninthPage")
    public String ninthPage(){
        return "page9";
    }
    @GetMapping("/aboutPage")
    public String aboutPage(){
        return "about";
    }

}
