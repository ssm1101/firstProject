package co.yedam.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;

public class DeleteReview implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 파라미터 읽어와서 => 삭제할 글번호
		
		// update 구현.
		
		String tpId = req.getParameter("tpId");
		String reviewId = req.getParameter("reviewId");
		ReviewService service = new ReviewServiceImplMybatis();
		service.deleteReview(Integer.parseInt(reviewId));
		
		return "reviewList.do?prodId=" + tpId + ".redirect";

	}

}
