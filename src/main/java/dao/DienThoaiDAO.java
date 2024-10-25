package dao;

import java.util.List;

import model.DienThoai;

public interface DienThoaiDAO {
	public List<DienThoai> getAllDienThoai();
	
	public DienThoai getDienThoaiById(int maDienThoai);
	
	public DienThoai save(DienThoai dienThoai);

	public void delete(int maDienThoai);
	
	public DienThoai update(DienThoai dienThoai);
}
