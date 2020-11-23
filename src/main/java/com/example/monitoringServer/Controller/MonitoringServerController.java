package com.example.monitoringServer.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.monitoringServer.Model.CamundaObject;
import com.example.monitoringServer.Service.CamundaObjectService;
import org.thymeleaf.model.IModel;

import static com.example.monitoringServer.Model.CamundaObject.CamundaObjectBuilder.aCamundaObject;
import static java.util.Comparator.comparingLong;

@Controller
@RequestMapping("/camundaObject")
public class MonitoringServerController {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringServerController.class);

    @Autowired
    private CamundaObjectService camundaObjectService;

    // nichts senden
    @GetMapping("/")
    public String getCamundaObject(Model model) {

        List<CamundaObject> completeList = camundaObjectService.getCamundaObjectsList();
        model.addAttribute("tolle_liste", completeList);
        CamundaObject max = completeList.stream().max(comparingLong(CamundaObject::getDurchlaufzeit_nano)).orElse(aCamundaObject().build());
        model.addAttribute("maxObject", max.getDurchlaufzeit_sec());
        CamundaObject min = completeList.stream().min(comparingLong(CamundaObject::getDurchlaufzeit_nano)).orElse(aCamundaObject().build());
        model.addAttribute("minObject", min.getDurchlaufzeit_sec());
        model.addAttribute("averageObject_nano", completeList.stream().mapToLong(CamundaObject::getDurchlaufzeit_nano).average().orElse(0));
        model.addAttribute("averageObject_ms", completeList.stream().mapToLong(CamundaObject::getDurchlaufzeit_ms).average().orElse(0));
        model.addAttribute("averageObject_s", completeList.stream().mapToLong(CamundaObject::getDurchlaufzeit_sec).average().orElse(0));
        model.addAttribute("amountObjects", completeList.size());
        logger.info("gibt die Liste von CamundaObjects zurück");
        return "CamundaObjectList";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    //camunda object an den service übergeben , ziel: im server speichern, attribute müssen auch hier stehen, gateway einbauen,
    @PostMapping("/monitoring")
    @ResponseStatus(value = HttpStatus.OK)
    public void createCamundaObject(@RequestBody CamundaObject camundaObject) {
        logger.info(camundaObject.toString());
        camundaObjectService.saveCamundaObject(camundaObject);

    }
}

