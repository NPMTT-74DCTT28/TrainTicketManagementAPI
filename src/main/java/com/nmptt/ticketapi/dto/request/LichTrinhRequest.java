package com.nmptt.ticketapi.dto.request;

import com.nmptt.ticketapi.entity.Tau;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LichTrinhRequest {
    private Integer id;
    private String maLichTrinh;
    private Integer idTau;
    private Integer idTuyenDuong;
    private LocalDate ngayDi;
    private LocalDate ngayDen;
    private String trangThai;
}
