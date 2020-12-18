package com.meilani.projectWilayah.controller;

import java.util.List;

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

import com.meilani.projectWilayah.dto.KabupatenDto;
import com.meilani.projectWilayah.dto.StatusMessageDto;
import com.meilani.projectWilayah.entity.KabupatenEntity;
import com.meilani.projectWilayah.service.KabupatenServiceImp;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	@Autowired
	private KabupatenServiceImp kabupatenService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(kabupatenService.getAllKabupaten());
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(kabupatenService.getById(id));
	}
	
	@GetMapping("/get-by-provcode/{kodeProvinsi}")
	public ResponseEntity<?> getByKodeProvinsi(@PathVariable String kodeProvinsi) {
		return ResponseEntity.ok(kabupatenService.getByKodeProvinsi(kodeProvinsi));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> insert(@RequestBody KabupatenDto dto) {
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Ditambah!");
			result.setData(kabupatenService.insertKabupaten(dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@PostMapping("/post-list")
	public ResponseEntity<?> insertList(@RequestBody List<KabupatenDto> dto) {
		for (KabupatenDto kabupaten : dto) {
			kabupatenService.insertKabupaten(kabupaten);
		}
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KabupatenDto dto) {
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		
		if(dto.getNamaKabupaten().equals("")) {
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Nama Harus Diisi!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Diperbarui!");
			result.setData(kabupatenService.updateKabupaten(id, dto));
			return ResponseEntity.ok(result);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Dihapus!");
		result.setData(kabupatenService.deleteKabupaten(id));
		return ResponseEntity.ok(result);
	}

}
