package notice.controller.customer;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class noticeRegProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("noticeRegProcController 신호신호");
		String title=request.getParameter("title");
		String content=request.getParameter("content");

		Notice n=new Notice();
		n.setTitle(title);
		n.setContent(content);

		NoticeDao dao=new NoticeDao();
		int af=dao.insert(n);

		PrintWriter out=response.getWriter();
		//목록으로 이동
		if(af>0)
			response.sendRedirect("notice.do");
		else
			out.println("글쓰기오류");
		
	}

}
