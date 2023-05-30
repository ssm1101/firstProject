package co.yedam.login.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;
import co.yedam.topAd.vo.TopAdViewVO;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
			HttpSession session = req.getSession();
			session.invalidate();
			
			TopAdService service = new TopAdServiceImplMybatis();
			List<TopAdViewVO> list = service.TopdisplayView();
			System.out.println(list);
			req.setAttribute("TopdisplayView", list);	
			
			TripService trip = new TripServiceImplMybatis();
			List<TripVO> tripList = trip.recommandList();
			req.setAttribute("tripList", tripList);
			
			TripVO vo = new TripVO();
			List<TripVO> pList = trip.packageList(vo);
			req.setAttribute("tripList2", pList);
			
			return "user/main/main.tiles";
	}
}