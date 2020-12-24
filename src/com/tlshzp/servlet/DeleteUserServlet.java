package com.tlshzp.servlet;

import com.tlshzp.pojo.Acount;
import com.tlshzp.pojo.BBInfo;
import com.tlshzp.service.AcountService;
import com.tlshzp.service.BBInfoService;
import com.tlshzp.service.UserService;
import com.tlshzp.service.impl.AcountServiceImpl;
import com.tlshzp.service.impl.BBInfoServiceImpl;
import com.tlshzp.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    BBInfoService bis = new BBInfoServiceImpl();
    UserService us = new UserServiceImpl();
    AcountService as = new AcountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long number = Long.parseLong(req.getParameter("number"));
        Acount acount = as.findAcountByNumber(number);
        List<BBInfo> bbInfos = bis.findInfoByNumber(number);
        if (acount.isIdentify())
            req.setAttribute("uu_msg", "管理员用户不可删除");
        else if (bbInfos.size() != 0)
            req.setAttribute("uu_msg", "该用户到目前为止还有书未还，不可删除");
        else {
            int res = us.deleteUserByNumber(number);
            res += as.deleteAcountByNumber(number);
            if (res == 2) req.setAttribute("uu_msg", "删除成功");
            else req.setAttribute("uu_msg", "删除过程中可能产生错误");
        }
        req.getRequestDispatcher("usersManage.jsp").forward(req, resp);
        return;
    }
}
