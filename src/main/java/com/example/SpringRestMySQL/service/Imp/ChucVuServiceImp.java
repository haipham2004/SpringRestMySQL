package com.example.SpringRestMySQL.service.Imp;

import com.example.SpringRestMySQL.entity.ChucVu;
import com.example.SpringRestMySQL.repository.ChucVuRepository;
import com.example.SpringRestMySQL.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuServiceImp implements ChucVuService {

    private ChucVuRepository chucVuRepository;

    @Autowired
    public ChucVuServiceImp(ChucVuRepository chucVuRepository) {
        this.chucVuRepository = chucVuRepository;
    }

    @Override
    public List<ChucVu> findAll() {
        return null;
    }

    @Override
    public List<ChucVu> findAllLazy() {
        return null;
    }

    @Override
    public ChucVu getOne(int id) {

        Optional<ChucVu> result=chucVuRepository.findById(id);
        ChucVu chucVu=null;
        if(result.isPresent()){
            chucVu=result.get();
        }else{
            return null;
        }
       return chucVu;

    }

    @Override
    public ChucVu save(ChucVu chucVu) {
        return null;
    }

    @Override
    public ChucVu update(ChucVu chucVu) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
