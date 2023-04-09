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
		
		// GET DATA FROM CLIENT NOT ERROR FONT
		req.setCharacterEncoding("UTF-8");
		
		// DEFINE TYPE OF DATA RESPONSE FOR CLIENT
		resp.setContentType("application/json");
		
		// Read request from client
		HttpCommon.readerInputDataFromRequest(req.getReader());
		
//		try {
//			Book newBook = HttpCommon.readerInputDataFromRequest(req.getReader()).toModel(Book.class);
//			BookManagement.save(newBook, conn);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	}
//
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	}
//
//	@Override
//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	}

}
