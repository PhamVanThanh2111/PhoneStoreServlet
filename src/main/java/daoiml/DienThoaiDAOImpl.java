package daoiml;

import java.util.List;

import dao.DienThoaiDAO;
import jakarta.persistence.EntityManager;
import model.DienThoai;

public class DienThoaiDAOImpl implements DienThoaiDAO {
	EntityManager entityManager;

	public DienThoaiDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<DienThoai> getAllDienThoai() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from DienThoai", DienThoai.class).getResultList();
	}

	@Override
	public DienThoai getDienThoaiById(int maDienThoai) {
		// TODO Auto-generated method stub
		return entityManager.find(DienThoai.class, maDienThoai);
	}

	@Override
	public DienThoai save(DienThoai dienThoai) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(dienThoai);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
				return null;
			}
		}
		return dienThoai;
	}

	@Override
	public void delete(int maDienThoai) {
		// TODO Auto-generated method stub
		DienThoai dienThoai = getDienThoaiById(maDienThoai);
		if (dienThoai != null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(dienThoai);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
			}
		}
	}

	@Override
	public DienThoai update(DienThoai dienThoai) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(dienThoai);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
				return null;
			}
		}
		return dienThoai;
	}

}
