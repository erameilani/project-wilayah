package com.meilani.projectWilayah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meilani.projectWilayah.dto.KecamatanDto;
import com.meilani.projectWilayah.dto.StatusMessageDto;
import com.meilani.projectWilayah.entity.KecamatanEntity;
import com.meilani.projectWilayah.service.KecamatanServiceImp;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	@Autowired
	private KecamatanServiceImp kecamatanService;
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getAll() {
		return ResponseEntity.ok(kecamatanService.getAllKecamatan());
	}
	
	@GetMapping("/get-by-id/{id}")
	private ResponseEntity<?> getById(Integer id) {
		return ResponseEntity.ok(kecamatanService.getById(id));
	}
	
	@PostMapping("/post")
	private ResponseEntity<?> insert(@RequestBody KecamatanDto dto) {
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKecamatan().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(kecamatanService.insertKecamatan(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KecamatanDto dto) {
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKecamatan().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Diperbarui!");
			result.setData(kecamatanService.updateKecamatan(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Dihapus!");
		result.setData(kecamatanService.deleteKecamatan(id));
		return ResponseEntity.ok(result);
	}
}
