package com.zyl.controller;

import com.alibaba.fastjson.JSON;
import com.zyl.pojo.InfoBean;
import com.zyl.pojo.QueryDataVo;
import com.zyl.pojo.User;
import com.zyl.service.UserService1;
import com.zyl.utils.DataVoUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/16 0016
 * @描述
 **/

@RestController
public class TestDataController {

    @Resource
    private UserService1 userService;

    /**
     * 第二个接口了，接收分厂发来的数据
     * @return
     */
    @RequestMapping(value = "/reciDataInterface")
    public String reciDataInterface(String str1,String str2){
        str1 = "<MEG><UNAME>admin</UNAME><PWD>admin</PWD><CODE>01</CODE></MEG>";
        str2 = "<CONTENT><CARDNO>xy00005</CARDNO><MADEDATE>2018-06-02</MADEDATE><ADDRESS>河北秦皇岛</ADDRESS><PRICE>35</PRICE><NAME>小熊猫</NAME></CONTENT>";
        //接收到分厂发来的数据之后，先解析第一个参数
        QueryDataVo parseStr1 = DataVoUtils.parseStr1(str1);
        //如果parseStr1为空，则参数一解析失败
        if(parseStr1==null){
            return "<MEG><CODE>0</CODE><CONTENT>参数1解析失败</CONTENT></MEG>";
        }else {

            //解析成功，判断登录，鉴权(判断有没有资格)
            //参数1解析成功，去登陆
            User user = new User();
            user.setUsername(parseStr1.getUname());
            user.setPassword(parseStr1.getPwd());
            User login = userService.getLogin(user);
            //登录成功或者失败
            if(login==null){
                return "<MEG><CODE>0</CODE><CONTENT>用户名或者密码错误</CONTENT></MEG>";
            }else {
                //登录成功的话，根据参数1解析出来的code去解析参数2
                //code不一样，参数2不一样
                return userService.saveData(parseStr1,str2);
            }
        }
    }

    //1.对应的是无参的get请求
    @RequestMapping(value = "/testGet1")
    public String  testGet1(){
        return "123";
    }

    //2.对应的有参的get方法的2和3测试
    @RequestMapping(value = "/testGet2")
    public String testGet2(String name,Integer age){
        return name+"先生你终于来了，没想到你的年龄竟然"+age+"岁了！";
    }

    //4.对应的无参的post请求
    @RequestMapping(value = "/testpost1",method = RequestMethod.POST)
    public String testpost1(){
        System.out.println(123);
        return "123";
    }

    //5.对应的有参的post请求
    @RequestMapping(value = "/testpost2",method = RequestMethod.POST)
    public String testpost2(String name,Integer age){
        return name+"先生你终于来了，没想到你的年龄竟然"+age+"岁了！";
    }

    //6.对应的对象参数的post请求
    @RequestMapping(value = "/testpost3",method = RequestMethod.POST)
    public String testpost2(@RequestBody InfoBean infoBean){

        return infoBean.getUsername()+"先生我看到你了！"+ JSON.toJSONString(infoBean);
    }

    //7.对应的对象参数的post请求
    @RequestMapping(value = "/testpost4",method = RequestMethod.POST)
    public InfoBean testpost4(@RequestBody InfoBean infoBean){
        infoBean.setUsername(infoBean.getUsername()+"先生我看到你了！");
        return infoBean;
    }

    //8.对应的普通参数加对象参数的post请求
    // POST传递普通参数时，方式与GET一样即可，这里以通过URI获得HttpPost的方式为例。
    @RequestMapping(value = "/testpost5",method = RequestMethod.POST)
    public InfoBean testpost5(@RequestBody InfoBean infoBean,String meaning,Integer flag){
        infoBean.setUsername(infoBean.getUsername()+"先生我看到你了！");
        System.out.println(meaning+flag);
        return infoBean;
    }

    @RequestMapping(value = "/getDateInterface")
    public String getDateInterface(String str1,String str2){
        //这两个参数是别人传递过来的，模拟真实，在开发总部的时候不要考虑分部，按文档来
//        str1="<MEG><UNAME>admin</UNAME><PWD>admin</PWD><CODE>02</CODE></MEG>";
//        str2="<CONTENT><CARDNO>xy0004</CARDNO></CONTENT>";

        QueryDataVo queryDataVo = userService.parseStr1(str1);
            if(queryDataVo==null){
                //第一次对接项目，后续不可能了
                //参数解析失败返回0
                return "<result><MEG><CODE>0</CODE></MEG></result>";
            }else {
                //参数1解析成功，去登陆
                User user = new User();
                user.setUsername(queryDataVo.getUname());
                user.setPassword(queryDataVo.getPwd());
                User login = userService.getLogin(user);

                //判断login是否为空，为空则登录失败，不为空则登录成功
                if(login!=null){
                    //解析成功的话，就去解析参数2
                    String cardNo = userService.parseStr2(str2);
                    //参数2解析成功的话，存到queryDataVo对象中
                    if(cardNo!=null){
                        queryDataVo.setCardno(cardNo);
                        /**
                         * 查询返回，返回的要是空，就是没有查到，如果返回的不是空，则把返回的接口拼成需要的xml
                         * 这边创建总厂的两个库，一个酒水库一个香烟库，对应的实体类等
                         */
                        //queryDataVo里边有code和cardNo来进行查询
                        String rs = userService.getInfo(queryDataVo);
                        if(rs==null||"".equals(rs)){
                            return "<result><MEG><CODE>2</CODE></MEG></result>";
                        }else {
                            System.out.println("<result><MEG><CODE>3</CODE></MEG>"+rs+"</result>");
                            return "<result><MEG><CODE>3</CODE></MEG>"+rs+"</result>";
                        }
                    }else {
                        return "<result><MEG><CODE>0</CODE></MEG></result>";
                    }
                }else {
                    return "<result><MEG><CODE>1</CODE></MEG></result>";
                }
            }
    }

}
