package ru.sfedu.builder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Constants")
@SessionScoped
public class Constants {
    public static final String PROPERTIES_PATH = "properties";
    public static final String DEFAULT_CONFIG_PATH ="./src/main/resources/environment.properties";

    //-----------------Hibernate Util-----------------

    public static String LAB3_HBN_CFG = "src/main/resources/hibernate.cfg.xml";

    public static final String DEFAULT_HBN_CFG = "src/main/resources/hibernate.cfg.xml";
    public static final String DEFAULT_HBN_CONFIG_PATH = "src/main/resources/hibernate.cfg.xml";
    //-----------------Data source-----------------


    public static final String ACTOR = "System";
    public static final String DATABASE_NAME = "test";
    public static final String COLLECTION_NAME = "historyContent";
    public static final String MONGO_CLIENT = "mongodb://localhost:27017";
    public static final String MONGO_DATE_PATTERN = "yyyy.MM.dd HH:mm:ss";
    //-----------------Views constant--------------
    public static final long FUNDAMENT_TYPE_STRIP= 1L;
    public static final long FUNDAMENT_TYPE_MONOLITHIC= 2L;
    public static final long FUNDAMENT_TYPE_PILE= 3L;


}
