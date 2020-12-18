package com.meilani.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meilani.projectWilayah.dto.DesaDto;
import com.meilani.projectWilayah.entity.DesaEntity;
import com.meilani.projectWilayah.entity.KabupatenEntity;
import com.meilani.projectWilayah.entity.KecamatanEntity;
import com.meilani.projectWilayah.entity.ProvinsiEntity;
import com.meilani.projectWilayah.repository.DesaRepository;
import com.meilani.projectWilayah.repository.KabupatenRepository;
import com.meilani.projectWilayah.repository.KecamatanRepository;
import com.meilani.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImp implements DesaService {
	@Autowired
	private DesaRepository desaRepository;
	
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;

	@Override
	public List<DesaEntity> getAllDesa() {
		return desaRepository.findActiveId();
	}
	
	public List<DesaEntity> getById(Integer id) {
		return desaRepository.findAllById(id);
	}

	@Override
	public DesaEntity insertDesa(DesaDto dto) {
		DesaEntity desaEntity = convertToDesa(dto);
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
		
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity updateDesa(Integer id, DesaDto dto) {
		DesaEntity desaEntity = desaRepository.findById(id).get();
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
				
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity deleteDesa(Integer id) {
		DesaEntity desaEntity = desaRepository.findById(id).get();
		desaEntity.setStatus(0);
		return desaEntity;
	}
	
	public DesaEntity convertToDesa(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setStatus(1);
		return desaEntity;
	}

}
