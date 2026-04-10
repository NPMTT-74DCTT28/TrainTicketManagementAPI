# Tài liệu API - Hệ thống quản lý vé tàu

## Thông tin

* **Application name:** `TrainTicketManagementAPI`
* **API version:** `v1`
* **Base URL:**

```
http://localhost:8080/api/v1
```

---

## Danh sách API

### 1. Quản lý thông tin nhân viên

***1.1. Lấy danh sách nhân viên***

* **URL:** `/nhan-vien`
* **Method:** `GET`

**Success response (200 OK)**

```json
{
  "code": 200,
  "message": "Lấy danh sách nhân viên thành công!",
  "data": [
    {
      "diaChi": "Địa chỉ",
      "email": "Email",
      "gioiTinh": "Giới tính",
      "hoTen": "Họ tên",
      "id": 1,
      "maNhanVien": "Mã nhân viên",
      "ngaySinh": "Ngày sinh",
      "sdt": "Số điện thoại",
      "vaiTro": "Vai trò"
    }
  ]
}
```

***1.2. Lấy thông tin nhân viên với mã nhân viên cho trước***

* **URL:** `/nhan-vien/{id}`
* **Method:** `GET`

**Path variables**

```
| Biến | Kiểu dữ liệu |  Mô tả |

| id | int | Số ID nhân viên (VD: 123, 999) |
```

**Success response 200 OK**

```json
{
  "code": 200,
  "message": "Lấy thông tin nhân viên thành công!",
  "data": {
    "diaChi": "Địa chỉ",
    "email": "Email",
    "gioiTinh": "Giới tính",
    "hoTen": "Họ tên",
    "id": 1,
    "maNhanVien": "Mã nhân viên",
    "ngaySinh": "Ngày sinh",
    "sdt": "Số điện thoại",
    "vaiTro": "Vai trò"
  }
}
```

***1.3. Thêm thông tin nhân viên mới***

* **URL:** `/nhan-vien`
* **Method:** `POST`

**Request body: YES**

```json
{
  "diaChi": "Địa chỉ",
  "email": "Email",
  "gioiTinh": "Giới tính",
  "hoTen": "Họ tên",
  "maNhanVien": "Mã nhân viên",
  "matKhau": "Mật khẩu",
  "ngaySinh": "Ngày sinh",
  "sdt": "Số điện thoại",
  "vaiTro": "Vai trò"
}
```

**Success response 201 CREATED**

```json
{
  "code": 201,
  "message": "Thêm thông tin nhân viên thành công!",
  "data": {
    "diaChi": "Địa chỉ",
    "email": "Email",
    "gioiTinh": "Giới tính",
    "hoTen": "Họ tên",
    "id": 1,
    "maNhanVien": "Mã nhân viên",
    "ngaySinh": "Ngày sinh",
    "sdt": "Số điện thoại",
    "vaiTro": "Vai trò"
  }
}
```

***1.4. Cập nhật thông tin nhân viên***

* **URL:** `/nhan-vien`
* **Method:** `PUT`

**Request body: YES**

```json
{
  "diaChi": "Địa chỉ",
  "email": "Email",
  "gioiTinh": "Giới tính",
  "hoTen": "Họ tên",
  "id": 1,
  "maNhanVien": "Mã nhân viên",
  "matKhau": "Mật khẩu",
  "ngaySinh": "Ngày sinh",
  "sdt": "Số điện thoại",
  "vaiTro": "Vai trò"
}
```

**Success response 200 OK**

```json
{
  "code": 200,
  "message": "Cập nhật thông tin nhân viên thành công!",
  "data": {
    "diaChi": "Địa chỉ",
    "email": "Email",
    "gioiTinh": "Giới tính",
    "hoTen": "Họ tên",
    "id": 1,
    "maNhanVien": "Mã nhân viên",
    "ngaySinh": "Ngày sinh",
    "sdt": "Số điện thoại",
    "vaiTro": "Vai trò"
  }
}
```

***1.5. Xoá thông tin nhân viên***

* **URL:** `/nhan-vien/{id}`
* **Method:** `DELETE`

**Path variables**

```
| Biến | Kiểu dữ liệu | Mô tả |

| id | int | Số ID nhân viên (VD: 123, 999) |
```

**Success response 200 OK**

```json
{
  "code": 200,
  "message": "Xoá nhân viên thành công!",
  "data": null
}
```

***1.6. Tìm kiếm nhân viên***

* **URL:** `/search`
* **Method:** `GET`

**Query params**

```
| Tham số | Kiểu dữ liệu | Bắt buộc | Mô tả |

| keyword | String | No | Từ khoá tìm kiếm (mã nhân viên, họ tên, số điện thoại, email, địa chỉ) |
| gioiTinh | String | No | Giới tính |
| vaiTro | String | No | Vai trò |
```

**Success response 200 OK**

```json
{
  "code": 200,
  "message": "Tìm kiếm nhân viên thành công!",
  "data": [
    {
      "diaChi": "Địa chỉ",
      "email": "Email",
      "gioiTinh": "Giới tính",
      "hoTen": "Họ tên",
      "id": 1,
      "maNhanVien": "Mã nhân viên",
      "ngaySinh": "Ngày sinh",
      "sdt": "Số điện thoại",
      "vaiTro": "Vai trò"
    }
  ]
}
```

