package com.reborn.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Test {

    private final int testInt;
    private final String testString;
    private final StringProperty lastName;
    //StringProperty很神奇，被final修饰还可以有setter方法

    public Test(){
        this.testInt = 1;
        this.testString = "nothing";
        this.lastName = new SimpleStringProperty("lastName");
    }

    public Test(int testInt, String testString, String lastName) {
        this.testInt = testInt;
        this.testString = testString;
        this.lastName = new SimpleStringProperty(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public static boolean matchSymbol(String s) {
        Stack<String> symStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String symbol=s.substring(i, i+1);
            switch (symbol) {
                case "{":
                case "(":
                case "[":
                    symStack.push(symbol);
                    System.out.println(symStack);
                    break;
                case "}":
                    if ("{".equals(symStack.pop())) {
                        System.out.println(symStack);
//                        return false;
                    } else {
//                        symStack.pop();
                        return false;
                    }
                    break;
                case "]":
                    if ("[".equals(symStack.pop())) {
                        System.out.println(symStack);
//                        return false;
                    } else {
//                        symStack.pop();
                        return false;
                    }
                    break;
                case ")":
                    if ("(".equals(symStack.pop())) {
                        System.out.println(symStack);
//                        return false;
                    } else {
//                        symStack.pop();
                        return false;
                    }
                    break;
            }
        }

        if (symStack.isEmpty()) {
            return true;
        }
        return false;
    }

    /*infix to postfix*/
    public static String infix2Postfix(String expr) {
        Stack<String> result = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (int i=0; i < expr.length(); i++) {
            String text = expr.substring(i, i+1);
            switch (text) {
                case "+":
                    break;
            }
        }

        return null;
    }

    public static void main(String[] args) {

//        String cmd = "ping www.baidu.com";
        String cmd = "./Test/v2ray.exe";
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("v2ray"));

        //linux
//      String cmd = "./fork_wait";
//      String cmd = "ls -l";
//      String[] cmd=new String[3];
//      cmd[0]="/bin/sh";
//      cmd[1]="-c";
//      cmd[2]="ls -l ./";
        /*Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader
                    (in, "utf-8"));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null)
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
            //检查命令是否执行失败。
            if (p.waitFor() != 0) {
                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
            inBr.close();
            in.close();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*队列是先进先出*/
        /*Queue<String> qs = new ArrayDeque<>();
        qs.offer("test1");
        qs.offer("test2");
        qs.offer("test3");
        System.out.println(qs);
        System.out.println(qs.poll());
        System.out.println(qs);*/
        /*栈是后进先出的*/
        /*Stack<String> ss = new Stack<>();
        ss.push("test1");
        ss.push("test2");
        ss.push("test3");
        System.out.println(ss);
        System.out.println(ss.pop());
        System.out.println(ss);

        System.out.println(matchSymbol("a{b[c]d}e"));
        System.out.println(matchSymbol("a{b(c]d}e"));
        System.out.println(matchSymbol("a{b(c)"));*/
    }
}
