package cn.zhku.jsjs.haofeng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.zhku.jsjs.haofeng.service.SearchHibernateService;

/**
 * Servlet implementation class ajaxServletHibernateTest
 */
public class ajaxServletHibernateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxServletHibernateTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前台获取json格式数据
				request.setCharacterEncoding("UTF-8");
				String content = (String) request.getParameter("content");
				//创建一个service类，并调用其查询方法
				SearchHibernateService ss = new SearchHibernateService();
				List<String> list = null;
				list = ss.SearchHname(content);
				
				System.out.println(list);
				//将service返回的数据进行格式转换变成json
				//先创建一个Gson
				Gson gson = new Gson();
				//然后解析获得的list，把json转换成string
				String str = gson.toJson(list);
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
