package cn.yerenping.service;

import cn.yerenping.pojo.Member;

/**
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.dao
 * @version: 1.0
 */
public interface MemberService {

    /**
     * ��ѯ����ͨѶ¼�еĳ�Ա
     * @return ���г�Ա
     */
    public String[][] showAllMemberService();

    /**
     * ͨ��������ѯ��Ա
     *
     * @param name ����
     * @return ������Ա
     */
    public Member showMemberByName(String name);


    /**
     * ����ͨѶ¼�г�Ա
     * @param member
     * @return
     */
    public boolean insertMemberService(Member member);

    /**
     * �޸ĳ�Ա��Ϣ
     * @param member
     * @return
     */
    public boolean updateByMemberService(Member member);

    /**
     * ͨ�����ɾ��
     * @return
     */
    public boolean deleteByMidService(int mid);

    /**
     * ͨ������ɾ��
     * @param name
     * @return
     */
    public boolean deleteByNameService(String name);


}
