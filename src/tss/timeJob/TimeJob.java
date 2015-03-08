package tss.timeJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import tss.service.TimeJobService;
import tss.service.impl.TimeJobServiceImpl;

public class TimeJob extends QuartzJobBean {
	private TimeJobService timeJobService;

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
//		timeJobService.updateStudentMessage();
//		System.out.println("自动检测教学课程中");
	}


	public TimeJobService getTimeJobService() {
		return timeJobService;
	}


	public void setTimeJobService(TimeJobService timeJobService) {
		this.timeJobService = timeJobService;
	}

}
