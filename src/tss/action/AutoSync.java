package tss.action;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.net.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AutoSync extends BaseAction {
	private InputStream inputStream;
	private String hiddenXMLTmpBox;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getHiddenXMLTmpBox() {
		return hiddenXMLTmpBox;
	}

	public void setHiddenXMLTmpBox(String tmpBox) {
		hiddenXMLTmpBox = tmpBox;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute() {
		try {
			/* TODO: Parse dirtyTableXML and save */
			String dirtyTableXML = URLDecoder.decode(hiddenXMLTmpBox, "UTF-8");
			System.out.println(dirtyTableXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StringBuilder xmlText = new StringBuilder();
		xmlText.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xmlText.append("<ajax-response>");
		xmlText.append("</ajax-response>");
		String strXMLText = xmlText.toString();
		Charset cset = Charset.forName("utf-8");
		ByteBuffer b = cset.encode(strXMLText);
		this.inputStream = new ByteArrayInputStream(b.array());

		return SUCCESS;
	}

}