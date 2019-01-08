package com.tuhui.socialsecurity.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 *
 * @Description : 定时任务
 * @author : lchao
 * @CreateDate : 2019-01-07
 *
 */
@Component("taskJob")
@Slf4j
@EnableScheduling //开启定时任务
public class QuartzTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testTask()  {

    }


}
