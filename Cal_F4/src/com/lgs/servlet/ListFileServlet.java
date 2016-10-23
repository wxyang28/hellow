package com.lgs.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListFileServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ListFileServlet() {
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
		doGet(request, response);
	}

	public void listfile(File file, Map<String, String> map) {
		// ���file����Ĳ���һ���ļ�������һ��Ŀ¼
		if (!file.isFile()) {
			// �г���Ŀ¼�µ������ļ���Ŀ¼
			File files[] = file.listFiles();
			// ����files[]����
			for (File f : files) {
				// �ݹ�
				listfile(f, map);
			}
		} else {

			String realName = file.getName().substring(
					file.getName().indexOf("_") + 1);
			// file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
			map.put(file.getName(), realName);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ϴ��ļ���Ŀ¼
		String uploadFilePath = this.getServletContext().getRealPath(
				"/WEB-INF/upload");
		// �洢Ҫ���ص��ļ���
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// �ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
		listfile(new File(uploadFilePath), fileNameMap);// File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
		// ��Map���Ϸ��͵�listfile.jspҳ�������ʾ
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("/listFile.jsp")
				.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
