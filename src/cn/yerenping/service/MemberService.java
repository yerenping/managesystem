package cn.yerenping.service;

import cn.yerenping.pojo.Member;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.dao
 * @version: 1.0
 */
public interface MemberService {

    /**
     * 查询所有通讯录中的成员
     * @return 所有成员
     */
    public String[][] showAllMemberService();

    /**
     * 通过姓名查询成员
     *
     * @param name 姓名
     * @return 单个成员
     */
    public Member showMemberByName(String name);


    /**
     * 增加通讯录中成员
     * @param member
     * @return
     */
    public boolean insertMemberService(Member member);

    /**
     * 修改成员信息
     * @param member
     * @return
     */
    public boolean updateByMemberService(Member member);

    /**
     * 通过编号删除
     * @return
     */
    public boolean deleteByMidService(int mid);

    /**
     * 通过姓名删除
     * @param name
     * @return
     */
    public boolean deleteByNameService(String name);


}
