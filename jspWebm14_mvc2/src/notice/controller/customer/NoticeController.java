package notice.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("NoticeController 신호");

		int page=1;
		String pg=request.getParameter("pg");
		if(pg!=null && !pg.equals(""))
			page=Integer.parseInt(pg);
		System.out.println("pg : "+pg);
		
		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if(field==null || field.equals(""))
			field="title";
		
		String query=request.getParameter("q");
		System.out.println("query : "+query);
		if(query==null)
			query="";
		
		NoticeDao dao=new NoticeDao();
		List<Notice> list= dao.getNotices(page,field,query);
		
//		total count
		int cnt=dao.getCount(field,query);
		System.out.println("tot cnt : "+cnt);
		
		int start=page-(page-1)%5;
		int end=cnt/5+(cnt%5==0?0:1);
		
		
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("cnt", cnt);
		request.setAttribute("page", page);
		request.setAttribute("query", query);
		request.setAttribute("list", list);
		request.getRequestDispatcher("notice.jsp").forward(request, response);

	}

}
