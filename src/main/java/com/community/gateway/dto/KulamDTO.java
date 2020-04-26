package com.community.gateway.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class KulamDTO {
	private long id;
	private String kulamName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKulamName() {
		return kulamName;
	}
	public void setKulamName(String kulamName) {
		this.kulamName = kulamName;
	}
}