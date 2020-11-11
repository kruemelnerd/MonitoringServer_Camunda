package com.example.monitoringServer.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class CamundaObject implements Serializable{
	
	private long durchlaufzeit;
	private long finaleBearbeitungszeit;
	private long endeBearbeitungszeit;
	
	public CamundaObject() {
		
	}
	
	public CamundaObject(long endeBearbeitungszeit, long finaleBearbeitungszeit, long durchlaufzeit) {
		this.durchlaufzeit = durchlaufzeit;
		this.finaleBearbeitungszeit = finaleBearbeitungszeit;
		this.endeBearbeitungszeit = endeBearbeitungszeit;
	}

	public long getDurchlaufzeit() {
		return durchlaufzeit;
	}

	public void setDurchlaufzeit(long durchlaufzeit) {
		this.durchlaufzeit = durchlaufzeit;
	}

	public long getFinaleBearbeitungszeit() {
		return finaleBearbeitungszeit;
	}

	public void setFinaleBearbeitungszeit(long finaleBearbeitungszeit) {
		this.finaleBearbeitungszeit = finaleBearbeitungszeit;
	}

	public long getEndeBearbeitungszeit() {
		return endeBearbeitungszeit;
	}

	public void setEndeBearbeitungszeit(long endeBearbeitungszeit) {
		this.endeBearbeitungszeit = endeBearbeitungszeit;
	}

	@Override
	public String toString() {
		return "CamundaObject [durchlaufzeit=" + durchlaufzeit + ", finaleBearbeitungszeit=" + finaleBearbeitungszeit
				+ ", endeBearbeitungszeit=" + endeBearbeitungszeit + "]";
	}

	
	
	
}
