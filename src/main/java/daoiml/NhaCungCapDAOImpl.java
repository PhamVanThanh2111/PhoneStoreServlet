package daoiml;

import java.util.List;

import dao.NhaCungCapDAO;
import jakarta.persistence.EntityManager;
import model.NhaCungCap;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {

	private EntityManager entityManager;
	
	public NhaCungCapDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from NhaCungCap", NhaCungCap.class).getResultList();
	}

	@Override
	public NhaCungCap getNhaCungCapById(int maNhaCungCap) {
		// TODO Auto-generated method stub
		return entityManager.find(NhaCungCap.class, maNhaCungCap);
	}

	@Override
	public NhaCungCap save(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(nhaCungCap);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
			if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
				return null;
			}
        }
        return nhaCungCap;
	}

}
