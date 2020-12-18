package com.meilani.projectWilayah.service;

import java.util.List;

import com.meilani.projectWilayah.dto.DesaDto;
import com.meilani.projectWilayah.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getAllDesa();
	DesaEntity insertDesa(DesaDto dto);
	DesaEntity updateDesa(Integer id, DesaDto dto);
	DesaEntity deleteDesa(Integer id);
}
