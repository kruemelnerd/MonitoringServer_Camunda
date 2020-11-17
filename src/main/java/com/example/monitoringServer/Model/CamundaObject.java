package com.example.monitoringServer.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class CamundaObject implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long camundaObject_id;
	private long startzeit;
	private long endzeit;
	private long durchlaufzeit;
	
	public CamundaObject() {
		
	}
	
	public CamundaObject(long startzeit, long endzeit, long durchlaufzeit) {
		this.durchlaufzeit = durchlaufzeit;
		this.endzeit = endzeit;
		this.endzeit = startzeit;
	}

	public long getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(long startzeit) { this.startzeit = startzeit; }

	public long getEndzeit() {
		return endzeit;
	}

	public void setEndzeit(long endzeit) {
		this.endzeit = endzeit;
	}

	public long getDurchlaufzeit() {
		return durchlaufzeit;
	}

	public void setDurchlaufzeit(long durchlaufzeit) {
		this.durchlaufzeit = durchlaufzeit;
	}

	@Override
	public String toString() {
		return "CamundaObject{" +
				"startzeit=" + startzeit +
				", endzeit=" + endzeit +
				", durchlaufzeit=" + durchlaufzeit +
				'}';
	}
}
