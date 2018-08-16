package com.weatherdata.collection.cimiss;

import com.weatherdata.collection.cimiss.scheduler.CollDataScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CimissApplicationTests {

	@Autowired
	private CollDataScheduler collDataScheduler;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testTaskCorn(){
		collDataScheduler.startJob("00 48 10 12 08 ? 2018","TASK_COLLECTION","TEST","com.weatherdata.collection.cimiss.TestScheduler" );
	}

}
