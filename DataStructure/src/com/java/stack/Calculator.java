package com.java.stack;

/**
 * @author liusigou
 * @create 2019--12--14--15:31
 */
public class Calculator {
    public static void main(String[] args) {
        String expression="70+2*6-4";
        //定义一个数栈
        ArrayStack arrayStack=new ArrayStack(10);
        //定义一个符号栈
        ArrayStack operStack=new ArrayStack(10);
        //定义相关变量
        int index=0;//用于扫描
        int num1,num2,oper,result=0;//定义两个Number 操作符 结果result
        String num="";
        //将每次扫描到的结果放在ch
        char ch=' ';
        while (true){
            //先扫描
            ch=expression.charAt(index);
            //判断是运算符还是数字
            //如果是运算符
            if(operStack.isOper(ch)){
                //判断当前的栈是否为空
                if(operStack.isEmpty()){
                    //入栈
                    operStack.addNum(ch);
                }
                //如果不为空,判断该运算符与栈内运算符的优先级
                else{
                    //如果当前操作符的优先级小于或者等于栈内运算符的优先级
                    if(operStack.priority(ch)<=operStack.priority(operStack.peak())){
                        //从数栈中取出两个值
                        num1=arrayStack.pop();
                        num2=arrayStack.pop();
                        oper=operStack.pop();
                        //进行运算
                        result=arrayStack.cal(num1,num2,oper);
                        //将结果压入数栈
                        arrayStack.addNum(result);
                        //将操作符入栈
                        operStack.addNum(ch);
                    }
                    //如果当前操作符的优先级大于栈内运算符优先级,就直接入栈
                    else{
                        operStack.addNum(ch);
                    }
                }
            }
            //如果是数直接入栈
            else{
                //数字在ascll的值 48:0 49:1 ...
                //arrayStack.addNum(ch-48);
                /*在处理多位数的时候x需要向expression后面继续扫描,如果是数就继续扫描
                ,如果是符号就入栈,定义一个字符串变量用于拼接
                */
                num+=ch;
                //如果当前就是最后一位,直接入栈
                if(index==expression.length()-1){
                    arrayStack.addNum(Integer.parseInt(num));
                }
                else {
                    //判断下一位是不是数字,如果是数字就继续扫描,如果是操作符就入栈
                    //当下一位是操作符的时候
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //数据入栈
                        arrayStack.addNum(Integer.parseInt(num));
                        //清空num
                        num = "";
                    }
                }
            }
            //让index+1,并判断是否已扫描完
            index++;
            //扫描完了
            if(index>expression.length()-1){
                break;
            }
        }
        //进行下面的逻辑
        //当表达式扫描完毕后,就顺序的从数栈和符号栈中取出数据
        while(true){
            //如果数栈只有一位
            if(arrayStack.getTop()==0){
                System.out.println(arrayStack.pop());
                break;
            }
            //顺序的从数栈和符号栈中取出数据
            num1=arrayStack.pop();
            num2=arrayStack.pop();
            oper=operStack.pop();
            result=operStack.cal(num1,num2,oper);
            arrayStack.addNum(result);
        }
    }
}

class ArrayStack{
    //定义一个数组存储栈
    private int[] stack;
    //定义栈最大长度
    private int maxSize;
    //定义一个指针,来指向栈顶
    private int top=-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }
    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
    //判断栈满
    public boolean isFull(){
        return top==maxSize;
    }
    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //添加数据
    public void addNum(int num){
        //如果满了就不添加数据
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        //不然就top上移一位
        top++;
        stack[top]=num;
        /*
         * 或者写成
         * stack[++top]=num;
         * */
    }
    //取出数据
    public int pop(){
        //如果空就不取数据
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        //取出数据
        int value=stack[top];
        top--;
        return value;
    }
    //取出数据,但不pop
    public int peak(){
        //如果空就不取数据
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        return stack[top];
    }
    //取出全部数据
    public void show(){
        while(true){
            if(isEmpty()){
                return;
            }
            //取出数据
            System.out.println(stack[top]);
            top--;
        }
    }
    //定义符号的优先级
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }
        else if(oper == '+' || oper == '-') {
            return 0;
        }
        else{
            //假定表达式为+-*/
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //操作方法
    public int cal(int num1,int num2,int oper){
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
       return result;
    }

}


