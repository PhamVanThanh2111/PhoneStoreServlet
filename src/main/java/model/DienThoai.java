package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MADT")
	private int maDienThoai;
	@Column(name = "TENDT")
	private String tenDienThoai;
	@Column(name = "NAMSANXUAT")
	private int namSanXuat;
	@Column(name = "CAUHINH")
	private String cauHinh;
	@Column(name = "MANCC")
	private int maNhaCungCap;
	@Column(name = "HINHANH")
	private String hinhAnh;

	public DienThoai() {
		super();
	}

	public DienThoai(String tenDienThoai, int namSanXuat, String cauHinh, int maNhaCungCap, String hinhAnh) {
		super();
		this.tenDienThoai = tenDienThoai;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.maNhaCungCap = maNhaCungCap;
		this.hinhAnh = hinhAnh;
	}

	public DienThoai(int maDienThoai, String tenDienThoai, int namSanXuat, String cauHinh, int maNhaCungCap,
			String hinhAnh) {
		super();
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.maNhaCungCap = maNhaCungCap;
		this.hinhAnh = hinhAnh;
	}

	public int getMaDienThoai() {
		return maDienThoai;
	}

	public void setMaDienThoai(int maDienThoai) {
		this.maDienThoai = maDienThoai;
	}

	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "DienThoai [maDienThoai=" + maDienThoai + ", tenDienThoai=" + tenDienThoai + ", namSanXuat=" + namSanXuat
				+ ", cauHinh=" + cauHinh + ", maNhaCungCap=" + maNhaCungCap + ", hinhAnh=" + hinhAnh + "]";
	}
}
