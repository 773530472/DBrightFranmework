package com.dbright.zxing;

import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/xzing")
public class ZxingContoller {

    @RequestMapping(value = "/getErweima", method = RequestMethod.GET)
    @ResponseBody
    public BitMatrix getErweima(@RequestParam Map<String, Object> paramsMap){

        return ZxingTest.orCode(paramsMap);
    }
}
