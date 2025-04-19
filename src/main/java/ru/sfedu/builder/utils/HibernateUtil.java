package ru.sfedu.builder.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import ru.sfedu.builder.Constants;
import ru.sfedu.builder.model.*;


import java.io.File;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
    @Bean
    public static SessionFactory getSessionFactory(String configFile) {
        logger.info("start getSessionFactory()");
        File file = new File(configFile);
        String consoleConfig = null;
        try {
            consoleConfig = ConfigurationUtil.getConfigurationEntry(Constants.DEFAULT_HBN_CFG);
        } catch (IOException e) {
            logger.error(e);
        }
        if (consoleConfig != null) {
            file = new File(consoleConfig);
        }
        if (!file.exists()) {
            file = new File(Constants.DEFAULT_HBN_CONFIG_PATH);
        }
        logger.debug("file name: " + file.getName());
        Configuration configuration = new Configuration().configure(file);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Fundament.class);
        metadataSources.addAnnotatedClass(WallMaterial.class);
        metadataSources.addAnnotatedClass(WallFasingMaterial.class);
        metadataSources.addAnnotatedClass(Partition.class);
        metadataSources.addAnnotatedClass(Window.class);
        metadataSources.addAnnotatedClass(SubroofingMaterial.class);
        metadataSources.addAnnotatedClass(Template.class);
        metadataSources.addAnnotatedClass(RoofMaterial.class);

        sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        logger.info("end getSessionFactory()");
        return sessionFactory;
    }
}
