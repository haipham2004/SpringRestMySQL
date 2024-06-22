package com.example.SpringRestMySQL.service.Imp;

import com.example.SpringRestMySQL.dto.NhanVienDTO;
import com.example.SpringRestMySQL.dto.NhanVienResponse;
import com.example.SpringRestMySQL.entity.ChucVu;
import com.example.SpringRestMySQL.entity.NhanVien;
import com.example.SpringRestMySQL.exception.ResourceNotFoundException;
import com.example.SpringRestMySQL.mapper.NhanVienMapper;
import com.example.SpringRestMySQL.repository.ChucVuRepository;
import com.example.SpringRestMySQL.repository.NhanVienRepository;
import com.example.SpringRestMySQL.service.NhanVienService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanVienServiceImp implements NhanVienService {

    private NhanVienRepository nhanVienRepository;

    private ChucVuRepository chucVuRepository;

    private ModelMapper modelMapper;


    @Autowired
    public NhanVienServiceImp(NhanVienRepository nhanVienRepository, ChucVuRepository chucVuRepository,
                              ModelMapper modelMapper) {
        this.nhanVienRepository = nhanVienRepository;
        this.modelMapper = modelMapper;
        this.chucVuRepository = chucVuRepository;
    }


    @Override
    public List<NhanVienResponse> findAll() {
        List<NhanVien> listNhanVien = nhanVienRepository.findAll();
        return listNhanVien.stream().map((nhanVien) -> modelMapper.map(nhanVien, NhanVienResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public NhanVienResponse getOne(int id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nhan Vien không tồn tai: " + id)
        );
        return modelMapper.map(nhanVien, NhanVienResponse.class);
    }


    @Override
    public NhanVienDTO save(NhanVienDTO nhanVienDTO) {
        ChucVu chucVu = chucVuRepository.findById(nhanVienDTO.getIdChucVu()).orElseThrow(()
                -> new ResourceNotFoundException("Không tồn tại ChucVu có ID: " + nhanVienDTO.getIdChucVu()));
        NhanVien nhanVien = modelMapper.map(nhanVienDTO, NhanVien.class);
        nhanVien.setChucVu(chucVu);
        NhanVien nhanVienSave = nhanVienRepository.save(nhanVien);
        NhanVienDTO nhanVienDTOSave = modelMapper.map(nhanVienSave, NhanVienDTO.class);
        return nhanVienDTOSave;
    }

    @Override
    public NhanVienDTO update(NhanVienDTO nhanVienDTO) {
        ChucVu chucVu = chucVuRepository.findById(nhanVienDTO.getIdChucVu()).orElseThrow(()
                -> new ResourceNotFoundException("Không tồn tại ChucVu có ID: " + nhanVienDTO.getIdChucVu()));
        NhanVien nhanVien = modelMapper.map(nhanVienDTO, NhanVien.class);
        nhanVien.setChucVu(chucVu);
        NhanVien nhanVienSave = nhanVienRepository.save(nhanVien);
        NhanVienDTO nhanVienDTOSave = modelMapper.map(nhanVienSave, NhanVienDTO.class);
        return nhanVienDTOSave;
    }

    @Override
    public void delete(int id) {
        nhanVienRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVienResponse> getAllPage(Pageable pageable) {
//        Page<NhanVien> listPage= nhanVienRepository.findAll(pageable);
//         listPage.stream().map((nhanVien) -> modelMapper.map(nhanVien, NhanVienResponse.class))
//                 .collect(Collectors.toList());
//        return new PageImpl<>(responseList, pageable, listPage.getTotalElements());
        return null;
    }

    @Override
    public List<NhanVienResponse> searchNhanVien(String query) {
        List<NhanVien> listNhanVien = nhanVienRepository.searchNhanVien(query);
        return listNhanVien.stream().map((nhanVien) -> modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<NhanVienResponse> searchNhanVienSQL(String query) {
        List<NhanVien> listNhanVien = nhanVienRepository.searchNhanVien(query);
        return listNhanVien.stream().map((nhanVien) -> modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<NhanVienResponse> findByTenNhanVienAndTuoi(String ten, int tuoi) {
        List<NhanVien> listNhanVien = nhanVienRepository.findByTenNhanVienAndTuoi(ten, tuoi);
        return listNhanVien.stream().map(nhanVien -> modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<NhanVienResponse> findByTuoiGreaterThan(int tuoi) {
        List<NhanVien> listNhanVien = nhanVienRepository.findByTuoiGreaterThan(tuoi);
        return listNhanVien.stream().map(nhanVien -> modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<NhanVienResponse> findByTuoiLessThan(int tuoi) {
        List<NhanVien> listNhanVien = nhanVienRepository.findByTuoiLessThan(tuoi);
        return listNhanVien.stream().map(nhanVien -> modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
    }

//    @Override
//    public NhanVienDTO update(NhanVienDTO nhanVienDTO) {
//        ChucVu chucVu = chucVuRepository.findById(nhanVienDTO.getIdChucVu()).orElseThrow(()
//                -> new ResourceNotFoundException("Không tồn tại ChucVu có ID: " + nhanVienDTO.getIdChucVu()));
//        NhanVien nhanVienExits = nhanVienRepository.findById(nhanVienDTO.getId()).orElseThrow(()
//                -> new ResourceNotFoundException("ID update không tìm thấy: " + nhanVienDTO.getId()));
//        nhanVienExits.setMaNhanVien(nhanVienDTO.getMaNhanVien());
//        nhanVienExits.setTenNhanVien(nhanVienDTO.getTenNhanVien());
//        nhanVienExits.setTuoi(nhanVienDTO.getTuoi());
//        nhanVienExits.setDiaChi(nhanVienDTO.getDiaChi());
//        nhanVienExits.setChucVu(chucVu);
//        NhanVien nhanVienUpdate = nhanVienRepository.saveAndFlush(nhanVienExits);
//        return NhanVienMapper.mapToNhanVienDTO(nhanVienUpdate);
//    }
}
