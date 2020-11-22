package com.example.monitoringServer.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.monitoringServer.Model.CamundaObject;
import com.example.monitoringServer.Service.CamundaObjectService;
import org.thymeleaf.model.IModel;

@Controller
@RequestMapping("/camundaObject")
public class MonitoringServerController {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringServerController.class);

    @Autowired
    private CamundaObjectService camundaObjectService;

    // nichts senden
    @GetMapping("/")
    public String getCamundaObject(Model model) {
        try {
            List<CamundaObject> allcamundaObjects = new ArrayList();
            allcamundaObjects = camundaObjectService.getCamundaObjectsList();
            model.addAttribute("camundaObjectsList", allcamundaObjects);
            logger.info("gibt die Liste von CamundaObjects zurück");
            return "CamundaObjectList";
        }catch (Exception e){
            logger.info(e.getMessage());
            return "error";
        }
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    //camunda object an den service übergeben , ziel: im server speichern, attribute müssen auch hier stehen, gateway einbauen,
    @PostMapping("/")
    public void createCamundaObject( @RequestBody CamundaObject camundaObject ) {
        logger.info(camundaObject.toString());

        CamundaObject camundaObject1 = new CamundaObject();
        camundaObject1.setStartzeit(camundaObject.getStartzeit());
        camundaObject1.setEndzeit(camundaObject.getEndzeit());
        camundaObject1.setDurchlaufzeit(camundaObject.getDurchlaufzeit());

        camundaObjectService.saveCamundaObject(camundaObject1);
    }
}

