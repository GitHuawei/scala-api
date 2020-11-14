package com.atguigu.chapter09;

public class JavaException {

    public static void main(String[] args) {

        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
// catch时，需要将范围小的写到前面
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }


}
