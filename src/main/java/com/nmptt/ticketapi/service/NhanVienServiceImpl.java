package com.nmptt.ticketapi.service;

import com.nmptt.ticketapi.dto.request.NhanVienRequest;
import com.nmptt.ticketapi.dto.response.NhanVienResponse;
import com.nmptt.ticketapi.entity.NhanVien;
import com.nmptt.ticketapi.exception.DuplicateDataException;
import com.nmptt.ticketapi.exception.ResourceNotFoundException;
import com.nmptt.ticketapi.repository.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVienResponse> getAllNhanVien() {
        List<NhanVien> staffs = nhanVienRepository.findAll();
        return staffs.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public NhanVienResponse getNhanVienById(int id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thông tin nhân viên."));
        return mapToResponse(nhanVien);
    }

    @Override
    public NhanVienResponse createNhanVien(NhanVienRequest request) {
        checkTrung(request);

        NhanVien newNhanVien = NhanVien.builder()
                .maNhanVien(request.getMaNhanVien())
                .matKhau(request.getMatKhau())
                .hoTen(request.getHoTen())
                .ngaySinh(request.getNgaySinh())
                .gioiTinh(request.getGioiTinh())
                .sdt(request.getSdt())
                .email(request.getEmail())
                .diaChi(request.getDiaChi())
                .vaiTro(request.getVaiTro())
                .build();

        return mapToResponse(nhanVienRepository.save(newNhanVien));
    }

    @Override
    public NhanVienResponse updateNhanVien(NhanVienRequest request) {
        checkTrung(request);

        NhanVien existing = nhanVienRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Id không tồn tại"));

        existing.setHoTen(request.getHoTen());
        existing.setNgaySinh(request.getNgaySinh());
        existing.setGioiTinh(request.getGioiTinh());
        existing.setSdt(request.getSdt());
        existing.setEmail(request.getEmail());
        existing.setDiaChi(request.getDiaChi());
        existing.setVaiTro(request.getVaiTro());

        return mapToResponse(nhanVienRepository.save(existing));
    }

    @Override
    public void deleteNhanVien(int id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id không hợp lệ."));
        nhanVienRepository.delete(nhanVien);
    }

    private void checkTrung(NhanVienRequest request) {
        if (nhanVienRepository.existsByMaNhanVienAndIdNot(request.getMaNhanVien(), request.getId())) {
            throw new DuplicateDataException("Mã nhân viên đã tồn tại.");
        }
        if (nhanVienRepository.existsBySdtAndIdNot(request.getSdt(), request.getId())) {
            throw new DuplicateDataException("SĐT đã được sử dụng.");
        }
        if (request.getEmail() != null && nhanVienRepository.existsByEmailAndIdNot(request.getEmail(), request.getId())) {
            throw new DuplicateDataException("Email đã được sử dụng.");
        }
    }

    private NhanVienResponse mapToResponse(NhanVien nhanVien) {
        return NhanVienResponse.builder()
                .id(nhanVien.getId())
                .maNhanVien(nhanVien.getMaNhanVien())
                .hoTen(nhanVien.getHoTen())
                .ngaySinh(nhanVien.getNgaySinh())
                .gioiTinh(nhanVien.getGioiTinh())
                .sdt(nhanVien.getSdt())
                .email(nhanVien.getEmail())
                .diaChi(nhanVien.getDiaChi())
                .vaiTro(nhanVien.getVaiTro())
                .build();
    }
}
