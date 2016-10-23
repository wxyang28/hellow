package com.lgs.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.enterprise.deploy.spi.status.ProgressEvent;
import javax.enterprise.deploy.spi.status.ProgressListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException {
		         //上传文件的保存目录
		         String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		         //上传文件时生成的临时文件保存目录
		         String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		         File tmpFile = new File(tempPath);
		         if (!tmpFile.exists()) {
		        
		           tmpFile.mkdir();
		         }
		          
		         //消息提示
		         String message = "";
		         try{
		          
		           //1.使用一个DiskFileItemFactory工厂
		           DiskFileItemFactory factory = new DiskFileItemFactory();
		           //设置缓冲区的大小为100KB
		           factory.setSizeThreshold(1024*100);
		           //设置上传文件时生成的临时文件的保存目录
		           factory.setRepository(tmpFile);
		           //2.创建一个文件上传解析器
		           ServletFileUpload upload = new ServletFileUpload(factory);
		           //监听文件上传进度
		           upload.setProgressListener(
		        		   new org.apache.commons.fileupload.ProgressListener() {
		        			  
		      		             public void update(long pBytesRead, long pContentLength, int arg2) {
		      		               System.out.println("文件大小为:" +
		      		             pContentLength + ",当前已处理:" + pBytesRead);	
		      		             }});
		            //设置上传中文编码
		           upload.setHeaderEncoding("utf-8"); 
		           //3.判断提交上来的数据是否是上传表单的数据
		           if(!ServletFileUpload.isMultipartContent(request)){
		             //按传统的方式获取数据
		             return;
		           }
		            
		           //设置上传单个文件的大小的最大值，此处为1MB
		           upload.setFileSizeMax(1024*1024*1024);
		           //设置同时上传多个文件的最大值的和为10MB
		           upload.setSizeMax(1024*1024*1024*10);
		           //4.使用ServletFileUpload解析器上传数据
		           List<FileItem> list = upload.parseRequest(request);
		           for(FileItem item : list){
		             //如果fileitem中封装的是普通输入项的数据
		             if(item.isFormField()){
		               String name = item.getFieldName();
		               //普通输入项的数据的中文乱码问题 
		               String value = item.getString("utf-8");
		               System.out.println(name + "=" + value);
		             }else{
		            	//得到上传文件的名称
		               String filename = item.getName();
		               System.out.println(filename);
		               if(filename==null || filename.trim().equals("")){
		                 continue;
		               }
		               //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
		               filename = filename.substring(filename.lastIndexOf("\\")+1);
		               //得到上传文件 的扩展名
		               String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
		               //可通过文件扩展名类型限制上传文件类型
		               System.out.println("上传文件的扩展名："+fileExtName);
		               //获取item中的上传文件的输入流
		               InputStream in = item.getInputStream();
		               //得到文件保存的名称
		               String saveFilename = makeFileName(filename);
		               //得到文件保存的目录
		               String realSavePath = makePath(saveFilename, savePath);
		               //创建一个文件输出流
		               FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
		              //创建一个缓冲区
		               byte buffer[] = new byte[1024];
		               int len;
				       //判断输入流中的数据是否已经读完
		               while((len=in.read(buffer))>0){
		                 //写入指定目录
		                 out.write(buffer, 0, len);
		               }
		               //关闭输入流
		               in.close();
		               //关闭输出流
		               out.close();               
		               item.delete();            
		               message = "文件上传成功！";
		             }
		           }
		         }catch (FileUploadBase.FileSizeLimitExceededException e) {
		           e.printStackTrace();
		           request.setAttribute("message", "单个文件超出最大值！");
		           request.getRequestDispatcher("/message.jsp").forward(request, response);
		           return;
		         }catch (FileUploadBase.SizeLimitExceededException e) {
		           e.printStackTrace();
		           request.setAttribute("message", "总文件超出最大值！");
		           request.getRequestDispatcher("/message.jsp").forward(request, response);
		           return;
		         }catch (Exception e) {
		           message= "文件上传失败！";
		           e.printStackTrace();
		         }
		         request.setAttribute("message",message);
		         request.getRequestDispatcher("/message.jsp").forward(request, response);
		   }
		    
		 
		   private String makeFileName(String filename){ //2.jpg
		     //为上传文件产生一个唯一的文件名
		     return UUID.randomUUID().toString() + "_" + filename;
		   }   
		   
		  private String makePath(String filename,String savePath){
		     //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		     int hashcode = filename.hashCode();
		     int dir1 = hashcode&0xf; //0--15
		     int dir2 = (hashcode&0xf0)>>4; //0-15
		     //构造新的保存目录
		     String dir = savePath + "\\" + dir1 + "\\" + dir2; //upload\2\3 upload\3\5
		     //File既可以代表文件又可以代表目录
		     File file = new File(dir);
		    //如果目录不存在就创建目录
		     if(!file.exists()){
		       file.mkdirs();
		    }
		     return dir;
		   }
		  
		   public void doGet(HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException {
		  
		     doPost(request, response);
		   }


	public void init() throws ServletException {
		// Put your code here
	}

}
