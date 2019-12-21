package cn.yerenping.service.serviceImpl;

import cn.yerenping.dao.MemberDao;
import cn.yerenping.pojo.Member;
import cn.yerenping.service.MemberService;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.service
 * @version: 1.0
 */
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDaoImpl;


    public MemberServiceImpl(MemberDao memberDaoImpl) {
        this.memberDaoImpl = memberDaoImpl;
    }

    @Override
    public String [][] showAllMemberService() {
        Member[]  members= memberDaoImpl.selectAllMemberDao();
        String[][] memberStrs = new String[members.length][];
        //这一步操作，其实就是讲members添加了序号
        for (int i = 0; i < members.length; i++) {
            String mid = String.valueOf(members[i].getMid());
            String name = members[i].getName();
            String sex = String.valueOf(members[i].getSex());
            String phoneCode = members[i].getPhoneCode();
            String addr = members[i].getAddr();
            String email = members[i].getEmail();
            memberStrs[i] = new String[]{mid,name,sex,phoneCode,addr,email};
        }
        for (String[] strings : memberStrs) {
			for (String string : strings) {
				System.out.println(string);
			}
		}
        
        return memberStrs;
    }

    @Override
    public Member showMemberByName(String name) {
        Member member = memberDaoImpl.selectByNameDao(name);
        //可能为空
        if (member==null){
            return null;
        }

        return member;
    }


    @Override
    public boolean insertMemberService(Member member) {
        return memberDaoImpl.insertMemberDao(member);
    }

    @Override
    public boolean updateByMemberService(Member member) {
        return memberDaoImpl.updateByMemberDao(member);
    }

    @Override
    public boolean deleteByMidService(int mid) {
        return memberDaoImpl.deleteByMidDao(mid);
    }

    @Override
    public boolean deleteByNameService(String name) {
        return memberDaoImpl.deleteByNameDao(name);
    }
}
