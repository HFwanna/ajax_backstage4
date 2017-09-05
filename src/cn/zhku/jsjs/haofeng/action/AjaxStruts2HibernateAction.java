package cn.zhku.jsjs.haofeng.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.zhku.jsjs.haofeng.service.StrutsSearchService;

public class AjaxStruts2HibernateAction extends ActionSupport{
	private StrutsSearchService strutsSearchService ;
	
	public void setStrutsSearchService(StrutsSearchService strutsSearchService) {
		this.strutsSearchService = strutsSearchService;
	}
	// 1.使用属性驱动获得页面传来的参数，要为属性创建getter和setter方法
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(content);
		// 2.调用service方法进行模糊查询
		List<String> list = strutsSearchService.SearchHname(content);
		System.out.println("action:"+list);
		// 3.将接受结果list转化成json格式的字符串返回
		Gson gson = new Gson();
		String json = gson.toJson(list);
		// 4.把json字符串返回到index.jsp页面
		ServletActionContext.getResponse().getWriter().write(json);
		//这里因为不需要跳转到新页面，返回null
		return null;
	}
	
}
