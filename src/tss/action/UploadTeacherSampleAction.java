package tss.action;

import java.io.File;
import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class UploadTeacherSampleAction extends BaseAction {

	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private String alterstr;


	public String getAlterstr() {
		return alterstr;
	}

	public void setAlterstr(String alterstr) {
		this.alterstr = alterstr;
	}

	public String execute() throws Exception {
		String realpath = "/Users/uploadFiles/teacherSample";
		System.out.println("realpath: " + realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "文件上传成功");
			alterstr="upload successfully!";
			return SUCCESS;
		}
		alterstr="upload failed";
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

	
}