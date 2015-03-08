package tss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;  

import org.apache.struts2.ServletActionContext;  
  
  



import com.opensymphony.xwork2.ActionSupport;  
  
//文件下载  
public class TaDownloadStuAssignment extends ActionSupport{  
      
    /**
	 * 
	 */
	private static final long serialVersionUID = -6351680477834287909L;

	private String url ;  
  
    private String fileName;  
  
    public String getFileName() {  
        return fileName;  
    }  
  
    public void setFileName(String fileName) {  
        this.fileName = fileName;  
    }  
  
    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
    public InputStream getDownloadFile() throws Exception  
    {  
    	System.out.println("~~~" + this.url + "!!!!!!");
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
      
    @Override  
    public String execute() throws Exception {  
    	File file = new File(this.url);
    	if (file.exists()){
    		return SUCCESS;
    	}
    	else{
    		return ERROR;
    	}
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}  
  
}  