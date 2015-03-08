package tss.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import tss.model.Assignment;
import tss.service.TeacherService;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class UploadTeacherSampleAction extends BaseAction {

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private TeacherService teacherService;
	private int assignId;



	public String execute() throws Exception {
		String realpath = "/Users/uploadFiles/teacherSample";
		System.out.println("realpath: " + realpath);
		if (image != null) {
//			文件重命名
			String[] temp = this.imageFileName.split("\\.");
			this.imageFileName = "Sample_"+request.getParameter("courseId") + "_"
					+ request.getParameter("assignNumber") + "_"
					+ request.getSession().getAttribute("username") + "."
					+ temp[temp.length - 1];
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "文件上传成功");
			
//			save to database
			assignId=Integer.valueOf(request.getParameter("assignmentId"));
			Assignment a=teacherService.getAssignment(assignId);
			a.setSample(realpath + "/" + imageFileName);
			teacherService.updateAssignment(a);
			return SUCCESS;
		}
		return ERROR;
		
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	
}