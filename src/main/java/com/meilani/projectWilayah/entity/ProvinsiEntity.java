package com.meilani.projectWilayah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "provinsi")
@NoArgsConstructor
@AllArgsConstructor
public class ProvinsiEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "kode_provinsi", unique = true, nullable = false)
	private String kodeProvinsi;
	
	@Column(name = "nama_provinsi")
	private String namaProvinsi;
	
	@Column(name = "status")
	private Integer status;
}
