package com.test.stack;

/**
 * @author liusigou
 * @create 2019--12--21--13:50
 */
public class Calculator {
    public static void main(String[] args) {
        String expression="70+2*6-4";
        //定义一个数栈
        MyStack arrayStack=new MyStack(10);
        //定义一个符号栈
        MyStack operStack=new MyStack(10);
        //定义一个下标来扫描字符串
        int index=0;
        //定义一个字符来接收扫描出来的字符
        char ch=' ';
        //定义两个来运算的数
        int num1,num2=0;
        //定义一个字符接收操作符
        char oper=' ';
        //用一个字符串拼接多位数
        String num="";
        //定义一个数来接收结果
        int result=0;
        //扫描字符串
        while(true){
            //接收扫描出来的字符
            ch=expression.charAt(index);
            //如果是操作符
            if(isOper(ch)){
                //如果操作符栈是空的
                if(operStack.isEmpty()){
                    //入栈
                    operStack.push(ch);
                }
                else{
                    //判断操作符的优先级
                    //如果操作符栈栈顶优先级高于准备添加进来的栈,就把符号栈栈顶弹出,数栈也弹出两个数字进行运算
                    if(priority((char)(operStack.peak()))>=priority(ch)){
                        //从数栈取出两个数
                        num1=Integer.parseInt(arrayStack.pop().toString());
                        num2=Integer.parseInt(arrayStack.pop().toString());
                        //从操作符栈中取出操作符
                        oper=(char)operStack.pop();
                        //进行操作
                        result=cal(num1,num2,oper);
                        //入栈
                        arrayStack.push(result);
                        //将操作符压入符栈
                        operStack.push(ch);
                    }
                    else{
                        operStack.push(ch);
                    }
                }
            }
            //如果是数字
            else{
                num+=ch;
                //判断当前是不是最后一位
                if(index==expression.length()-1){
                    arrayStack.push(Integer.parseInt(num));
                }
                //判断下一位是不是操作符,如果是,则直接入栈,如果不是,则继续
                else{
					if(isOper(expression.charAt(index+1))){
                        //直接入栈
                        arrayStack.push(Integer.parseInt(num));
                        //清空num
                        num="";
                    }
				}
            }
            //扫描完一个字符之后
            index++;
            //如果扫描完了
            if(index>expression.length()-1){
                break;
            }
        }
        //当扫描完之后
        while(true){
            if(arrayStack.getTop()==0){
                //说明只有最后一位了
                System.out.println(Integer.parseInt(arrayStack.pop().toString()));
				break;
            }
            //取出两个数
            //从数栈取出两个数
            num1=Integer.parseInt(arrayStack.pop().toString());
            num2=Integer.parseInt(arrayStack.pop().toString());
            //从操作符栈中取出操作符
            oper=(char)operStack.pop();
            //进行操作
            result=cal(num1,num2,oper);
            //放进数栈
            arrayStack.push(result);
        }
    }
    //判断是否是操作符
    public static boolean isOper(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
    //判断操作符优先级
    public static int priority(char c){
        if(c=='+'||c=='-'){
            return 0;
        }
        else if(c=='*'||c=='/'){
            return 1;
        }
        else{
            return -1;
        }
    }
    //两个数进行操作
    public static int cal(int num1,int num2,int oper){
        if(oper=='+'){
            return num1+num2;
        }
        else if (oper == '-') {
            return num2-num1;
        }
        else if(oper=='*'){
            return num1*num2;
        }
        else if(oper=='/'){
            return num2/num1;
        }
        else{
            return -1;
        }
    }
}
