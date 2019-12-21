package cn.yerenping.utils;

import java.io.*;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: yerenping
 * @version: 1.0
 */
public class ObjectRWUtil {

    /**
     * 将对象读取到文件
     *
     * @param obj      对象
     * @param filePath 文件路径
     * @param fileName 文件名
     */
    public static void writeObject(Object obj, String filePath, String fileName) {
        ObjectOutputStream oos = null;
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符  防止跨平台出现路径问题
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        //文件夹不存在则新建
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
     * 从文件读取对象信息
     * @param filePath
     * @param fileName
     * @return
     */
    public static Object readObject(String filePath, String fileName) {

        ObjectInputStream ois = null;
        Object obj = null;
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符  防止跨平台出现路径问题
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
