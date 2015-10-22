package com.eric.zmappii.pojo;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by eric on 15/7/4.
 */
public class Heartbeat {
    public static int curValue;
    public static String curState;
    public static int avgValue;
    private static Queue<String> queueTime = new LinkedBlockingDeque<>();
    private static Queue<Integer> queueValue  = new LinkedBlockingDeque<>();

    private static final int QUEUE_LENGTH = 7;

    public static Queue<String> getQueueTime() {
        return queueTime;
    }

    {
        for (int i = 0; i < QUEUE_LENGTH; i++) {
            queueTime.offer("10");
        }
    }

    /**
     * 向时间队列中添加时间值，队列长度为QUEUE_LENGTH
     * 大于QUEUE_LENGTH，则去掉队列第一个元素
     */
    public static void updateQueueTime() {
        queueTime.clear(); // 清空队列
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        // 初始化时间队列
        Date curDate = new Date();
        for (int i = 0; i < QUEUE_LENGTH; i++) {
            Date curTime = new Date(curDate.getTime() - 1000 * (QUEUE_LENGTH - i));
            queueTime.offer(df.format(curTime));
        }
    }

    /**
     * 向缓存数据队列中添加数值
     * @param d
     */
    public static void addIntoValueQueue(Integer d) {
        queueValue.offer(d);
        if (queueTime.size() >= 10) {
            queueValue.remove();
        }
    }

    /**
     * 返回缓存数值队列
     * @return
     */
    public static int getValueQueueSize() {
        return queueValue.size();
    }

    /**
     * 返回缓存数据队列
     * @return
     */
    public static Queue<Integer> getQueueValue() {
        return queueValue;
    }
}
