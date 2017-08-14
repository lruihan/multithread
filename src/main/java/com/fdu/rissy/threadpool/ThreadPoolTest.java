package main.java.com.fdu.rissy.threadpool;

/**
 * Created by lruihan on 4/22/17.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(7);
        for(int i = 0; i < 10; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}
