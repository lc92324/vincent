package com.example.demo.Task;

import com.example.demo.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class Task {





//    // 17165625790
//    @Async("taskExecutor")
//    public List<Message> doTaskOne()  {
//        log.info("开始做任务一");
//        return scanHtml(15,"17165625790");
//    }
//
//
    //17034662088
    @Async("taskExecutor")
    public List<Message> doTaskTwo()  {
        log.info("开始做任务二");
        return scanHtml(11,"17034662088","17034662088");
    }


    //19965412404
//    @Async("taskExecutor")
//    public List<Message> doTaskThr()  {
//        log.info("开始做任务二");
//        return scanHtml(1,"19965412404");
//    }

//    //17124267535
//    @Async("taskExecutor")
//    public List<Message> doTaskThr()  {
//        log.info("开始做任务二");
//        return scanHtml(5,"17124267535");
//    }
    //17124267519
    @Async("taskExecutor")
    public List<Message> doTaskThr()  {
        log.info("开始做任务二");
        return scanHtml(7,"17124267519","17124267519");
    }
    //17157721142
    @Async("taskExecutor")
    public List<Message> doTaskFour()  {
        log.info("开始做任务二");
        return scanHtml(17,"17157721142","17157721142");
    }


    int num = 100;



//    //17127290867
//    @Async("taskExecutor")
//    public List<Message> doTaskFour()  {
//        log.info("开始做任务二");
//        return scanHtml(3,"17127290867");
//    }





    private List<Message> scanHtml(int page, String phone,String taskName){
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                list.addAll(getURLInfo("https://www.pdflibr.com/SMSContent/"+page+"?page="+i,phone,taskName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }



    public List<Message> getURLInfo(String urlInfo, String phone,String taskName) throws Exception {
        //读取目的网页URL地址，获取网页源码
        URL url = new URL(urlInfo);
        HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            //这里是对链接进行处理
            line = line.replaceAll("</?a[^>]*>", "");
            //这里是对样式进行处理
            line = line.replaceAll("<(\\w+)[^>]*>", "<$1>");
            sb.append(line);
        }
        is.close();
        br.close();
        //获得网页源码
        return getDataStructure(sb.toString().trim(),phone, taskName);
    }


    private  List<Message> getDataStructure(String str,String phone,String taskName) {
        //运用正则表达式对获取的网页源码进行数据匹配，提取我们所要的数据，在以后的过程中，我们可以采用httpclient+jsoup,
        //现在暂时运用正则表达式对数据进行抽取提取
        String regex="<tr>\\s*<td>(.*?)</td>\\s*<td>(.*?)</td>\\s*<td>(.*?)</td>\\s*<td>\\s*<time>(.*?)</time>\\s*</td>\\s*</tr>";
        Pattern proInfo =Pattern.compile(regex);
        String[] info = str.split("</tbody>");
        List<Message> list = new ArrayList<Message>();
        Message p = null;
        int index = 1;
        for (String s : info) {
            if(index == 1 || index == 3){
                index ++ ;
                continue;
            }
            for (int i = 0; i < 20; i++) {
                if(i != 0){
                    s = s.replace(str,"");
                }
                Matcher m = proInfo.matcher(s);
//                str =  m.group();
                if (m.find()) {
                    p = new Message();
                    //设置短信序号
                    p.setNum( m.group(1).trim().replace(" ", ""));
                    //设置手机号码
                    p.setNumber(m.group(2).trim().replace(" ", ""));
                    //设置短信内容
                    p.setContent(m.group(3).trim().replace(" ", ""));
                    //设置短信时间
                    p.setDate(m.group(4).trim().replace(" ", ""));
                    p.setPhone(phone);
                    list.add(p);
                    str =  m.group();
                }

            }

        }
//        //这里对集合里面不是我们要提取的数据进行移除
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getContent()+list.get(i).getDate()+"--------"+taskName);
        }
        return list;
    }
}
