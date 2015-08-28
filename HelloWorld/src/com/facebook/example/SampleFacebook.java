package com.facebook.example;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.social.facebook.FBConnection;
import com.social.facebook.FBGraph;

/**
 * Servlet implementation class SampleFacebook
 */
@WebServlet("/SampleFacebook")
public class SampleFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String code = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleFacebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		code = request.getParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);

		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		System.out.print(graph);
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1>Facebook Login using Java</h1>");
		out.println("<h2>Application Main Menu</h2>");
		out.println("<div>Welcome "+fbProfileData.get("name"));
		out.println("<div>Facebook id is: "+fbProfileData.get("id"));
	}

}
