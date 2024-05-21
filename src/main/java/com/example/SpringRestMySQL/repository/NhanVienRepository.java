package com.example.SpringRestMySQL.repository;

import com.example.SpringRestMySQL.dto.NhanVienResponse;
import com.example.SpringRestMySQL.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("SELECT NV FROM NhanVien NV WHERE NV.tenNhanVien LIKE %:query%")
    List<NhanVienResponse> searchNhanVien(String query);

    @Query(value = "SELECT NV FROM NhanVien NV WHERE NV.tenNhanVien LIKE %:query%",nativeQuery = true)
    List<NhanVienResponse> searchNhanVienSQL(String query);
}

