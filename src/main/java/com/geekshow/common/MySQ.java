package com.geekshow.common;


import java.util.Scanner;

public class MySQ {

    public static void main(String[] args) throws Exception {
        SQType sqType = new SQType();
        DATA4 data4;
        Scanner scanner = new Scanner(System.in);
        SQType stack = sqType.init();
        System.out.println("入队列操作：\n");
        System.out.println("输入年龄、姓名：");
        while (true){
            DATA4 data = new DATA4();
            data.name = scanner.next();
            data.age = scanner.nextInt();
            if (data.name.equals("0")){
                break;
            }
            sqType.put(stack,data);
        }
        System.out.println("出对列操作：请按非0键进行出栈操作");
        String temp = scanner.next();
        while (!temp.equals("0")){
            data4 = sqType.poll(stack);
            System.out.println("出对列数据name："+data4.name+" age："+data4.age);
            temp = scanner.next();
        }
        System.out.println("结束");
        sqType.release(stack);
    }
}

class DATA4 {
    String name;
    int age;
}

class SQType {
    private static final int QUEUE_LEN = 15;
    private DATA4[] data = new DATA4[QUEUE_LEN];
    private int head;
    private int tail;

    /**
     * 初始化队列
     *
     * @return SQType
     */
    public SQType init() {
        SQType q;
        if ((q = new SQType()) != null) {
            q.head = 0;
            q.tail = 0;
            return q;
        } else {
            return null;
        }
    }

    /**
     * 是否为空对列
     *
     * @param q 队列
     * @return 1为真，0为假
     */
    public int isEmpty(SQType q) {
        int temp = 0;
        if (q.head == q.tail) {
            temp = 1;
        }
        return temp;
    }

    /**
     * 是否满队列
     *
     * @param q 对列
     * @return 1为真，0为假
     */
    public int isFull(SQType q) {
        int temp = 0;
        if (q.tail == QUEUE_LEN) {
            temp = 1;
        }
        return temp;
    }

    /**
     * 清空对列
     *
     * @param q 对列
     */
    public void clear(SQType q) {
        q.head = 0;
        q.tail = 0;
    }

    /**
     * 释放对列
     *
     * @param q 对列
     */
    public void release(SQType q) {
        if (q != null) {
            q = null;
        }
    }

    /**
     * 入队列
     *
     * @param q    对列
     * @param data 数据
     * @return 1为真，0为假
     */
    public int put(SQType q, DATA4 data) {
        if (q.tail == QUEUE_LEN) {
            System.out.println("对列已满！操作失败");
            return 0;
        }
        q.data[q.tail++] = data;
        return 1;
    }

    /**
     * 出对列
     *
     * @param q 对列
     * @return 数据
     * @throws Exception
     */
    public DATA4 poll(SQType q) throws Exception {
        if (q.head == q.tail) {
            System.out.println("对列为空！操作失败");
            throw new Exception("queue is empty");
        }
        return q.data[q.head++];
    }

    /**
     * 读取节点内容
     *
     * @param q 对列
     * @return 数据
     */
    public DATA4 peek(SQType q) {
        if (isEmpty(q) == 1) {
            return null;
        }
        return q.data[q.head];
    }

    /**
     * 获取对列长度
     *
     * @param q 对列
     * @return 长度
     */
    public int len(SQType q) {
        return q.tail - q.head;
    }
}