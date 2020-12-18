package com.meilani.projectWilayah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meilani.projectWilayah.entity.DesaEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
	@Query(value = "select * from desa where status = 1", nativeQuery = true)
	List<DesaEntity> findActiveId();
	
	@Query(value = "select * from desa where id = ?", nativeQuery = true)
	List<DesaEntity> findAllById(Integer id);
}
