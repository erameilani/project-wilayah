package com.meilani.projectWilayah.service;

import java.util.List;

import com.meilani.projectWilayah.dto.KecamatanDto;
import com.meilani.projectWilayah.entity.KecamatanEntity;

public interface KecamatanService {
	List<KecamatanEntity> getAllKecamatan();
	KecamatanEntity insertKecamatan(KecamatanDto dto);
	KecamatanEntity updateKecamatan(Integer id, KecamatanDto dto);
	KecamatanEntity deleteKecamatan(Integer id);
}
