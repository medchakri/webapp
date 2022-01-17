package controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ma.dao.IVehicule;
import ma.models.Vehicule;

/**
 * Servlet implementation class CompteController
 */
@WebServlet("/Gps")
public class GpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IVehicule service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GpsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("op") == null) {
			String matricule = request.getParameter("matricule");
			String marque = request.getParameter("marque");
			String type = request.getParameter("type");
			
			service.ajouter(new Vehicule(matricule,marque,type));
		}
		response.setContentType("application/json");
		List<Vehicule> vehicule = service.findAll();
		Gson json = new Gson();
		response.getWriter().write(json.toJson(vehicule));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
