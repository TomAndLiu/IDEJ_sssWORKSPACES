package com.test.stack;



import java.util.*;

/**
 * @author liusigou
 * @create 2019--12--21--18:38
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转换成后缀表达式
        //将 1+((2+3)*4)-5 转换成1 2 3 + 4 * + 5 -
        //先把中缀表达式转换成list来遍历
        String infixExpression="1+((20+3)*4)-5";
        List<String> infixList=infixList(infixExpression);
        System.out.println("中缀表达式列表:"+infixList);
        System.out.println("------------------------");
        List<String> suffixList=infixToSuffix(infixList);
        System.out.println("中缀转换成后缀:"+suffixList);
        System.out.println("-----------------------------");
        System.out.println("计算后缀表达式:"+calculate(suffixList));

        //先定义逆波兰表达式
        //(3+4)*5-6 逆波兰表达式 3 4 + 5 * 6 -
        /*String suffixExpression="3 4 + 5 * 6 -";*/
        //(30+4)*5-6 逆波兰表达式 30 4 + 5 * 6 -
        /*String suffixExpression="30 4 + 5 * 6 -";*/
        //4*5-8+60+8/2逆波兰表达式 4 5 * 8 - 60 + 8 2 / +
        /*String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
        List<String> suffixList=suffixList(suffixExpression);
        System.out.println("后缀表达式列表:"+suffixList);
        System.out.println("-------------------");
        System.out.println(calculate(suffixList));*/
    }
    //把后缀表达式转换成列表
    public static List<String> suffixList(String suffix){

        //定义一个列表
        List<String> list=new ArrayList<>();
        //把字符串转换成字符串数组
        String[] ss=suffix.split(" ");
        //遍历字符串数组
        for (String s : ss) {
            list.add(s);
        }
        return list;
    }
    //计算逆波兰表达式
    public static int calculate(List<String> suffixList){
        //创建一个栈来存储数字和计算结果
        Stack<String> stack=new Stack<String>();
        //定义两个数接收
        int num1,num2=0;
        //定义一个数来接收结果
        int result=0;
        //定义一个字符串接收操作符
        //遍历逆波兰表达式列表
        for (String s : suffixList) {
            //如果是操作符
            if(isOper(s)){
                //取出两个数
                num1=Integer.parseInt(stack.pop());
                num2=Integer.parseInt(stack.pop());
                //进行操作
                switch (s){
                    case "+":
                        result=num1+num2;
                        break;
                    case "-":
                        result=num2-num1;
                        break;
                    case "*":
                        result=num1*num2;
                        break;
                    case "/":
                        result=num2/num1;
                    default:
                        break;
                }
                //结果入栈
                stack.push(result+"");
            }
            else{
                //数字直接入栈
                stack.push(s);
            }
        }
        //遍历完,最后栈中只有一个数,返回这个数
        return Integer.parseInt(stack.pop());
    }
    //判断字符串是不是操作符
    public static boolean isOper(String oper){
        return oper.equals("+")|| oper.equals("-")||oper.equals("*")||oper.equals("/");
    }
    //把中缀表达式转换成列表
    public static List<String> infixList(String infixExpression){
        //定义一个空列表
        List<String> list=new ArrayList<String>();
        //定义遍历下标
        int index=0;
        //拼接多位数
        String str="";
        //定义遍历出来的字符
        char c;
        while(index<infixExpression.length()){
            //接收遍历出来的字符
            c=infixExpression.charAt(index);
            //如果是非数字,直接进列表
            if(c<48||c>57){
                list.add(c+"");
                //遍历下标后移
                index++;
            }
            else{
                //如果是数字,就要考虑到多个多位数,
                str="";
                //由于有括号的存在,不能简单判断不是运算符就拼接
                //判断下一位
                while(index<infixExpression.length()&&c>=48&&c<=57){
                    //拼接
                    str+=c;
                    //下标后移
                    index++;
                    //如果下标++之后还是小于中缀表达式长度,就可以继续接收扫描出来的数据
                    if(index<infixExpression.length()){
                        c=infixExpression.charAt(index);
                    }

                }
                //入列表
                list.add(str);
            }

        }
        return list;
    }
    //把中缀表达式列表转换成后缀表达式列表
    public static List<String> infixToSuffix(List<String> infixList){
        //定义一个栈存储操作符和括号
        Stack<String> s1=new Stack<String>();
        //定义一个空列表,存储完整结果
        List<String> s2=new ArrayList<String>();
        //定义一个接收符号栈遍历
        String temp="";
        //遍历中缀表达式列表
        for (String s : infixList) {
            //如果是数字,直接入列表
            if(s.matches("\\d+")){
                s2.add(s);
            }
            //如果是左括号,直接进符号栈
            else if(s.equals("(")){
                s1.add(s);
            }
            //如果是右括号
            else if(s.equals(")")){
                while(true){
                    //从符号栈中取值放到列表,直至遇到(就结束
                    temp=s1.pop();
                    if(temp.equals("(")){
                        break;
                    }
                    //添加到s2
                    s2.add(temp);
                    //清空变量
                    temp="";
                }
            }
            //判断操作符的优先级
            else{
                //如果操作符栈顶元素优先级高于s,则将栈顶元素弹出进入列表
                while(s1.size()>0&&Operation.priority(s1.peek())>Operation.priority(s)){
                    s2.add(s1.pop());
                }
                //当如果操作符栈顶元素优先级低于s,则将s入栈
                s1.add(s);
            }
        }
        //当扫描完后s1栈还有值,依次将值弹出放进s2
        while(s1.size()>0){
            s2.add(s1.pop());
        }
        return s2;
    }
}
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    static int priority(String oper){
        if(oper.equals("+")){
            return ADD;
        }
        else if(oper.equals("-")){
            return SUB;
        }
        else if(oper.equals("*")){
            return MUL;
        }
        else if(oper.equals("/")){
            return DIV;
        }
        else{
            return -1;
        }
    }

}