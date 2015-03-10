package tss.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import tss.dao.CourseDao;
import tss.model.Course;
import tss.service.ExcelService;

public class ExcelServiceImpl implements ExcelService {
	private CourseDao courseDao;
	
	@Override
	public ArrayList<Course> getCourseList() {
		ArrayList<Course> courseList = courseDao.getCourseList();
		ArrayList<Course> result = new ArrayList<Course>();
		
		if (courseList == null){
			return null;
		}
		else{
			for (int i = 0; i < courseList.size(); i++){
				Date endDate = courseDao.getEndDate(courseList.get(i).getSemester());
				if (endDate != null){
					if (this.calculateDayDiff(endDate, new Date()) <= 0){
						result.add(courseList.get(i));
					}
				}
			}
			return result;
		}
	}
	
	private long calculateDayDiff(Date dateOne, Date dateTwo) {
		// 计算时间差
		long diff = -1;

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			// 获得两个时间的毫秒时间差异
			diff = sdf.parse(sdf.format(dateOne)).getTime()
					- sdf.parse(sdf.format(dateTwo)).getTime();
			return diff;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

}
