package com.zyl.utils;

import com.zyl.pojo.QueryDataVo;
import com.zyl.pojo.RsBean;
import com.zyl.pojo.Smoke;
import com.zyl.pojo.Wine;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * @创建人 张亚玲
 * @创建时间 2020/4/16 0016
 * @描述
 **/
public class DataVoUtils {

    public static QueryDataVo parseStr1(String str1){
        QueryDataVo vo = null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             *
               */
            document = DocumentHelper.parseText(str1);
            root = document.getRootElement();
            // *document节点也就是一个window，一个document，
            //                * element节点：指示的是elements为其子节点
            //                * 文本节点：内容为纯文本的节点
            //                * attr节点：指示的是属性，并不常用
            String uname = root.elementText("UNAME");

            String pwd = root.elementText("PWD");
            String code = root.elementText("CODE");
            System.out.println(uname + "="+pwd + "=" +code);//输出 路飞=1234=01
            vo = new QueryDataVo(uname,pwd,code);
            return vo;
        } catch (DocumentException e) {
            return null;
        }
    }

    public static String parseStr2(String str2) {
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             *
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            // *document节点也就是一个window，一个document，
            //                * element节点：指示的是elements为其子节点
            //                * 文本节点：内容为纯文本的节点
            //                * attr节点：指示的是属性，并不常用
            String cardno = root.elementText("CARDNO");
            System.out.println(cardno);//输出 xx123001
            return cardno;
        } catch (DocumentException e) {
            return null;
        }
    }

    public static String parseXml(String code, RsBean rsBean) {
        String rsstr = "";
        if (rsBean!=null){
            rsstr+="<CONTENT>" +
                    " <CARDNO>"+rsBean.getCardno()+"</CARDNO>" +
                    " <MADEDATE>"+rsBean.getMadedate()+"</MADEDATE>" +
                    " <ADDRESS>"+rsBean.getAddress()+"</ADDRESS>" +
                    " <NAME>"+rsBean.getName()+"</NAME>" +
                    " <PRICE>"+rsBean.getPrice()+"</PRICE>";
            //判断是否为酒水，如若有的话加上vol字段
                if("02".equals(code)){
                    rsstr+=" <VOL>"+rsBean.getVol()+"</VOL>";
                }
                rsstr+=" </CONTENT>";
        }
        return rsstr;
    }

    public static Smoke ParseStr2Smoke(String str2) {
        Smoke smoke = null;
        Document document = null;
        Element root = null;
        try {
            /**
             * 这个地方报异常，就是xml解析失败
             *
             */
            document = DocumentHelper.parseText(str2);
            root = document.getRootElement();
            // *document节点也就是一个window，一个document，
            //                * element节点：指示的是elements为其子节点
            //                * 文本节点：内容为纯文本的节点
            //                * attr节点：指示的是属性，并不常用
            String cardno = root.elementText("CARDNO");
            String madedate = root.elementText("MADEDATE");
            String address = root.elementText("ADDRESS");
            String price = root.elementText("PRICE");
            String name = root.elementText("NAME");
            smoke = new Smoke(cardno, madedate, address, price, name);
            return smoke;
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
        public static Wine ParseStr2SWine(String str2) {

            Wine wine = null;
            Document document = null;
            Element root = null;
            try {
                /**
                 * 这个地方报异常，就是xml解析失败
                 *
                 */
                document = DocumentHelper.parseText(str2);
                root = document.getRootElement();
                // *document节点也就是一个window，一个document，
                //                * element节点：指示的是elements为其子节点
                //                * 文本节点：内容为纯文本的节点
                //                * attr节点：指示的是属性，并不常用
                String cardno = root.elementText("CARDNO");
                String madedate = root.elementText("MADEDATE");
                String address = root.elementText("ADDRESS");
                String price = root.elementText("PRICE");
                String name = root.elementText("NAME");
                String vol = root.elementText("VOL");
                wine = new Wine(cardno,madedate,address,price,name,vol);
                return wine;
            } catch (DocumentException e) {
                e.printStackTrace();
                return null;
            }
    }
}
