package com.example.monitoringServer.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.monitoringServer.Model.CamundaObject;
import com.example.monitoringServer.Service.CamundaObjectService;

@RestController
@RequestMapping("/camundaObject")
public class MonitoringServerController {

	private static final Logger logger = LoggerFactory.getLogger(MonitoringServerController.class);

	@Autowired
	private CamundaObjectService camundaObjectService;

	// nichts senden
	@GetMapping("/")
	public List<CamundaObject> getCamundaObject() {
		logger.info("gibt die Liste von CamundaObjects zurück");
		return camundaObjectService.getCamundaObjectsFromExternalClient();
	}
	
	//camunda object an den service übergeben , ziel: im server speichern, attribute müssen auch hier stehen, gateway einbauen,
	@PostMapping("/")
	public void createCamundaObject(@RequestBody CamundaObject camundaObject ) {
		 logger.info(camundaObject.toString());
	}
}
