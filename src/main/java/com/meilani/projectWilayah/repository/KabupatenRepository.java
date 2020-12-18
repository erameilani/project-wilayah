package com.meilani.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meilani.projectWilayah.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	@Query(value = "select * from kabupaten where status = 1", nativeQuery = true)
	List<KabupatenEntity> findActiveId();

	@Query(value = "select * from kabupaten where id = ?", nativeQuery = true)
	List<KabupatenEntity> findAllById(Integer id);

	@Query(value = "select * from kabupaten where kode_provinsi = ?", nativeQuery = true)
	List<KabupatenEntity> findAllByKodeProvinsi(String kodeProv);
	
	KabupatenEntity findByKodeKabupaten(String kodeKab);
}
