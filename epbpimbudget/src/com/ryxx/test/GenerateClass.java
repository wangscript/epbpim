package com.ryxx.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateClass {
	private static String filenameTemp;

	public static void main(String[] args) {
		GenerateClass.generateServiceImplClasses();
	}

	public static String generateTestCase() {
		File path = new File(
				"C:\\guan\\project\\sp-b2cv1\\src\\com\\spshop\\model");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 1; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).toString().indexOf("Type") != -1
						|| list.get(i).toString().equals("ShopMenu")
						|| list.get(i).toString().indexOf("Query") != -1
						|| list.get(i).toString().indexOf("FeedBack") != -1) {
					continue;
				} else {
					String str = list.get(i).toString();
					String serviceName = str.replace(str.charAt(0),
							(char) (str.charAt(0) + 32));
					builder.append("\t\t" + str + "Service " + serviceName
							+ "Service = ServiceFactory.getService(" + str
							+ "Service.class);\n");
					builder.append("\t\t" + str + " " + serviceName + " = new "
							+ str + "();\n");
					builder.append("\t\t" + serviceName + "Service.save("
							+ serviceName + ");\n");
				}
			}
		} catch (Exception e) {

		}
		return builder.toString();
	}

	public static String generateSpringService() {
		File path = new File(
				"C:\\guan\\project\\sp-b2cv1\\src\\com\\spshop\\model");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 1; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).toString().indexOf("Type") != -1
						|| list.get(i).toString().equals("ShopMenu")
						|| list.get(i).toString().equals("User")
						|| list.get(i).toString().indexOf("Query") != -1
						|| list.get(i).toString().indexOf("FeedBack") != -1) {
					continue;
				} else {
					builder.append("\t<bean id=\"com.spshop.service.intf."
							+ list.get(i)
							+ "Service.target\" class=\"com.spshop.service.impl."
							+ list.get(i) + "ServiceImpl\">\n");
					builder.append("\t</bean>\n");
					builder.append("\t<bean id=\"com.spshop.service.intf."
							+ list.get(i)
							+ "Service\" parent=\"transactionBase\">\n");
					builder.append("\t\t<property name=\"target\" ref=\"com.spshop.service.intf."
							+ list.get(i) + "Service.target\" />\n");
					builder.append("\t</bean>\n\n");
				}
			}
		} catch (Exception e) {

		}
		return builder.toString();
	}

	public static String generateSpringDAO() {
		File path = new File(
				"C:\\guan\\project\\sp-b2cv1\\src\\com\\spshop\\model");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 1; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).toString().indexOf("Type") != -1
						|| list.get(i).toString().equals("ShopMenu")
						|| list.get(i).toString().equals("User")
						|| list.get(i).toString().indexOf("Query") != -1
						|| list.get(i).toString().indexOf("FeedBack") != -1) {
					continue;
				} else {
					builder.append("\t<bean id=\"com.spshop.dao.intf."
							+ list.get(i) + "DAO\"\n");
					builder.append("\t    class=\"com.spshop.dao.impl."
							+ list.get(i) + "DAOImpl\">\n");
					builder.append("\t\t<property name=\"sessionFactory\" ref=\"sessionFactory\"></property>\n");
					builder.append("\t</bean>\n\n");
				}
			}
		} catch (Exception e) {

		}
		return builder.toString();
	}

	public static void generateDAOClasses() {
		File path = new File(
				"C:\\guan\\mypractice\\epbpim\\src\\com\\ryxx\\bpim\\entity");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 0; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				String str = "C:\\guan\\test\\" + list.get(i) + "DAO.java";
				GenerateClass.creatTxtFile(str);
				builder.append("package com.ryxx.bpim.dao;\n\n");
				builder.append("import com.ryxx.bpim.entity." + list.get(i)
						+ ";\n\n");
				builder.append("public interface " + list.get(i)
						+ "DAO extends BaseDAO<" + list.get(i)
						+ ", Long> {\n\n");
				builder.append("}");
				GenerateClass.writeTxtFile(builder.toString(), str);
				builder = new StringBuilder();
			}
		} catch (Exception e) {

		}
	}

	public static void generateDAOImplClasses() {
		File path = new File(
				"C:\\guan\\mypractice\\epbpim\\src\\com\\ryxx\\bpim\\entity");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 0; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				String str = "C:\\guan\\test\\" + list.get(i) + "DAOImpl.java";
				GenerateClass.creatTxtFile(str);
				builder.append("package com.ryxx.bpim.dao;\n\n");
				builder.append("import com.ryxx.bpim.entity." + list.get(i)
						+ ";\n\n");
				builder.append("public class " + list.get(i)
						+ "DAOImpl extends AbstractBaseDAO<" + list.get(i)
						+ ", Long> implements " + list.get(i) + "DAO {\n\n");
				builder.append("}");
				GenerateClass.writeTxtFile(builder.toString(), str);
				builder = new StringBuilder();
			}
		} catch (Exception e) {

		}
	}

	public static void generateServiceClasses() {
		File path = new File(
				"C:\\guan\\mypractice\\epbpim\\src\\com\\ryxx\\bpim\\entity");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 1; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}

		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				String str = "C:\\guan\\test\\" + list.get(i) + "Service.java";
				GenerateClass.creatTxtFile(str);
				builder.append("package com.ryxx.bpim.service;\n\n");
				builder.append("import com.ryxx.bpim.dao." + list.get(i)
						+ "DAO;\n\n");
				builder.append("import com.ryxx.bpim.entity." + list.get(i)
						+ ";\n\n");
				builder.append("public interface " + list.get(i)
						+ "Service extends BaseService<" + list.get(i) + ","
						+ list.get(i) + "DAO, Long> {\n\n");
				builder.append("}");
				GenerateClass.writeTxtFile(builder.toString(), str);
				builder = new StringBuilder();
			}
		} catch (Exception e) {

		}
	}

	public static void generateServiceImplClasses() {
		File path = new File(
				"C:\\guan\\mypractice\\epbpim\\src\\com\\ryxx\\bpim\\entity");
		File[] files = path.listFiles();
		List list = new ArrayList();
		for (int i = 1; i < files.length; i++) {
			String str = files[i].getName();
			list.add(str.replace(".java", ""));
		}
		
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < list.size(); i++) {
				String str = "C:\\guan\\test\\" + list.get(i) + "ServiceImpl.java";
				GenerateClass.creatTxtFile(str);
				builder.append("package com.ryxx.bpim.service;\n\n");
				builder.append("import com.ryxx.bpim.dao." + list.get(i)
						+ "DAO;\n\n");
				builder.append("import com.ryxx.bpim.entity." + list.get(i)
						+ ";\n\n");
				builder.append("public class " + list.get(i)
						+ "ServiceImpl extends AbstractService<" + list.get(i) + ","
						+ list.get(i) + "DAO, Long> implements " + list.get(i) + "Service {\n\n");
				builder.append("}");
				GenerateClass.writeTxtFile(builder.toString(), str);
				builder = new StringBuilder();
			}
		} catch (Exception e) {

		}
	}

	public static boolean creatTxtFile(String name) throws IOException {
		boolean flag = false;
		File filename = new File(name);
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * 写文件
	 * 
	 * @param newStr
	 *            新内容
	 * @throws IOException
	 */
	public static boolean writeTxtFile(String newStr, String fileName)
			throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		boolean flag = false;
		String filein = newStr + "\r\n";
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
			// 文件路径
			File file = new File(fileName);
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();

			// 保存该文件原有的内容
			for (int j = 1; (temp = br.readLine()) != null; j++) {
				buf = buf.append(temp);
				// System.getProperty("line.separator")
				// 行与行之间的分隔符 相当于“\n”
				buf = buf.append(System.getProperty("line.separator"));
			}
			buf.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			pw.flush();
			flag = true;
		} catch (IOException e1) {
			// TODO 自动生成 catch 块
			throw e1;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return flag;
	}

}
