package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.VoziloManager;

/**
 * Servlet implementation class DodajAutomobilServlet
 */
@WebServlet("/DodajAutomobilServlet")
public class DodajAutomobilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajAutomobilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		
		int idVozila = VoziloManager.snimiVozilo(idKat, marka, model, cena, godina, boja);
		if (idVozila > 0) {
			poruka = "Uspesno smo dodali automobil, id automobila je: " + idVozila;
		} else {
			poruka = "Nismo uspeli da dodamo novi automobil!";
		}
		
		request.setAttribute("poruka", poruka);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSPStranice/DodajAutomobil.jsp");
		rd.forward(request, response);
		
	}

}
