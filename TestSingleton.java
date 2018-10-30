package wj.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestSingleton {
    public static void main(final String[] args) throws InterruptedException {
        for (int i = 1; i <= 100000; i++) {
            final Thread t1 = new Thread(new ThreadSingleton());
            t1.setName("thread" + i);
            t1.start();
        }
    }

    public static class ThreadSingleton implements Runnable {
        @Override
        public void run() {
            Singleton.getInstance();
        }
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(9);

  /*      for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == 5) {
                list.remove(j);
            }

        }*/

    /*    for (int j =  list.size()-1; j >=0; j--) {
            if (list.get(j) == 5) {
                list.remove(j);
            }
        }*/
        for (Integer integer : list) {
            Integer ss=list.get(5);
            if(integer==5){
                list.remove(ss);
            }
        }
        Iterator<Integer> ii = list.iterator();
        while(ii.hasNext()){
            Integer next = ii.next();
            if(next==5){
               ii.remove();
            }
        }
        System.out.println(list);
    }

}