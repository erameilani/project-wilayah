package com.meilani.projectWilayah.service;

import java.util.List;

import com.meilani.projectWilayah.dto.ProvinsiDto;
import com.meilani.projectWilayah.entity.ProvinsiEntity;

public interface ProvinsiService {
	List<ProvinsiEntity> getAllProvinsi();
	ProvinsiEntity insertProvinsi(ProvinsiDto dto);
	ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto dto);
	ProvinsiEntity deleteProvinsi(Integer id);
}
