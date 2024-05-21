package com.example.SpringRestMySQL.mapper;

import com.example.SpringRestMySQL.dto.NhanVienDTO;
import com.example.SpringRestMySQL.entity.ChucVu;
import com.example.SpringRestMySQL.entity.NhanVien;
import com.example.SpringRestMySQL.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;

public class NhanVienMapper {

    private ChucVuService chucVuService;

    @Autowired
    public NhanVienMapper(ChucVuService chucVuService) {
        this.chucVuService = chucVuService;
    }
    // CHuyển đổi DTO thành NV
    public static NhanVien mapToNhanVien(NhanVienDTO nhanVienDTO, ChucVuService chucVuService) {
        ChucVu chucVu = chucVuService.getOne(nhanVienDTO.getIdChucVu());
        NhanVien nhanVien = NhanVien.builder()
                .maNhanVien(nhanVienDTO.getMaNhanVien())
                .tenNhanVien(nhanVienDTO.getTenNhanVien())
                .tuoi(nhanVienDTO.getTuoi())
                .diaChi(nhanVienDTO.getDiaChi())
                .chucVu(chucVu)
                .build();
        return nhanVien;
    }
    // Chuyển đổi NV thành NhanVien DTO
    public static NhanVienDTO mapToNhanVienDTO(NhanVien nhanVien){
        NhanVienDTO nhanVienDTO=NhanVienDTO.builder().id(nhanVien.getId()).maNhanVien(nhanVien.getMaNhanVien())
                .tenNhanVien(nhanVien.getTenNhanVien()).tuoi(nhanVien.getTuoi()).diaChi(nhanVien.getDiaChi())
                .idChucVu(nhanVien.getChucVu().getId()).build();
        return nhanVienDTO;
    }



}
