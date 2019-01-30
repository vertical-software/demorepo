package com.vertical.imagecapture;

import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder; 
/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in post");
		try { 
			StringBuffer buffer = new StringBuffer(); 
			Reader reader = request.getReader(); 
			int current; 
			while((current = reader.read()) >= 0) 
				buffer.append((char) current); 
			String data = new String(buffer); 
			data = data.substring(data.indexOf(",") + 1); 
			System.out.println("PNG image data on Base64: " + data); 
			FileOutputStream output = new FileOutputStream(new File("D:\\scan" + new Random().nextInt(100000) + ".png")); 
			output.write(new BASE64Decoder().decodeBuffer(data)); 
			output.flush(); 
			output.close(); 
			} catch (Exception e) 
		{ 
				e.printStackTrace(); 
				} 
		} 
		
	}



