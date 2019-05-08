package wj.test;

/**
 * Created by WangJie on 2019/2/27.
 */
public class CasTest {
    public static volatile int count=0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            for (int j = 0; j < 100; j++) {
                                count++;
                            }
                        }
                    }
            ).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count="+count);
    }
}
