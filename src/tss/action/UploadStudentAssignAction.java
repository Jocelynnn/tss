package tss.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import tss.model.Submission;
import tss.service.StudentService;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class UploadStudentAssignAction extends BaseAction {

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private int assignmentId;
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String execute() throws Exception {
		setAssignmentId(Integer.valueOf(request.getParameter("assignmentId")));
		String realpath = "/Users/uploadFiles/studentSubmission";
		System.out.println("realpath: " + realpath);
		if (image != null) {
			// 文件重命名
			String[] temp = this.imageFileName.split("\\.");
			this.imageFileName = request.getParameter("courseId") + "_"
					+ request.getParameter("assignmentNumber") + "_"
					+ request.getSession().getAttribute("username") + "."
					+ temp[temp.length - 1];

			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "文件上传成功");

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();

			System.out.println("!!!" + request.getParameter("submissionId")
					+ "~~~");
			// 保存到数据库submission信息
			if (request.getParameter("submissionId").equals("")) {
				studentService.saveSubmission(new Submission(0, Integer
						.parseInt(request.getParameter("assignmentId")),
						(String) request.getSession().getAttribute("username"),
						studentService.getUserRealname((String) request
								.getSession().getAttribute("username")),
						realpath + "/" + imageFileName, sdf.parse(sdf
								.format(date)), "", -1, "", 1, 1));
			} else {
				studentService.updateSubmission(new Submission(Integer
						.parseInt(request.getParameter("submissionId")),
						Integer.parseInt(request.getParameter("assignmentId")),
						(String) request.getSession().getAttribute("username"),
						studentService.getUserRealname((String) request
								.getSession().getAttribute("username")),
						realpath + "/" + imageFileName, sdf.parse(sdf
								.format(date)), "", -1, "", 1, 1));
			}

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

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	

}