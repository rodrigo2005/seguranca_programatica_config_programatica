package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends SegurancaController {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
				
		if(isLogado(request)){
			request.getRequestDispatcher("/area").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/paginas/login.jsp").forward(request, response);
		}		
	}

}
