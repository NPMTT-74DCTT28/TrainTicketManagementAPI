package com.nmptt.ticketapi.controller;

import com.nmptt.ticketapi.dto.response.ApiResponse;
import com.nmptt.ticketapi.entity.Tau;
import com.nmptt.ticketapi.service.TauService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tau")
@RequiredArgsConstructor
public class TauController {
    private final TauService tauService;
    private final JsonMapper.Builder builder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Tau>>> getAll() {
        List<Tau> data = tauService.getAllTau();
        ApiResponse<List<Tau>> response = ApiResponse.<List<Tau>>builder().code(HttpStatus.OK.value()).message("Lấy danh sách tàu thành công").data(data).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Tau>> getTauById(@PathVariable Integer id) {
        Tau data = tauService.getTauById(id);
        ApiResponse<Tau> response = ApiResponse.<Tau>builder().code(HttpStatus.OK.value()).message("Lấy thông tin ga tàu thành công!").data(data).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Tau>> createGaTau(@RequestBody Tau tau) {
        Tau data = tauService.insertTau(tau);
        ApiResponse<Tau> response = ApiResponse.<Tau>builder().code(HttpStatus.CREATED.value()).message("Thêm mới tàu thành công!").data(data).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Tau>> updateGaTau(@RequestBody Tau tau) {
        Tau data = tauService.updateTau(tau);
        ApiResponse<Tau> response = ApiResponse.<Tau>builder().code(HttpStatus.OK.value()).message("Cập nhật tàu thành công!").data(data).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteGaTau(@PathVariable Integer id) {
        tauService.delete(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder().code(HttpStatus.OK.value()).message("Xóa tàu thành công!").build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Tau>>> searchTau(@RequestParam(required = false, defaultValue = "") String key) {
        String searchkey = "%" + key + "%";
        List<Tau> data = tauService.searchTau(searchkey, searchkey);
        ApiResponse<List<Tau>> response = ApiResponse.<List<Tau>>builder().code(HttpStatus.OK.value()).message("Tìm kiếm ga tàu thành công!").data(data).build();
        return ResponseEntity.ok(response);
    }
}
