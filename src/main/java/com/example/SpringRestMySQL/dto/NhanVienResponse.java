package com.example.SpringRestMySQL.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NhanVienResponse {

    private int id;

    private String maNhanVien;

    private String tenNhanVien;

    private int tuoi;

    private String diaChi;

    private int idChucVu;

}
