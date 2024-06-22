package com.example.SpringRestMySQL.repository;

import com.example.SpringRestMySQL.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("SELECT NV FROM NhanVien NV WHERE NV.tenNhanVien LIKE %:query%")
    List<NhanVien> searchNhanVien(String query);

    @Query(value = "SELECT NV FROM NhanVien NV WHERE NV.tenNhanVien LIKE %:query%",nativeQuery = true)
    List<NhanVien> searchNhanVienSQL(String query);

    List<NhanVien> findByTenNhanVienAndTuoi(String ten,int tuoi);

    List<NhanVien> findByTuoiGreaterThan(int tuoi);

    List<NhanVien> findByTuoiLessThan(int tuoi);

    List<NhanVien> findByTenNhanVienContaining(String ten);

    List<NhanVien> findByTenNhanVienLike(String ten);

    List<NhanVien> findByTuoiBetween(int tuoiMin, int tuoiMax);

//    List<NhanVien> findFirst5ByOrderBytOrderByTenNhanVienAsc(String ten);
}

