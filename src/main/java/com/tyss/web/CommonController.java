package com.tyss.web;

import com.tyss.beans.CommonResponseBean;
import org.jboss.logging.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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

    /**
     * 数字转人民币
     */
    @RequestMapping(value = "/getMoney")
    public CommonResponseBean getRMB(@RequestParam(value = "money") String money) {
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        if (money.length() > 9 || money.length() < 1) {
            commonResponseBean.setCode(-1);
            commonResponseBean.setMsg("金额超限");
            return commonResponseBean;
        }
        int moneyFormate = Integer.parseInt(money);
        char[] data = new char[] { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
        char[] units = new char[] { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿' };
        StringBuffer sbf = new StringBuffer();
        int unit = 0;
        while (moneyFormate != 0) {
            sbf.insert(0, units[unit++]);
            int number = moneyFormate % 10;
            sbf.insert(0, data[number]);
            moneyFormate /= 10;
        }
        commonResponseBean.setCode(1);
        commonResponseBean.setMsg(sbf.toString());
        return commonResponseBean;
    }

}
