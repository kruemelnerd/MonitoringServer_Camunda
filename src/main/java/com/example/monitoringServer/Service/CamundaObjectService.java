package com.example.monitoringServer.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.monitoringServer.Repository.CamundaObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.example.monitoringServer.Model.CamundaObject;

@Service
public class CamundaObjectService {

	@Autowired
	private CamundaObjectRepository camundaObjectRepository;

	private final Logger log = LoggerFactory.getLogger(CamundaObjectService.class);
	private final String url = "http://localhost:8085";
	RestTemplate restTemplate = new RestTemplate();
	private List<CamundaObject> camundaObjects = new ArrayList<>();

	//Liste von unten hier zurückgeben
	public List<CamundaObject> getCamundaObjectsList(){
		//return (List<CamundaObject>) camundaObjectRepository.findAll();
		return camundaObjects;
	}

	//eine zweite Funktion um ein CamundaObject in der Liste zu speichern
	public void saveCamundaObject(CamundaObject camundaObject){
		// camundaObjectRepository.save(camundaObject);
		camundaObjects.add(camundaObject);
	}
}
