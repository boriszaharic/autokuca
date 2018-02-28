package reports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.VoziloManager;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import dbmodel.Vozilo;

/**
 * Servlet implementation class IzvestajSviSlobodniAutomobiliServlet
 */
@WebServlet("/IzvestajSviSlobodniAutomobiliServlet")
public class IzvestajSviSlobodniAutomobiliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzvestajSviSlobodniAutomobiliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Izvestaj svi slobodni!");
		List<Vozilo> slobodni = VoziloManager.slobodniAutomobili();
		HashMap<String, Object> params = new HashMap<String, Object>();
		ServletContext context = this.getServletContext();		
		String reportsDirectory = context.getRealPath("/") + "/WEB-INF/classes/reports/";
		String jasperFile = reportsDirectory+"SviSlobodniAutomobili.jasper";
		JasperPrint jasperPrint = null;
		try{
		if(slobodni.size()==0){
			JREmptyDataSource dataSource = new JREmptyDataSource();
			jasperPrint = JasperFillManager.fillReport(jasperFile,params, dataSource);
		}else{
			JRDataSource dataSource = new JRBeanCollectionDataSource(slobodni);
			jasperPrint = JasperFillManager.fillReport(jasperFile,params, dataSource);
		}
		ServletOutputStream servletOutputStream = response.getOutputStream();

		JRPdfExporter pdfExporter = new JRPdfExporter();
			
		pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,servletOutputStream);
			
			
		pdfExporter.exportReport();
			
			response.setContentType("application/pdf");
			
			servletOutputStream.flush();
			servletOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
