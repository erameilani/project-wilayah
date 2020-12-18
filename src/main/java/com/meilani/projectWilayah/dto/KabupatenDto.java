package com.meilani.projectWilayah.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KabupatenDto {
	private String kodeKabupaten;
	private String namaKabupaten;
	private String kodeProvinsi;
}
