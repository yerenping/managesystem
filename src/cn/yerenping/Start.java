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
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping
 * @version: 1.0
 */
public class Start {

    public static void main(String[] args) {

        //����DAO��
        MemberDao memberDaoImpl = new MemberDaoImpl();
        //����Service��
        MemberService memberService = new MemberServiceImpl(memberDaoImpl);
        //�������������� -����service
        ContextGUIAndService content = new ContextGUIAndService(memberService);
        //��������
        MyFrame frame = new MyFrame(content);
        //���ý��浽������������
        content.setFrame(frame);
        content.start();
        Start s = new Start();

    }
}
