package facade_functionClass;

import generatorClass.DataGenerator;
import myClass.Airline;
import myClass.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class FollowClass {

    private void printInfo() {
        System.out.println("1.查看我的关注列表");
        System.out.println("2.关注航空公司");
        System.out.println("3.取消关注");
        System.out.println("--------------------------------------------------");
        System.out.println("输入序号（仅数字，如：2），进入相应服务");
    }

    public void FollowCenter(Customer customer) {
        boolean fin = false;
        System.out.println("欢迎来到【我的关注】！你可以：");
        printInfo();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int sceneID = Integer.parseInt(scanner.next());
            switch (sceneID) {
                case 1:
                    showLikeList(customer);
                    break;
                case 2:
                    like(customer);
                    break;
                case 3:
                    unlike(customer);
                    break;
                default:
                    fin = true;
                    break;
            }
            if (fin) break;
            System.out.println("\n还可继续选择如下服务（输入其他字符将返回主界面）：");
            printInfo();
        }
    }

    public void showLikeList(Customer customer) {
        int i = 0;
        ArrayList<Airline> airlines = customer.getAirlinesLike();
        if (airlines == null || airlines.isEmpty()) {
            System.out.println("您还没有喜欢的航空公司，快去关注吧~");
        } else {
            System.out.println("您已关注：\n====================");
            for (Airline a : airlines) {
                System.out.println((++i) + ".\t" + a.getName());
            }
        }
    }

    public void like(Customer customer) {
        ArrayList<Airline> airlines = customer.getAirlinesLike();
        ArrayList<Airline> pending = new ArrayList<Airline>();
        for (Airline a : DataGenerator.airlines) {
            if (!airlines.contains(a)) pending.add(a);
        }
        System.out.println("您还可以关注：\n=====================");
        int i = 0;
        for (Airline a : pending) {
            System.out.println((++i) + ".\t" + a.getName());
        }

        System.out.println("输入对应序号，关注该航空公司！（输入0则退出）");
        Scanner scanner = new Scanner(System.in);
//        boolean fin = false;
        if (!pending.isEmpty()) {
            int sceneID = Integer.parseInt(scanner.next());
            if (sceneID == 0) return;
            Airline a = pending.get(sceneID - 1);
            customer.addAirlinesLike(a);
            a.AttachCustomer(customer);
            System.out.println("您已关注【" + a.getName() + "】！");
            pending.remove(a);
            System.out.println("\n还可继续关注其他航空公司（输入其他字符将返回主界面）：");
        }
        if (pending.isEmpty()) System.out.println("已经关注所有的航空公司啦！");
    }

    public void unlike(Customer customer) {
        ArrayList<Airline> pending = customer.getAirlinesLike();
        showLikeList(customer);
        System.out.println("输入对应序号，取消关注该航空公司。（输入0则退出）");
        Scanner scanner = new Scanner(System.in);
//        boolean fin = false;
        if (!pending.isEmpty()) {
            int sceneID = Integer.parseInt(scanner.next());
            if (sceneID == 0) return;
            Airline a = pending.get(sceneID - 1);
            customer.removeAirlinesLike(a);
            a.DetachCustomer(customer);
            System.out.println("已取消关注【" + a.getName() + "】！");
            pending.remove(a);
            System.out.println("\n还可继续选择取消关注（输入其他字符将返回主界面）：");
        }
        if (pending.isEmpty()) System.out.println("已经没有关注的航空公司啦！");
    }
}
