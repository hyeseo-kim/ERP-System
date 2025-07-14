package com.algorizo.erp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet{
	
	private static final String UPLOAD_DIR = "C:/path/to/uploaded/images";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		
		if(name == null || name.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No image name provided");
			return;
		}
		
		File imageFile = new File(UPLOAD_DIR, name);
		if(!imageFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		response.setContentType(Files.probeContentType(imageFile.toPath()));
		try(OutputStream out = response.getOutputStream(); FileInputStream in = new FileInputStream(imageFile)){
			byte[] buffer = new byte[8182];
			int len;
			while((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
		}
		
		
		
	}
	
}
