package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHACUNGCAP")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MANCC")
	private int maNhaCungCap;
	@Column(name = "TENNHACC", columnDefinition = "NVARCHAR(255)")
	private String tenNhaCungCap;
	@Column(name = "DIACHI", columnDefinition = "NVARCHAR(255)")
	private String diaChi;
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + "]";
	}
}
