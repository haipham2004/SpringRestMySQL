package com.example.SpringRestMySQL.service;

import com.example.SpringRestMySQL.dto.NhanVienDTO;
import com.example.SpringRestMySQL.dto.NhanVienResponse;
import com.example.SpringRestMySQL.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NhanVienService {

    List<NhanVienResponse> findAll();


    public NhanVienResponse getOne(int id);

    public NhanVienDTO save(NhanVienDTO nhanVienDTO);

    public NhanVienDTO update(NhanVienDTO nhanVienDTO);

    public void delete(int id);

    Page<NhanVienResponse> getAllPage(Pageable pageable);

    List<NhanVienResponse> searchNhanVien(String query);

    List<NhanVienResponse> searchNhanVienSQL(String query);

    List<NhanVienResponse> findByTenNhanVienAndTuoi(String ten,int tuoi);

    List<NhanVienResponse> findByTuoiGreaterThan(int tuoi);

    List<NhanVienResponse> findByTuoiLessThan(int tuoi);
}
