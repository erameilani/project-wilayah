package com.meilani.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meilani.projectWilayah.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {
	@Query(value = "select * from provinsi where status = 1", nativeQuery = true)
	List<ProvinsiEntity> findActiveId();
	
	@Query(value = "select * from provinsi where id = ?", nativeQuery = true)
	List<ProvinsiEntity> findAllById(Integer id);
	
	@Query(value = "select * from provinsi where kode_provinsi = ?", nativeQuery = true)
	List<ProvinsiEntity> findAllByKodeProvinsi(String kodeProv);
	
	ProvinsiEntity findByKodeProvinsi(String kodeProv);
}
