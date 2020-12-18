package com.meilani.projectWilayah.entity;

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

@Data
@Entity
@Table(name = "desa")
@NoArgsConstructor
@AllArgsConstructor
public class DesaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "kode_desa", unique = true, nullable = false)
	private String kodeDesa;
	
	@Column(name = "nama_desa")
	private String namaDesa;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "kode_kecamatan", referencedColumnName = "kode_kecamatan")
	private KecamatanEntity kecamatanEntity;
	
	@ManyToOne
	@JoinColumn(name = "kode_kabupaten", referencedColumnName = "kode_kabupaten")
	private KabupatenEntity kabupatenEntity;
	
	@ManyToOne
	@JoinColumn(name = "kode_provinsi", referencedColumnName = "kode_provinsi")
	private ProvinsiEntity provinsiEntity;

}
