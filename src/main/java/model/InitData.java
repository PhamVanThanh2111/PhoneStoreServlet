package model;

import java.io.File;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;
import daoiml.DienThoaiDAOImpl;
import daoiml.NhaCungCapDAOImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InitData {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("QUANLYDIENTHOAI");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
		DienThoaiDAO dienThoaiDAO = new DienThoaiDAOImpl(entityManager);
		dienThoaiDAO.save(new DienThoai("IPHONE SIEU MANH", 2024, "IPHONE SIEU MANH", 2, "IPHONE_MANH.jpg"));
//		dienThoaiDAO.save(new DienThoai("Samsung Galaxy S20", 2020, "Snapdragon 865", 1, "samsung-galaxy-s20.jpg"));
//		dienThoaiDAO.save(new DienThoai("Samsung Galaxy S10", 2019, "Snapdragon 855", 1, "samsung-galaxy-s10.jpg"));
//		dienThoaiDAO.save(new DienThoai("Samsung Galaxy S9", 2018, "Snapdragon 845", 1, "samsung-galaxy-s9.jpg"));
//		dienThoaiDAO.save(new DienThoai("iPhone 12", 2020, "Apple A14 Bionic", 2, "iphone-12.jpg"));
//		dienThoaiDAO.save(new DienThoai("iPhone 11", 2019, "Apple A13 Bionic", 2, "iphone-11.jpg"));
//		
//		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl(entityManager);
//		nhaCungCapDAO.save(new NhaCungCap("Samsung", "Hàn Quốc", "18001111"));
//		nhaCungCapDAO.save(new NhaCungCap("Apple", "Mỹ", "18001111"));
//		nhaCungCapDAO.save(new NhaCungCap("Xiaomi", "Trung Quốc", "18001111"));
	
		String relative = "src/main/webapp/view/imgs/";
		String absolute = new File(relative).getAbsolutePath();
		System.out.println(absolute);
	}
}
