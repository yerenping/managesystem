package cn.yerenping.dao.daoImpl;

import cn.yerenping.dao.MemberDao;
import cn.yerenping.data.MemberData;
import cn.yerenping.pojo.Member;

import java.util.Arrays;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.dao.daoImpl
 * @version: 1.0
 */
public class MemberDaoImpl implements MemberDao {

    @Override
    public Member[] selectAllMemberDao() {
        return MemberData.reader();
    }

    @Override
    public Member selectByNameDao(String name) {
        Member[] members = selectAllMemberDao();
        Member m = null;
        for (Member member : members) {
            if (member.getName().equals(name)) {
                m = member;
            }
        }
        return m;
    }

    @Override
    public int selectByMidDao(int mid) {
        Member[] members = selectAllMemberDao();
        int index = -1;
        for (int i = 0; i < members.length; i++) {
            if (members[i].getMid() == mid) {
                //将数组下标传给index
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean insertMemberDao(Member member) {
        //获取所有成员
        Member[] members = selectAllMemberDao();
        //判断该成员是否已存在或者重名，不存在则可添加
        int i = selectByMidDao(member.getMid());
        //通过用户名获取member
        Member m = selectByNameDao(member.getName());
        if (i == -1 && m == null) {
            // 数组扩容
            members = Arrays.copyOf(members, members.length + 1);
            // 添加上去
            members[members.length - 1] = member;
            // 重新写入文件
            MemberData.writer(members);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByMemberDao(Member member) {
        //获取所有成员
        Member[] members = selectAllMemberDao();
        /**
         * 1、存在该成员
         * 2、成员名字不重复
         * 符合上述两点才能修改
         */
        int i = selectByMidDao(member.getMid());
        //通过成员名获取member
        Member m = selectByNameDao(member.getName());
        if (i != -1 && m == null) {
            members[i] = member;
            // 重新写入文件
            MemberData.writer(members);
            return true;
        }
        //可能找不到用户，也可能重名了
        return false;
    }

    @Override
    public boolean deleteByMidDao(int mid) {
        //获取所有成员
        Member[] members = selectAllMemberDao();
        //判断该成员是否存在，存在即可删除
        int i = selectByMidDao(mid);
        if (i != -1) {
            Member[] membersTmp = new Member[members.length];
            System.arraycopy(members, 0, membersTmp, 0, i);
            System.arraycopy(members, i + 1, membersTmp, i, members.length - 1 - i);
            membersTmp = Arrays.copyOf(membersTmp, members.length - 1);
            // 重新写入文件
            MemberData.writer(membersTmp);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByNameDao(String name) {
        //通过用户名获取member
        Member m = selectByNameDao(name);
        if (m != null) {
            // 通过Mid删除
            return deleteByMidDao(m.getMid());
        }
        return false;
    }
}
