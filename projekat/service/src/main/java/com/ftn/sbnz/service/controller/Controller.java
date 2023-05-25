package com.ftn.sbnz.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

// import java.util.stream.Stream;
import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.service.Service;


@RestController
@RequestMapping(value = "/photography")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping(value="/configure", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoConfiguration> configure(@RequestBody PhotographyData photographyData) {
        PhotoConfiguration configuration = this.service.configure(photographyData);
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    }

    // public static void main(String[] args) {
    //     // Load the Drools rule engine
    //     KieServices kieServices = KieServices.Factory.get();
    //     KieContainer kieContainer = kieServices.getKieClasspathContainer();
        
    //     // Create a new KieSession
    //     KieSession kieSession = kieContainer.newKieSession("photograpgysession");

    //     // Create an instance of PhotographyData that matches the rule conditions
    //     PhotographyData photographyData = new PhotographyData("nightfall", "macro", "rapidMovement");

    //     // Insert the PhotographyData into the KieSession
    //     kieSession.insert(photographyData);

    //     // Fire all the rules in the KieSession
    //     kieSession.fireAllRules();

    //     // Retrieve the PhotoConfiguration from the inserted facts in the KieSession
    //     Stream<?> photoConfigurationStream = kieSession.getObjects()
    //             .stream()
    //             .filter(obj -> obj instanceof PhotoConfiguration);

    //     // Retrieve the first PhotoConfiguration object found
    //     PhotoConfiguration photoConfiguration = photoConfigurationStream
    //             .map(obj -> (PhotoConfiguration) obj)
    //             .findFirst()
    //             .orElse(null);

    //     // Print the retrieved PhotoConfiguration values
    //     if (photoConfiguration != null) {
    //         System.out.println("ISO: " + photoConfiguration.getISO());
    //         System.out.println("Aperture: " + photoConfiguration.getAperture());
    //         System.out.println("Shutter Speed: " + photoConfiguration.getShutterSpeed());
    //     }

    //     // Dispose the KieSession
    //     kieSession.dispose();
    // }
}
