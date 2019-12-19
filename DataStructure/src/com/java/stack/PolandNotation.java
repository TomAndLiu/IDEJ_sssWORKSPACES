package com.java.stack;

import java.util.*;
import java.util.Stack;
/**
 * @author liusigou
 * @create 2019--12--15--14:02
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转换成后缀表达式
        //将 1+((2+3)*4)-5 转换成1 2 3 + 4 * + 5 -
        //先把中缀表达式转换成list来遍历
        String expression="1+((2+3)*4)-5";
        //中缀表达式List
        List<String> infixList=getListByInfixExpression(expression);
        System.out.println("中缀表达式转换成list:"+infixList);
        //将中缀表达式的list [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]转换成
        //后缀表达式的list 1 2 3 + 4 * + 5 -
        System.out.println("--------------------------");
        //后缀表达式list
        List<String> suffixList=parseSuffixExpression(infixList);
        System.out.println("中缀表达式转换成后缀表达式:"+suffixList);
        System.out.println("--------------------------------");
        //结果是
        System.out.println("后缀表达式计算:"+calculate(suffixList));
        System.out.println("--------------------------------");
        //先定义逆波兰表达式
        //(3+4)*5-6 逆波兰表达式 3 4 + 5 * 6 -
        /*String suffixExpression="3 4 + 5 * 6 -";*/
        //(30+4)*5-6 逆波兰表达式 30 4 + 5 * 6 -
        /*String suffixExpression="30 4 + 5 * 6 -";*/
        //4*5-8+60+8/2逆波兰表达式 4 5 * 8 - 60 + 8 2 / +
        String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
        //将逆波兰表达式放进ArrayList
        List<String> list = getList(suffixExpression);
        System.out.println(list);
        System.out.println("--------------------");
        System.out.println(calculate(list));
    }
    //将一个逆波兰表达式放进ArrayList中
    public static List<String> getList(String suffixExpression){
        //先将表达式分割成字符数组
        String[] split=suffixExpression.split(" ");
        //创建一个空的List<String>
        List<String> list=new ArrayList<>();
        //将一个个字符添加进list
        for (String s : split) {
            list.add(s);
        }
        return list;
    }
    //计算逆波兰表达式
    public static int calculate(List<String> list){
        //只需要创建一个栈就行了
        Stack<String> stack=new Stack<String>();
        //遍历List
        for (String s : list) {
            //判断如果是操作符
            if(isOper(s)){
                //创建两个数字接收
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                //定义一个结果接收
                int result=0;
                if(s.equals("+")){
                    result=num1+num2;
                }
                else if(s.equals("-")){
                    result=num2-num1;
                }
                else if(s.equals("*")){
                    result=num1*num2;
                }
                else if(s.equals("/")){
                    result=num2/num1;
                }
                else{
                    throw new RuntimeException("操作符不合法");
                }
                //然后把结果入栈
                stack.push(result+"");
            }
            //如果是数字就入栈
            else{
                stack.push(s);
            }
        }
        //遍历完之后,栈中只有一个元素
        return Integer.parseInt(stack.pop());
    }
    //判断字符串是不是操作符
    public static boolean isOper(String s){
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }
    //将中缀表达式放进ArrayList中
    public static List<String> getListByInfixExpression(String infixExpression){
        //创建一个空的list
        List<String> list=new ArrayList<>();
        //定义一个指针去遍历字符串
        int i=0;
        //对多位数的拼接
        String str;
        //定义一个字符来存储每次遍历的字符
        char c;
        while(i<infixExpression.length()){
            //接收字符
            c=infixExpression.charAt(i);
            //如果是一个非数字,就直接添加进list
            if(c<48||c>57){
                list.add(""+c);
                i++;
            }else{
                //拼接多位数
                //现将str变成空字符串
                str="";
                //当i小于字符串长度且是数字的时候,就继续拼接
                while(i<infixExpression.length()&&c>=48&&c<=57){
                    str+=c;
                    //让遍历指针后移
                    i++;
                    //在i<字符串长度的情况下 用字符c接收字符串扫描出来的字符
                    if(i<infixExpression.length()){
                        c=infixExpression.charAt(i);
                    }
                }
                list.add(str);
            }

        }
        return list;
    }
    //将中缀表达式的list转换成后缀表达式
    public static List<String> parseSuffixExpression(List<String> infixExpression){
        //定义一个栈一个列表
        Stack<String> s1=new Stack<String>();//符号栈
        //因为s2只加结果没有弹栈的操作,所以用list接收
        List<String> s2=new ArrayList<String>();//存放中间结果的列表
        //遍历中缀表达式列表
        for (String s : infixExpression) {
            //如果是一个数,入s2栈
            if(s.matches("\\d+")){
                s2.add(s);
            }
            //如果是一个左括号
            else if(s.equals("(")){
                //直接入s1栈
                s1.push(s);
            }
            //如果是一个右括号
            else if(s.equals(")")){
                //定义一个字符串接收s1弹出来的字符串
                String temp="";
                //依次弹出s1栈中的元素,直至遇到左括号
                while(true){
                    temp=s1.pop();
                    //当temp是左括号的时候退出
                    if(temp.equals("(")){
                        break;
                    }
                    //不然依次入s2
                    s2.add(temp);
                    //清空temp
                    temp="";
                }
            }
            //判断字符串与栈内字符串的优先级
            else{
                //当s的优先级小于s1栈顶的优先级,将s1栈顶弹出,入s2
                //当s1栈顶元素的优先级大于s元素的优先级,把s1栈顶弹出进s2
                //由于还不知道优先级,所以用peek观看值而不取出
                while(s1.size()!=0&&Operation.oper(s1.peek())>=Operation.oper(s)){
                    //反复的添加
                    s2.add(s1.pop());
                }
                //当s的优先级大于s1栈顶的优先级,入s1栈
                s1.push(s);
            }
        }
        //扫描完毕后,如果s1栈中还有值,把s1栈中元素依次弹出入s2
        while(s1.size()>0){
            s2.add(s1.pop());
        }
        //返回s2列表
        return s2;
    }
}
//编写一个类,来返回一个运算符对应的优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    //写一个方法判断字符串是哪种运算符
    public static int oper(String s){
        if(s.equals("+")){
            return ADD;
        }else if(s.equals("-")){
            return SUB;
        }
        else if(s.equals("*")){
            return MUL;
        }else if(s.equals("/")){
            return DIV;
        }
        else{
            return -1;
        }
    }
}
