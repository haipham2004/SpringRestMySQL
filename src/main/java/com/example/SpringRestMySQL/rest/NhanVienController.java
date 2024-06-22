package com.example.SpringRestMySQL.rest;

import com.example.SpringRestMySQL.dto.NhanVienDTO;
import com.example.SpringRestMySQL.dto.NhanVienResponse;
import com.example.SpringRestMySQL.service.NhanVienService;
import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/NhanVien")
public class NhanVienController {

    private NhanVienService nhanVienService;

    @Autowired
    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("HienThi")
    public List<NhanVienResponse> findAll() {
        return nhanVienService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienResponse> getOne(@PathVariable("id") int id) {
        NhanVienResponse nhanVien = nhanVienService.getOne(id);
        return ResponseEntity.ok(nhanVien);
    }

    @PostMapping("")
    public ResponseEntity<NhanVienDTO> save(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        NhanVienDTO nhanVienDTOSave = nhanVienService.save(nhanVienDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nhanVienDTOSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienDTO> update(@RequestBody NhanVienDTO nhanVienDTO, @PathVariable("id") int id) {
        nhanVienDTO.setId(id);
        NhanVienDTO nhanVienDTOUpdate = nhanVienService.update(nhanVienDTO);
        return ResponseEntity.ok(nhanVienDTOUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        nhanVienService.delete(id);
        return ResponseEntity.ok("Delete success: " + id);
    }

    @GetMapping("searchNhanVien")
    public ResponseEntity<List<NhanVienResponse>> searchNhanVien(@RequestParam("query") String query){
        return ResponseEntity.ok(nhanVienService.searchNhanVien(query));
    }

    @GetMapping("searchNhanVienSQL")
    public ResponseEntity<List<NhanVienResponse>> searchNhanVienSQL(@RequestParam("query") String query){
        return ResponseEntity.ok(nhanVienService.searchNhanVienSQL(query));
    }

    @GetMapping("findByTenNhanVienAndTuoi")
    public ResponseEntity<List<NhanVienResponse>> findByTenNhanVienAndTuoi(@RequestParam("ten") String ten,
                                                                           @RequestParam("tuoi") int tuoi){
        return ResponseEntity.ok(nhanVienService.findByTenNhanVienAndTuoi(ten,tuoi));
    }

    @GetMapping("findByTuoiGreaterThan")
    public ResponseEntity<List<NhanVienResponse>> findByTuoiGreaterThan(@RequestParam("tuoi") int tuoi){
        return ResponseEntity.ok(nhanVienService.findByTuoiGreaterThan(tuoi));
    }

    @GetMapping("findByTuoiLessThan")
    public ResponseEntity<List<NhanVienResponse>> findByTuoiLessThan(@RequestParam("tuoi") int tuoi){
        return ResponseEntity.ok(nhanVienService.findByTuoiLessThan(tuoi));
    }


}
