package com.mrhc.cron.service.impl;

import com.mrhc.cron.controller.CronController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Scheduler {
	private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);
	
	@Autowired 
	CronController cronController;
	
	@Scheduled(cron = "0 */5 08-18 * * MON-FRI", zone = "CST")
	public void helloWorld() {
		LOG.info("helloWorld.- executing Scheduler 1");
		cronController.helloWorld();
	}
	
	@Scheduled(cron = "0 25 16 * * ?")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("cronJobSch01.- Java cron job expression:: " + strDate);
	   }
	
	// initialDelay = 3 second.
    // fixedDelay = 2 second.
    @Scheduled( initialDelay = 3 * 1000, fixedDelay = 2 * 1000)
    public void writeCurrentTime() {
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String nowString = sdf.format(now);
        System.out.println("writeCurrentTime.- Now is: "+ nowString);        
    }
    
    @Scheduled( initialDelay = 3 * 1000, fixedRate = 2 * 1000)
    public void writeCurrentTime2() {
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String nowString = sdf.format(now);
        System.out.println("writeCurrentTime2.- Now is: "+ nowString);        
    }
	
}
