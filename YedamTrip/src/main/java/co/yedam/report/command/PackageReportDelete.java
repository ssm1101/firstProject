package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;

public class PackageReportDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		System.out.println(tpId);
		ReportService service = new ReportServiceImplMybatis();
		
		int r = service.tReportDelete(tpId);
		String json ="";
		if(r>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
