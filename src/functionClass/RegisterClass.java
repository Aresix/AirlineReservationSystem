package functionClass;

import myClass.Customer;

import java.util.Scanner;

public class RegisterClass {
    private String name="";
    private String IDCard="";
    private String telephone="";
    public Customer Register(){
        java.lang.System.out.println(">>>>>欢迎使用本机票预订系统<<<<<");
        java.lang.System.out.println("亲爱的订票者，你好。首先需要你先完善个人信息。");
        java.lang.System.out.println("请输入你的名字：");
        Scanner scanner = new Scanner(java.lang.System.in);
        this.name = scanner.next();
        java.lang.System.out.println("请输入你的身份证号：");
        scanner = new Scanner(java.lang.System.in);
        this.IDCard = scanner.next();
        java.lang.System.out.println("请输入你的联系方式：");
        scanner = new Scanner(java.lang.System.in);
        this.telephone = scanner.next();
        Customer customer = new Customer(name, IDCard, telephone);
        return customer;
    }
}
