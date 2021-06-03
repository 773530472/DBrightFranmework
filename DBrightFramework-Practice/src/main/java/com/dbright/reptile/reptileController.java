package com.dbright.reptile;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/csdn")
public class reptileController {

    @RequestMapping(value = "/searchEmResources", method = RequestMethod.GET)
    @ResponseBody
//    @Scheduled(cron = "0 */2 * * * ?")
    public Map<String,Object> searchEmResources() throws IOException, InterruptedException {
        Map<String,Object> resultMap = new HashMap<>();
        UrlCrawBoke.reptileFun();
        resultMap.put("status","访问成功!");
        System.out.println("1111");
        return resultMap;
    }
}
