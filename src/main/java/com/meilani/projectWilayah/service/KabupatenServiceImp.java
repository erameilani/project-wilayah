package com.meilani.projectWilayah.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meilani.projectWilayah.dto.KabupatenDto;
import com.meilani.projectWilayah.entity.KabupatenEntity;
import com.meilani.projectWilayah.entity.ProvinsiEntity;
import com.meilani.projectWilayah.repository.KabupatenRepository;
import com.meilani.projectWilayah.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImp implements KabupatenService {
	@Autowired
	private KabupatenRepository kabupatenRepository;
	
	@Autowired
	private ProvinsiRepository provinsiRepository;

	@Override
	public List<KabupatenEntity> getAllKabupaten() {
		return kabupatenRepository.findActiveId();
	}

	public List<KabupatenEntity> getById(Integer id) {
		return kabupatenRepository.findAllById(id);
	}

	public List<KabupatenEntity> getByKodeProvinsi(String kodeProv) {
		return kabupatenRepository.findAllByKodeProvinsi(kodeProv);
	}

	@Override
	public KabupatenEntity insertKabupaten(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = convertToKabupaten(dto);
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity updateKabupaten(Integer id, KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity deleteKabupaten(Integer id) {
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		kabupatenEntity.setStatus(0);
		return kabupatenEntity;
	}
	
	public KabupatenEntity convertToKabupaten(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setStatus(1);
		return kabupatenEntity;
	}

}
