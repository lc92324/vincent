package com.example.demo.quartz;

import com.example.demo.Task.Task;
import com.example.demo.domain.Message;
import com.example.demo.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author:   lc
 * Date:     2018/9/7
 * Description:
 */
@Component("taskJob")
@Slf4j
public class QuartzTask {



    @Autowired
    private Task taskExecutor;

    @Autowired
    MessageService messageService;



    //定时更新数据
    //调用存储过程  增加增益数据
    @Scheduled(cron = "0 0/1 * * * ?")
    public void testTask()  {
        messageService.deleteAllInBatch();
        log.info("执行定时任务---------开始！");
        List<Message> list3 = null;
        List<Message> list2 = null;
        List<Message> list4 = null;
        list2= taskExecutor.doTaskTwo();

        list3 = taskExecutor.doTaskThr();
        list4 = taskExecutor.doTaskFour();
        messageService.save(list2);
        messageService.save(list3);
        messageService.save(list4);
        log.info("执行定时任务---------结束！");
    }


}
