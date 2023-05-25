package com.ftn.sbnz.service.service;

import java.util.stream.Stream;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.ftn.sbnz.model.PhotoConfiguration;
import com.ftn.sbnz.model.PhotographyData;

@org.springframework.stereotype.Service
public class Service {
    
    public PhotoConfiguration configure(PhotographyData photographyData) {
        // Load the Drools rule engine
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        
        // Create a new KieSession
        KieSession kieSession = kieContainer.newKieSession("photograpgysession");

        // Insert the PhotographyData into the KieSession
        kieSession.insert(photographyData);

        // Fire all the rules in the KieSession
        kieSession.fireAllRules();

        // Retrieve the PhotoConfiguration from the inserted facts in the KieSession
        Stream<?> photoConfigurationStream = kieSession.getObjects()
                .stream()
                .filter(obj -> obj instanceof PhotoConfiguration);

        // Retrieve the first PhotoConfiguration object found
        PhotoConfiguration photoConfiguration = photoConfigurationStream
                .map(obj -> (PhotoConfiguration) obj)
                .findFirst()
                .orElse(null);

        // Print the retrieved PhotoConfiguration values
        if (photoConfiguration != null) {
            System.out.println("ISO: " + photoConfiguration.getISO());
            System.out.println("Aperture: " + photoConfiguration.getAperture());
            System.out.println("Shutter Speed: " + photoConfiguration.getShutterSpeed());
        }

        // Dispose the KieSession
        kieSession.dispose();

        return photoConfiguration;
    }

}
