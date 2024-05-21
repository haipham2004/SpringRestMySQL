package com.example.SpringRestMySQL.service;

import com.example.SpringRestMySQL.dto.NhanVienDTO;
import com.example.SpringRestMySQL.dto.NhanVienResponse;
import com.example.SpringRestMySQL.entity.NhanVien;

import java.util.List;

public interface NhanVienService {

    List<NhanVienResponse> findAll();


    public NhanVienResponse getOne(int id);

    public NhanVienDTO save(NhanVienDTO nhanVienDTO);

    public NhanVienDTO update(NhanVienDTO nhanVienDTO);

    public void delete(int id);

    List<NhanVienResponse> searchNhanVien(String query);

    List<NhanVienResponse> searchNhanVienSQL(String query);
}
