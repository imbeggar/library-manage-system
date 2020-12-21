package com.tlshzp.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-contro", "no-cache");
        response.setHeader("expries", "0");

        //1.在内存中创建一个长80，宽30的图片，默认黑色背景
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.设置画笔
        Graphics graphics = image.getGraphics();

        //3.填充图片（左上方的学院xy坐标和右下方的xy坐标）
        graphics.fillRect(0, 0, width, height);

        //4.产生4个随机验证码
        String checkCode = getCheckCode();

        //5.将验证码放入HttpSession中
        request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);

        //6.设置画笔颜色为黄色
        graphics.setColor(Color.DARK_GRAY);

        //7.设置字体大小
        graphics.setFont(new Font("斜体", Font.BOLD, 24));

        //8.向图片上写入验证码
        graphics.drawString(checkCode, 15, 25);
        /*
        9.将内存中的图片输出到浏览器
        参数一：图片对象
        参数二：图片的格式，jpg，png。。。
        参数三：图片输出到哪里
         */
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    String getCheckCode(){
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTabcdefghijklmnopqrst";
        int size = base.length();
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < 4; i++){
            //产生0——size-1的随机数
            int index = random.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            stringBuffer.append(c);
        }

        return stringBuffer.toString();
    }
}
