package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.VoziloManager;
import dbmodel.Vozilo;

/**
 * Servlet implementation class IzmeniAutomobilServlet
 */
@WebServlet("/IzmeniAutomobilServlet")
public class IzmeniAutomobilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmeniAutomobilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idVozilaString = request.getParameter("idAutomobila");
		
		
		int idVozila = Integer.parseInt(idVozilaString);
		
		Vozilo v = VoziloManager.getVoziloById(idVozila);
		
		if (v != null) {
			request.getSession().setAttribute("vozilo", v);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSPStranice/IzmeniAutomobil.jsp");
			rd.forward(request, response);
			
		} else {
			String poruka = "Greska!";
			request.setAttribute("poruka", poruka);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSPStranice/Automobili.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Vozilo v = (Vozilo) request.getSession().getAttribute("vozilo");
		String idKatString = request.getParameter("kat");
		String marka = request.getParameter("marka");
		String model = request.getParameter("model");
		String boja = request.getParameter("boja");
		String godinaString = request.getParameter("godina");
		String cenaString = request.getParameter("cena");
		
		int idKat = Integer.parseInt(idKatString);
		int godina = Integer.parseInt(godinaString);
		int cena = Integer.parseInt(cenaString);
		
		String poruka = "";
		
		boolean izmenio = VoziloManager.updateVozila(v.getIdvozila(), idKat, marka, model, cena, godina, boja);
		if (izmenio) {
			poruka = "Uspesno smo izmenili podatke automobila! " + marka + " model:" + model;
		} else {
			poruka = "Nismo uspeli da izmenimo podatke automobila!";
		}
		
		request.setAttribute("poruka", poruka);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSPStranice/Automobili.jsp");
		rd.forward(request, response);
	}

}
