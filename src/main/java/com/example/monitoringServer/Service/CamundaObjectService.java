package com.example.monitoringServer.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.monitoringServer.Model.CamundaObject;

@Service
public class CamundaObjectService {

	private final Logger log = LoggerFactory.getLogger(CamundaObjectService.class);
	private final String url = "http://localhost:8085";
	RestTemplate restTemplate = new RestTemplate();

	//Liste von unten hier zurückgeben
	public List<CamundaObject> getCamundaObjectsFromExternalClient(){
		List<CamundaObject> camundaObjectList = new ArrayList<>();
		try {		
		CamundaObject camundaObject = restTemplate.getForObject(url, CamundaObject.class);
		camundaObjectList.add(camundaObject);
		log.info(camundaObject.toString());	
		log.info("Camundaobject von der Service Klasse" + camundaObject.toString());
		
		} catch (Exception e) {
			log.debug("Etwas ist schiefgelaufen: " + " " + e.getMessage());
		}
		return camundaObjectList;
	}
	//eine zweite Funktion um ein CamundaObject in der Liste zu speichern
}
