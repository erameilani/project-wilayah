package com.meilani.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meilani.projectWilayah.entity.KecamatanEntity;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer> {
	@Query(value = "select * from kecamatan where status = 1", nativeQuery = true)
	List<KecamatanEntity> findActiveId();
	
	@Query(value = "select * from kecamatan where id = ?", nativeQuery = true)
	List<KecamatanEntity> findAllById(Integer id);
	
	KecamatanEntity findByKodeKecamatan(String kodeKec);
}
