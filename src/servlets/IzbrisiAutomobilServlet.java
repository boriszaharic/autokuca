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
 * Servlet implementation class IzbrisiAutomobilServlet
 */
@WebServlet("/IzbrisiAutomobilServlet")
public class IzbrisiAutomobilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzbrisiAutomobilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idVozilaString = request.getParameter("idAutomobila");

		
		String poruka = "";
		
		int idVozila = Integer.parseInt(idVozilaString);
		
		boolean ok = VoziloManager.izbrisiVozilo(idVozila);
		
		if (ok) {
			
			poruka = "Uspesno smo izbrisali automobil! Id izbrisanog automobila je: " + idVozila;
			
		} else {
			poruka = "Nismo uspeli da izbrisemo automobil!";
		}
		
		request.setAttribute("poruka", poruka);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSPStranice/Automobili.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
