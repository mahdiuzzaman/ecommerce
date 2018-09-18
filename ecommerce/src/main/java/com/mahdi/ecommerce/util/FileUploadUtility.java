package com.mahdi.ecommerce.util;



import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH ="E:\\project\\ecommerce\\ecommerce\\src\\main\\webapp\\assets\\images\\";
	
	//where server container(tomcat) deployed the application
	private static String REAL_PATH ="";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// get th ereal pat 
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		//check if th edirectory exist if not create one
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//server upload 
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//proect direcctory upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}


















