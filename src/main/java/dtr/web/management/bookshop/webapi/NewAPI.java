package dtr.web.management.bookshop.webapi;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dtr.web.management.bookshop.web.action.controller.BookManagement;
import dtr.web.management.bookshop.web.model.Book;
import dtr.web.management.bookshop.webapi.common.HttpCommon;

@WebServlet(urlPatterns = { "/api-web-new" })
public class NewAPI extends HttpServlet {

	private static Connection conn;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		try {
			Book newBook = HttpCommon.readerInputDataFromRequest(req.getReader()).toModel(Book.class);
			BookManagement.save(newBook, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}

}
