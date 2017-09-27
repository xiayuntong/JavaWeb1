package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CityDao;
import dao.PromotDao;
import entity.Sheng;
import entity.Shi;

public class CityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			// ?list.sizeÎª0£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿?????????????
			CityDao cDao = new CityDao();
			List<Sheng> shengs = cDao.searchSheng();
			int sId = 1;
			if(request.getParameter("sId")!=null){
				sId=Integer.parseInt(request.getParameter("sId"));
			}
			List<Shi> shis = cDao.searchShiBySheng(sId);
			request.setAttribute("shengs", shengs);
			request.setAttribute("shis", shis);
			request.setAttribute("sId", sId);
			request.getRequestDispatcher("shengshi.jsp").forward(request,
					response);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
