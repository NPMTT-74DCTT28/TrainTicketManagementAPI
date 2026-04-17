package com.nmptt.ticketapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class LichTrinhResponse {
    private Integer id;
    private String maLichTrinh;
    private Integer idTau;
    private Integer idTuyenDuong;
    private LocalDate ngayDi;
    private LocalDate ngayDen;
    private String trangThai;
}
