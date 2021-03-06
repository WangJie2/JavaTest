package wj.test;

public class Singleton {
  /*  private static Singleton uniqueInstance;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(uniqueInstance == null){ //#1
            synchronized(Singleton.class){ //#2
                if(uniqueInstance == null){ //#3
                    uniqueInstance = new Singleton(); //#4
                    System.out.println(Thread.currentThread().getName() + ": uniqueInstance is initalized..."); //#5.1
                } else {
                    System.out.println(Thread.currentThread().getName() + ": uniqueInstance is not null now..."); //#5.2
                }
            }
        }
        return uniqueInstance;
    }*/
  private static class LazyHolder {
      private static final Singleton INSTANCE = new Singleton();
      static{
          System.out.println("ffff");
      }
  }
    private Singleton (){
        System.out.println("初始化");
    }
    public static Singleton getInstance() {
        System.out.println("获取");
        return LazyHolder.INSTANCE;
    }
}