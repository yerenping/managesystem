package cn.yerenping.utils;

import java.io.*;

/**
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: yerenping
 * @version: 1.0
 */
public class ObjectRWUtil {

    /**
     * �������ȡ���ļ�
     *
     * @param obj      ����
     * @param filePath �ļ�·��
     * @param fileName �ļ���
     */
    public static void writeObject(Object obj, String filePath, String fileName) {
        ObjectOutputStream oos = null;
        // ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���  ��ֹ��ƽ̨����·������
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        //�ļ��в��������½�
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(filePath +  fileName)));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * ���ļ���ȡ������Ϣ
     * @param filePath
     * @param fileName
     * @return
     */
    public static Object readObject(String filePath, String fileName) {

        ObjectInputStream ois = null;
        Object obj = null;
        // ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���  ��ֹ��ƽ̨����·������
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(filePath+fileName)));
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}
