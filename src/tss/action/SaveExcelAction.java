package tss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import tss.model.Course;
import tss.service.SystemService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SaveExcelAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7077579038751900276L;
	private SystemService systemService;
	private String url ;  
    private String fileName;  
    
    @Override  
    public String execute() throws Exception {  
		this.url = "/Users/uploadFiles/courseData/" + request.getParameter("courseId") + ".xls";
		this.createExcel();
    	File file = new File(this.url);
    	if (file.exists()){
    		return SUCCESS;
    	}
    	else{
    		return ERROR;
    	}
    }
  
    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
    public InputStream getDownloadFile() throws Exception  
    {  
    	try{
    		File file = new File(this.url);
    		this.fileName = "";
    		InputStream is = new FileInputStream(file);  
    		String[] temp = this.url.split("/");
    		this.fileName = temp[temp.length-1]; 
    		return is;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }  
      
	public void createExcel() throws WriteException, IOException {
		String courseId = request.getParameter("courseId");
		WritableWorkbook workbook = null;
		OutputStream os = null;
		try {
			this.url = "/Users/uploadFiles/courseData/" + request.getParameter("courseId") + ".xls";
			File file = new File(this.url);
			os = new FileOutputStream(file);
			// 创建工作薄
			workbook = Workbook.createWorkbook(os);
			// 创建新的一页
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
			
			String teacherName = systemService.getTeacherName(courseId);
			Course course = systemService.getCourseInfo(courseId);
			ArrayList<String> taNameList = systemService.getTaNameList(courseId);
			ArrayList<String> stuNameList = systemService.getStudentName(courseId);
			
			// 第一行
			Label courseIdLabel = new Label(0, 0, course.getCourseId());
			Label courseNameLabel = new Label(1, 0, course.getCourseName());
			Label semesterLabel = new Label(2, 0, course.getSemester());
			sheet.addCell(courseIdLabel);
			sheet.addCell(courseNameLabel);
			sheet.addCell(semesterLabel);
			
			// 第二行
			Label courseDescriptionLabel = new Label(0, 1, course.getDescription());
			sheet.addCell(courseDescriptionLabel);

			// 第三行
			sheet.addCell(new Label(0, 2, "教师名:"));
			Label teacherNameLabel = new Label(1, 2, teacherName);
			sheet.addCell(teacherNameLabel);
			if (taNameList != null){
				sheet.addCell(new Label(2, 2, "助教:"));
				
				for (int i = 0; i < taNameList.size(); i++){
					sheet.addCell(new Label(i+3, 2, taNameList.get(i)));
				}
			}
			
			// 后面的学生信息
			if (stuNameList != null){
				for (int i = 0; i < stuNameList.size(); i++){
					sheet.addCell(new Label(0, i+3, "学生名:"));
					sheet.addCell(new Label(1, i+3, stuNameList.get(i)));
					sheet.addCell(new Label(2, i+3, "作业平均分"));
					sheet.addCell(new Label(3, i+3, "" + systemService.getStudentAverageGrade(stuNameList.get(i))));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			os.close();
		}

	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	public String getFileName() {  
        return fileName;  
    }  
  
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 

}