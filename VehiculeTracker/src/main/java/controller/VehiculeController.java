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

import ma.dao.ITracker;
import ma.dao.IVehicule;
import ma.models.Tracker;
import ma.models.Vehicule;

/**
 * Servlet implementation class CompteController
 */
@WebServlet("/tracker")
public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ITracker Tservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehiculeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("po") == null) {
			String simNumber = request.getParameter("simNumber");
			Tservice.ajouter(new Tracker(simNumber));
		}
		response.setContentType("application/json");
		List<Tracker> tracker = Tservice.findAll();
		Gson jsin = new Gson();
		response.getWriter().write(jsin.toJson(tracker));

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
