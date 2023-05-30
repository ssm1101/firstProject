package co.yedam.product.command;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String prodStart = req.getParameter("prodStart");
		String prodEnd = req.getParameter("prodEnd");
		int prodNum = Integer.parseInt(req.getParameter("prodNum"));
		int prodPrice = Integer.parseInt(req.getParameter("prodPrice"));
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		String prodText = req.getParameter("prodText");
		String mbId = req.getParameter("mbId");

		ProductVO vo = new ProductVO();
		vo.setProdStart(prodStart);
		vo.setProdEnd(prodEnd);
		vo.setProdNum(prodNum);
		vo.setProdPrice(prodPrice);
		vo.setTpId(tpId);
		vo.setProdText(prodText);
		vo.setMbId(mbId);

		ProductService service = new ProductServiceImplMybatis();
		
		int r = service.prodAdd(vo);

		if (r > 0) {
			return "productList.do";
		} else {
			return "productForm.do";
		}
	}
}
