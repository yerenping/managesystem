package cn.yerenping.data;

import cn.yerenping.dao.MemberDao;
import cn.yerenping.pojo.Member;
import cn.yerenping.utils.ObjectRWUtil;

import java.io.File;

/**
 *  模拟数据库（将数据从文件中进行读写）
 *
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.data
 * @version: 1.0
 */
public class MemberData {
    static {
        Member[] members = new Member[]{
                new Member(1001,"叶仁平",'男',"19979243462","江西吉安","yerenping@aliyun.com") ,
                new Member(1002,"迪丽热巴",'女',"19979243463","新疆哈密","dlrb@aliyun.com") ,
                new Member(1003,"宋祖儿",'男',"19979243464","北京东城","sseg@aliyun.com")
        };
        String filePath = "src";
        String fileName = "members.obj";
        File file = new File(filePath + "/" + fileName);
        //如果对象文件不存在，才去创建文件
        if(!file.exists()){
            ObjectRWUtil.writeObject(members,filePath,fileName);
        }
    }

    /**
     * 从文件中读取
     * @return
     */
    public static Member[] reader(){
        return (Member[]) ObjectRWUtil.readObject("src","members.obj");
    }

    /**
     * 写入文件
     * @param members
     */
    public static void writer(Member[] members){
        ObjectRWUtil.writeObject(members,"src","members.obj");
    }


}
