package cn.yerenping.data;

import cn.yerenping.dao.MemberDao;
import cn.yerenping.pojo.Member;
import cn.yerenping.utils.ObjectRWUtil;

import java.io.File;

/**
 *  ģ�����ݿ⣨�����ݴ��ļ��н��ж�д��
 *
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.data
 * @version: 1.0
 */
public class MemberData {
    static {
        Member[] members = new Member[]{
                new Member(1001,"Ҷ��ƽ",'��',"19979243462","��������","yerenping@aliyun.com") ,
                new Member(1002,"�����Ȱ�",'Ů',"19979243463","�½�����","dlrb@aliyun.com") ,
                new Member(1003,"�����",'��',"19979243464","��������","sseg@aliyun.com")
        };
        String filePath = "src";
        String fileName = "members.obj";
        File file = new File(filePath + "/" + fileName);
        //��������ļ������ڣ���ȥ�����ļ�
        if(!file.exists()){
            ObjectRWUtil.writeObject(members,filePath,fileName);
        }
    }

    /**
     * ���ļ��ж�ȡ
     * @return
     */
    public static Member[] reader(){
        return (Member[]) ObjectRWUtil.readObject("src","members.obj");
    }

    /**
     * д���ļ�
     * @param members
     */
    public static void writer(Member[] members){
        ObjectRWUtil.writeObject(members,"src","members.obj");
    }


}
