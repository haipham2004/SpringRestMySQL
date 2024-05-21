package com.example.SpringRestMySQL.service;

import com.example.SpringRestMySQL.entity.ChucVu;

import java.util.List;

public interface ChucVuService {

    List<ChucVu> findAll();

    List<ChucVu> findAllLazy();

    public ChucVu getOne(int id);

    public ChucVu save(ChucVu chucVu);

    public ChucVu update(ChucVu chucVu);

    public void delete(int id);
}
