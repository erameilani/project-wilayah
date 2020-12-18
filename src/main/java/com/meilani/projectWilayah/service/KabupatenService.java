package com.meilani.projectWilayah.service;

import java.util.List;

import com.meilani.projectWilayah.dto.KabupatenDto;
import com.meilani.projectWilayah.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getAllKabupaten();
	KabupatenEntity insertKabupaten(KabupatenDto dto);
	KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto);
	KabupatenEntity deleteKabupaten(Integer id);
}
