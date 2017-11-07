package unit_two;

/**
* @Description: 设计一个类，我们只能生成该类的一个实例
* @param:
* @return:
*/

//单线程下
class Singleton1{
    //构造方法设为private
    private Singleton1(){}
    private static Singleton1 instance = null;
    public static Singleton1 Instance(){
        if(instance ==null){
            instance = new Singleton1();
            return instance;
        }
        else return null;

    }

}

//多线程下，加锁
class Singleton2{
    //私有化构造方法
    private Singleton2(){}

    private static Singleton2 instance = null;
    public static Singleton2 Instance(){
        //两次判断，避免已创建的重复加锁
        if(instance ==null){
            //同步块
            synchronized(instance){
                if(instance ==null){
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
}

//优化解法,静态构造函数特性，确保只创建一个实例
class Singleton3{
    private Singleton3(){}
    double time = (double) System.currentTimeMillis()/1000;

    //静态构造函数只能调用一次
    private static Singleton3 instance = new Singleton3();
    public static Singleton3 Instance(){
        return instance;
    }
}

//测试
public class Solution_02 {

    public static void main(String args[]){
        Singleton1 singleton1 = Singleton1.Instance();

        Singleton3 singleton3 = Singleton3.Instance();

        Singleton3 singleton31 = Singleton3.Instance();

        System.out.println(singleton3.time);
        System.out.println(singleton31.time);

    }
}
