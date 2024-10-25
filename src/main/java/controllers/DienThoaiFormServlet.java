package controllers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.DienThoai;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dao.DienThoaiDAO;
import dao.NhaCungCapDAO;
import daoiml.DienThoaiDAOImpl;
import daoiml.NhaCungCapDAOImpl;

/**
 * Servlet implementation class DienThoaiFormServlet
 */
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, // 1 MB Nếu kích thước file upload lơn hơn threshold sẽ được ghi trực tiếp vào ổ đĩa thay vì lưu ở memory đệm.
		maxFileSize = 1024 * 1024 * 5, // 5 MB Kích thước tối da của file được upload.
		maxRequestSize = 1024 * 1024 * 10,
		location = "D:/DH/Lap trinh WWW/21089891_PhamVanThanh/21089891_PhamVanThanh_Tuan05_Bai01/src/main/webapp/view/imgs")
@WebServlet("/service")
public class DienThoaiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntityManagerFactory entityManagerFactory;
	private DienThoaiDAO dienThoaiDAO;
	private NhaCungCapDAO nhaCungCapDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DienThoaiFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		entityManagerFactory = Persistence.createEntityManagerFactory("QUANLYDIENTHOAI");
		dienThoaiDAO = new DienThoaiDAOImpl(entityManagerFactory.createEntityManager());
		nhaCungCapDAO = new NhaCungCapDAOImpl(entityManagerFactory.createEntityManager());
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "add":
			showAddForm(request, response);
			break;
		case "quanLy":
			showQuanLyForm(request, response);
			break;
		case "edit":
			editPhone(request, response);
			break;
		case "delete":
			deletePhone(request, response);
			break;
		default:
			listDienThoai(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "insert":
			addPhone(request, response);
			break;
		case "update":
			updatePhone(request, response);
			break;
		default:
			listDienThoai(request, response);
			break;
		}
	}

	private void updatePhone(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String maDienThoai = request.getParameter("maDienThoai");
		String tenDienThoai = request.getParameter("tenDienThoai");
		String namSanXuat = request.getParameter("namSanXuat");
		String cauHinh = request.getParameter("cauHinh");
		String nhaCungCap = request.getParameter("nhaCungCap");
		try {
			Part filePart = request.getPart("hinhAnh");
			if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
				String fileName = filePart.getSubmittedFileName();
				filePart.write(fileName);
				DienThoai dienThoai = new DienThoai(Integer.parseInt(maDienThoai), tenDienThoai, Integer.parseInt(namSanXuat), cauHinh, Integer.parseInt(nhaCungCap), fileName);
				dienThoaiDAO.update(dienThoai);
				response.sendRedirect(request.getContextPath() + "/dienThoai");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deletePhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("delete");
		String maDienThoai = request.getParameter("id");
		dienThoaiDAO.delete(Integer.parseInt(maDienThoai));
		response.sendRedirect(request.getContextPath());
	}

	private void showQuanLyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("listDienThoai") == null) {
			request.setAttribute("listDienThoai", dienThoaiDAO.getAllDienThoai());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/quanly.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getAttribute("listNhaCungCap") == null) {
			request.setAttribute("listNhaCungCap", nhaCungCapDAO.getAllNhaCungCap());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/DienThoaiForm.jsp");
		dispatcher.forward(request, response);
	}

	private void listDienThoai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DienThoai> listDienThoai = dienThoaiDAO.getAllDienThoai();
		request.setAttribute("listDienThoai", listDienThoai);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addPhone(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String tenDienThoai = request.getParameter("tenDienThoai");
		String namSanXuat = request.getParameter("namSanXuat");
		String cauHinh = request.getParameter("cauHinh");
		String nhaCungCap = request.getParameter("nhaCungCap");
		try {
			Part filePart = request.getPart("hinhAnh");
			if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
				String fileName = filePart.getSubmittedFileName();
				filePart.write(fileName);
				DienThoai dienThoai = new DienThoai(tenDienThoai, Integer.parseInt(namSanXuat), cauHinh, Integer.parseInt(nhaCungCap), fileName);
				dienThoaiDAO.save(dienThoai);
				response.sendRedirect(request.getContextPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void editPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDienThoai = request.getParameter("id");
		DienThoai dienThoai = dienThoaiDAO.getDienThoaiById(Integer.parseInt(maDienThoai));
		request.setAttribute("dienThoai", dienThoai);
		if (request.getAttribute("listNhaCungCap") == null) {
			request.setAttribute("listNhaCungCap", nhaCungCapDAO.getAllNhaCungCap());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/html/DienThoaiForm.jsp");
		dispatcher.forward(request, response);
	}
}
