package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PromotDao;

public class PromotServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String s1 = request.getParameter("mes");
			PromotDao pDao = new PromotDao();
	
				List<String> list = pDao.search(s1);
				//?list.sizeÎª0£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿£¿
				System.out.println(list.size());
				String s2 = "";
				for (int i = 0; i < list.size(); i++) {
					s2 += list.get(i) + ",";

				}
				if (s2.length() >0) {
					s2 = s2.substring(0, s2.length() - 1);
					
				}
				out.print(s2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
