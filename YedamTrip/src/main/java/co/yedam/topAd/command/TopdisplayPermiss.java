package co.yedam.topAd.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;

public class TopdisplayPermiss implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String tpId = req.getParameter("num");
		int id = Integer.parseInt(tpId);
		
		System.out.println(id);
		
		TopAdService service = new TopAdServiceImplMybatis();
		service.TopdisplayPermiss(id);

		return "topdisplayList.do";
	}

}
