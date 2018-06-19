package jpautils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileUploadSystem {

	private static final String CV_UPLOAD_DIRECTORY = "uploads/cv";
	private static final String PHOTO_UPLOAD_DIRECTORY = "uploads/photos";
	private static final String VIDEO_UPLOAD_DIRECTORY = "uploads/videos";
	
	public String uploadCV(HttpServletRequest request) throws IOException, ServletException {
		/* form our images upload directory path */
		String servletContextPath = request.getServletContext().getRealPath("");
		String cvFile = servletContextPath + File.separator + CV_UPLOAD_DIRECTORY;
		/* create upload directory if it doesn't already exist */
		File cvDir = new File(cvFile);
		if (!cvDir.exists()) cvDir.mkdir();
		
		String cvName;
		/* source: https://stackoverflow.com/questions/43813392/how-to-get-the-name-of-the-file-which-i-want-to-upload-using-multipart */
		for(Part p : request.getParts()) {
			if (p.getName().equals("cv")) {
				cvName = getImageName(p);

				if (!cvName.equals("")) {
					Date date = new Date();
					String cvPath = cvFile + File.separator + date.toString() + cvName;
					p.write(cvPath);
					
					String retPath = CV_UPLOAD_DIRECTORY + File.separator + date.toString() + cvName;
					
					/* for debugging */
					System.out.println(cvPath);
					System.out.println(retPath);
					
					return retPath;
				}
				else
					return "";
			}
		}
		
		return "";
	}

	public String uploadPhoto(HttpServletRequest request) throws IOException, ServletException {
		/* form our images upload directory path */
		String servletContextPath = request.getServletContext().getRealPath("");
		String photosFile = servletContextPath + File.separator + PHOTO_UPLOAD_DIRECTORY;
		/* create upload directory if it doesn't already exist */
		File photosDir = new File(photosFile);
		if (!photosDir.exists()) photosDir.mkdir();
		
		String photoName;
		/* source: https://stackoverflow.com/questions/43813392/how-to-get-the-name-of-the-file-which-i-want-to-upload-using-multipart */
		for(Part p : request.getParts()) {
			if (p.getName().equals("photo")) {
				photoName = getImageName(p);

				if (!photoName.equals("")) {
					Date date = new Date();
					String photoPath = photosFile + File.separator + date.toString() + photoName;
					p.write(photoPath);
					
					String retPath = PHOTO_UPLOAD_DIRECTORY + File.separator + date.toString() + photoName;
					
					/* for debugging */
					System.out.println(photoPath);
					System.out.println(retPath);
					
					return retPath;
				}
				else
					return "";
			}
		}
		
		return "";
	}

	public String uploadVideo(HttpServletRequest request) throws IOException, ServletException {
		/* form our images upload directory path */
		String servletContextPath = request.getServletContext().getRealPath("");
		String videosFile = servletContextPath + File.separator + VIDEO_UPLOAD_DIRECTORY;
		/* create upload directory if it doesn't already exist */
		File videosDir = new File(videosFile);
		if (!videosDir.exists()) videosDir.mkdir();
		
		String videoName;
		/* source: https://stackoverflow.com/questions/43813392/how-to-get-the-name-of-the-file-which-i-want-to-upload-using-multipart */
		for(Part p : request.getParts()) {
			if (p.getName().equals("video")) {
				videoName = getImageName(p);

				if (!videoName.equals("")) {
					Date date = new Date();
					String videoPath = videosFile + File.separator + date.toString() + videoName;
					p.write(videoPath);
					
					String retPath = VIDEO_UPLOAD_DIRECTORY + File.separator + date.toString() + videoName;
					
					/* for debugging */
					System.out.println(videoPath);
					System.out.println(retPath);
					
					return retPath;
				}
				else
					return "";
			}
		}
		
		return "";
	}
	
	/* source: https://stackoverflow.com/questions/43813392/how-to-get-the-name-of-the-file-which-i-want-to-upload-using-multipart */
	private static String getImageName(javax.servlet.http.Part part) {
		String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
	}
	
}
