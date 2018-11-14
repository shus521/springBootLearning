package com.tyss.web;

import com.tyss.beans.CommonResponseBean;
import org.jboss.logging.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//一些小工具
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    /**
     * 字符串大小写转换
     * @param input
     * @param type 1大写转小写 2小写转大写
     * @return
     */
    @RequestMapping(value = "/stringToLower", method = RequestMethod.GET)
    public CommonResponseBean stringToLower(@RequestParam(value = "input") String input, @RequestParam(value = "type") Integer type) {
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        if (input.length() < 1) {
            commonResponseBean.setCode(-1);
            commonResponseBean.setMsg("请输入参数");
        }

        if (type == null) {
            type = 1;
        }
        try {
            String resultString = "";
            if (type == 1) {
                resultString = input.toLowerCase();
            } else {
                resultString = input.toUpperCase();
            }
            commonResponseBean.setCode(1);
            commonResponseBean.setMsg(resultString);
        } catch (Exception e) {
            commonResponseBean.setCode(-2);
            commonResponseBean.setMsg("转换错误");
        }
        return commonResponseBean;
    }

}
