package cn.yerenping;


import cn.yerenping.context.ContextGUIAndService;
import cn.yerenping.dao.MemberDao;
import cn.yerenping.dao.daoImpl.MemberDaoImpl;
import cn.yerenping.service.serviceImpl.MemberServiceImpl;
import cn.yerenping.service.MemberService;
import cn.yerenping.view.MyFrame;

import java.io.File;
import java.net.URL;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping
 * @version: 1.0
 */
public class Start {

    public static void main(String[] args) {

        //创建DAO层
        MemberDao memberDaoImpl = new MemberDaoImpl();
        //创建Service层
        MemberService memberService = new MemberServiceImpl(memberDaoImpl);
        //创建上下连接器 -传入service
        ContextGUIAndService content = new ContextGUIAndService(memberService);
        //创建界面
        MyFrame frame = new MyFrame(content);
        //设置界面到上下连接器里
        content.setFrame(frame);
        content.start();
        Start s = new Start();

    }
}
