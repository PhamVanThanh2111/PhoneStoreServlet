package controllers;

import java.io.IOException;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;
import daoiml.DienThoaiDAOImpl;
import daoiml.NhaCungCapDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
@WebServlet(urlPatterns = {"/dienThoai"})
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory entityManagerFactory;
	private DienThoaiDAO dienThoaiDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachDienThoaiNCCServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		entityManagerFactory = Persistence.createEntityManagerFactory("QUANLYDIENTHOAI");
		dienThoaiDAO = new DienThoaiDAOImpl(entityManagerFactory.createEntityManager());
	}

	@Override
	public void destroy() {
//		 TODO Auto-generated method stub
		entityManagerFactory.close();
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("listDienThoai") == null) {
			request.setAttribute("listDienThoai", dienThoaiDAO.getAllDienThoai());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/DanhSachDienThoaiNCC.jsp");
		dispatcher.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	

}
