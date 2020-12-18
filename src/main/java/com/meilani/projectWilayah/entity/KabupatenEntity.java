package com.meilani.projectWilayah.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "kabupaten")
@NoArgsConstructor
@AllArgsConstructor
public class KabupatenEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "kode_kabupaten", unique = true, nullable = false)
	private String kodeKabupaten;
	
	@Column(name = "nama_kabupaten")
	private String namaKabupaten;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;
}
