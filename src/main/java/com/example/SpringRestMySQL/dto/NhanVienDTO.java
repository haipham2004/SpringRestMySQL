package com.example.SpringRestMySQL.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class NhanVienDTO {

    private int id;
    @NotBlank(message = "Nhap maNhanVien NV di")
    private String maNhanVien;
    @NotBlank(message = "Nhap ten NV di")
    private String tenNhanVien;
     @NotNull(message = "Tuoi trong")
    private Integer tuoi;
    @NotBlank(message = "diaChi trong")
    private String diaChi;

    private int idChucVu;
}
