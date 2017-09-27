package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import dao.CityDao;
import dao.PromotDao;
import entity.Sheng;
import entity.Shi;

public class CityServlet1 extends HttpServlet {

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
			List<Shi> shis = cDao.searchShiBySheng(sId);
			if (request.getParameter("sId") == null) {

				request.setAttribute("shengs", shengs);
				request.setAttribute("shis", shis);

				request.getRequestDispatcher("shengshi1.jsp").forward(request,
						response);
			} else {

				sId = Integer.parseInt(request.getParameter("sId"));
				shis = cDao.searchShiBySheng(sId);
				// String str="";
				// for(int i=0;i<shis.size();i++){
				//
				// str+=shis.get(i).getId()+","+shis.get(i).getName()+";";
				//
				//
				// }
				JSONArray arry = JSONArray.fromObject(shis);

				out.print(arry);
			}
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
