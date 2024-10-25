package dao;

import java.util.List;

import model.NhaCungCap;

public interface NhaCungCapDAO {
	public List<NhaCungCap> getAllNhaCungCap();
	
	public NhaCungCap getNhaCungCapById(int maNhaCungCap);
	
	public NhaCungCap save(NhaCungCap nhaCungCap);
	
}
