package Lin.Web.DB;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Person {
    public int ID = -1;
    public String password;
    public String name;
    public String sex;
    public String email;
    public String status;
    public String figure;
    public EventName en;
    public String pathname;
    private boolean onlyRead = true;
    private Map<Integer,List<String>> map;
    private List<String> list;
    private Connection conn;
    public AllOperation ap;

    public Person(){
        ap = new AllOperation();
    }
    public Person(EventName en){
        this.en = en;
        ap = new AllOperation();
    }

    public boolean Verify(){
        int cnt = 3;
        while(cnt > 0) {
            cnt--;
            System.out.println("输入您的账号");
            Scanner sc = new Scanner(System.in);
            this.ID = sc.nextInt();
            this.map = ap.Select(en,ID);
            if(map.containsKey(ID)){
                break;
            }
            System.out.println("没有这个账号\n\n");
        }

        if(cnt == 0){
            return false;
        }

        cnt = 3;
        while(cnt > 0) {
            cnt--;
            System.out.println("输入您的密码");
            Scanner sc = new Scanner(System.in);
            this.password = sc.next();
            this.list = map.get(ID);
            if(list.get(2).compareTo(password)==0){
                onlyRead = false;
                return true;
            }
            System.out.println("密码错误\n\n");
        }
        return false;
    }
    public boolean Verify(int ID){
        this.ID = ID;
        this.map = ap.Select(en,ID);
        if(map.containsKey(ID)){
            this.list = map.get(ID);
            return true;
        }
        System.out.println("没有这个账号\n\n");
        return false;
    }
    public boolean Verify(String name){
        this.map = ap.Select(en,name);
        for(int k : map.keySet()){
            this.ID = k;
        }
        if(map.containsKey(this.ID)){
            this.list = map.get(this.ID);
            return true;
        }
        System.out.println("没有这个账号\n\n");
        return false;
    }
    public void Init(){
        ID = Integer.parseInt(list.get(0));
        name = list.get(1);
        if(!onlyRead){
            password = list.get(2);
        }
        email = list.get(3);
        sex = list.get(4);
        status = list.get(5);
        switch (en) {
            case Buyer:
                figure = "买家";
                break;
            case Seller:
                figure = "卖家";
                break;
            default:
                figure = "管理员";
        }
    }

    public void Show(){
        System.out.println("ID :"+ID);
        if(!onlyRead){
            System.out.println("密码 :"+password);
        }
        System.out.println("账户名 :"+name);
        System.out.println("性别 :"+ sex);
        System.out.println("邮箱 :"+email);
        System.out.println("身份 :"+figure);

    }
    public void Operate(){
        boolean flag = true;
        while(flag){
            System.out.println("请输入你的操作");
            System.out.println("1.搜买家");
            System.out.println("2.搜卖家");
            System.out.println("3.搜商品");
            System.out.println("4.更改个人信息");
            System.out.println("5.退出");
            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
            boolean _flag = true;
            switch (operation){
                case 1:
                    caseBuyer();
                    break;
                case 2:
                    caseSeller();
                    break;
                case 3:
                    caseProduct();
                    break;
                case 4:
                    break;
                default:
                    flag = false;
            }
        }
    }

    public void caseBuyer(){
        boolean _flag =true;
        int cnt = 3;
        Scanner sc = new Scanner(System.in);
        Buyer buyer = new Buyer(EventName.Buyer);
        while (_flag && cnt > 0) {
            cnt--;
            System.out.println("使用账号或者用户名检索");
            String ch = sc.nextLine();
            String buyInfo = sc.nextLine();
            if (buyInfo.length()>0 && buyInfo.charAt(0) > 47 && buyInfo.charAt(0) < 59) {
                if (!buyer.Verify(Integer.parseInt(buyInfo))) {
                    continue;
                }
            } else {
                if(!buyer.Verify(buyInfo)){
                    continue;
                }
            }
            _flag = false;
        }
        buyer.Init();
        buyer.Show();
    }
    public void caseSeller(){
        Boolean _flag=true;
        int cnt = 3;
        Scanner sc = new Scanner(System.in);
        Seller seller = new Seller(EventName.Seller);
        while (_flag && cnt > 0) {
            cnt--;
            System.out.println("使用账号或者用户名检索");
            String ch = sc.nextLine();
            String buyInfo = sc.nextLine();
            if (buyInfo.length()>0 && buyInfo.charAt(0) > 47 && buyInfo.charAt(0) < 59) {
                if (!seller.Verify(Integer.parseInt(buyInfo))) {
                    continue;
                }
            } else {
                if(!seller.Verify(buyInfo)){
                    continue;
                }
            }
            _flag = false;
        }
        seller.Init();
        seller.Show();
    }
    public void caseProduct(){
        boolean _flag = true;
        int cnt = 3;
        while (_flag && cnt > 0){
            cnt--;
            System.out.println("用商品编号或商品名搜索");
            Scanner scanner = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            //scanner.nextLine();
            sb.append(scanner.nextLine());
            Product product = new Product();
            if(product.selectProduct(sb)){
                product.productInit();
                product.Show();
                _flag = false;
            }
        }
    }

}
