package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbmodel.Prodavac;

import managers.ProdajaManager;


/**
 * Servlet implementation class ProdajAutomobilServlet
 */
@WebServlet("/ProdajAutomobilServlet")
public class ProdajAutomobilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdajAutomobilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idVozilaString = request.getParameter("idAutomobila");
		Prodavac p = (Prodavac) request.getSession().getAttribute("prodavac");
		
		String poruka = "";
		
		int idVozila = Integer.parseInt(idVozilaString);
		
		int idProdaje = ProdajaManager.prodajAutomobil(idVozila, p.getIdprodavca());
		
		if (idProdaje > 0) {
			
			poruka = "Uspesno smo prodali automobil! Id prodaje je: " + idProdaje;
			
		} else {
			poruka = "Nismo uspeli da prodamo automobil!";
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
