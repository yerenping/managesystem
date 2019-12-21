package cn.yerenping.dao;

import cn.yerenping.pojo.Member;

/**
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.dao
 * @version: 1.0
 */
public interface MemberDao {

    /**
     * ��ѯ����ͨѶ¼�еĳ�Ա
     * @return ���г�Ա
     */
    public Member[] selectAllMemberDao();

    /**
     * ͨ��������ѯ��Ա
     *
     * @param name ����
     * @return ������Ա
     */
    public Member selectByNameDao(String name);


    /**
     * ͨ��MID��ѯ��Ա
     * @param mid
     * @return -1��ʾû�в鵽����ʵ��Ϊ��ѯ����ֵΪ�����±�
     */
    public int selectByMidDao(int mid);

    /**
     * ����ͨѶ¼�г�Ա
     * @param member
     * @return
     */
    public boolean insertMemberDao(Member member);

    /**
     * �޸ĳ�Ա��Ϣ
     * @param member
     * @return
     */
    public boolean updateByMemberDao(Member member);

    /**
     * ͨ�����ɾ��
     * @return
     */
    public boolean deleteByMidDao(int mid);

    /**
     * ͨ������ɾ��
     * @param name
     * @return
     */
    public boolean deleteByNameDao(String name);


}
