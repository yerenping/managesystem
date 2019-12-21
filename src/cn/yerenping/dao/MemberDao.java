package cn.yerenping.dao;

import cn.yerenping.pojo.Member;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.dao
 * @version: 1.0
 */
public interface MemberDao {

    /**
     * 查询所有通讯录中的成员
     * @return 所有成员
     */
    public Member[] selectAllMemberDao();

    /**
     * 通过姓名查询成员
     *
     * @param name 姓名
     * @return 单个成员
     */
    public Member selectByNameDao(String name);


    /**
     * 通过MID查询成员
     * @param mid
     * @return -1表示没有查到，其实则为查询，数值为数组下标
     */
    public int selectByMidDao(int mid);

    /**
     * 增加通讯录中成员
     * @param member
     * @return
     */
    public boolean insertMemberDao(Member member);

    /**
     * 修改成员信息
     * @param member
     * @return
     */
    public boolean updateByMemberDao(Member member);

    /**
     * 通过编号删除
     * @return
     */
    public boolean deleteByMidDao(int mid);

    /**
     * 通过姓名删除
     * @param name
     * @return
     */
    public boolean deleteByNameDao(String name);


}
