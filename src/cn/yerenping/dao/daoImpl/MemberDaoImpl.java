package cn.yerenping.dao.daoImpl;

import cn.yerenping.dao.MemberDao;
import cn.yerenping.data.MemberData;
import cn.yerenping.pojo.Member;

import java.util.Arrays;

/**
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
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
                //�������±괫��index
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean insertMemberDao(Member member) {
        //��ȡ���г�Ա
        Member[] members = selectAllMemberDao();
        //�жϸó�Ա�Ƿ��Ѵ��ڻ���������������������
        int i = selectByMidDao(member.getMid());
        //ͨ���û�����ȡmember
        Member m = selectByNameDao(member.getName());
        if (i == -1 && m == null) {
            // ��������
            members = Arrays.copyOf(members, members.length + 1);
            // �����ȥ
            members[members.length - 1] = member;
            // ����д���ļ�
            MemberData.writer(members);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByMemberDao(Member member) {
        //��ȡ���г�Ա
        Member[] members = selectAllMemberDao();
        /**
         * 1�����ڸó�Ա
         * 2����Ա���ֲ��ظ�
         * ����������������޸�
         */
        int i = selectByMidDao(member.getMid());
        //ͨ����Ա����ȡmember
        Member m = selectByNameDao(member.getName());
        if (i != -1 && m == null) {
            members[i] = member;
            // ����д���ļ�
            MemberData.writer(members);
            return true;
        }
        //�����Ҳ����û���Ҳ����������
        return false;
    }

    @Override
    public boolean deleteByMidDao(int mid) {
        //��ȡ���г�Ա
        Member[] members = selectAllMemberDao();
        //�жϸó�Ա�Ƿ���ڣ����ڼ���ɾ��
        int i = selectByMidDao(mid);
        if (i != -1) {
            Member[] membersTmp = new Member[members.length];
            System.arraycopy(members, 0, membersTmp, 0, i);
            System.arraycopy(members, i + 1, membersTmp, i, members.length - 1 - i);
            membersTmp = Arrays.copyOf(membersTmp, members.length - 1);
            // ����д���ļ�
            MemberData.writer(membersTmp);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByNameDao(String name) {
        //ͨ���û�����ȡmember
        Member m = selectByNameDao(name);
        if (m != null) {
            // ͨ��Midɾ��
            return deleteByMidDao(m.getMid());
        }
        return false;
    }
}
