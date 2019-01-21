package thread.cn.com.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExecutorTest {
//    private static int taskSize = 12;//任务数
//    private static int corePoolSize = 3;//核心线程的数量
//    private static int maximumPoolSize = 10;//线程数的最大值
//    private static int queueSize = 7;//可储存的任务数


//    private static int taskSize = 12;//任务数
//    private static int corePoolSize = 3;//核心线程的数量
//    private static int maximumPoolSize = 4;//线程数的最大值
//    private static int queueSize = 5;//可储存的任务数

//    private static int taskSize = 50;//任务数
//    private static int corePoolSize = 3;//核心线程的数量
//    private static int maximumPoolSize = 5;//线程数的最大值
//    private static int queueSize = 4;//可储存的任务数

    private static int taskSize = 10;//任务数
    private static int corePoolSize = 3;//核心线程的数量
    private static int maximumPoolSize = 3;//线程数的最大值


    @Test
    public void addition_isCorrect() {

//        ExecutorService executor =  Executors.newCachedThreadPool();
//        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor executor =
//                new ThreadPoolExecutor(
//                        corePoolSize,
//                        maximumPoolSize,
//                        1,
//                        TimeUnit.SECONDS,
////                        new PriorityBlockingQueue<Runnable>(queueSize)
//                        new SynchronousQueue<Runnable>()
//
//                );
        TestTask task;
        int size = taskSize;
        for (int i = 0; i < size; i++) {
            task = new TestTask();
            try {
                PicassoFutureTask task1 = new PicassoFutureTask(task);
                executor.execute(task1);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        executor.shutdown();
        System.out.println("ssss");

        try {
            Thread.sleep(16500);//模拟开发时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static class TestTask implements Runnable {
        public void run() {
            if (taskSize > 0) {
                try{
                    Thread.sleep(500);//模拟开发时间
//                    synchronized (taskSize) {
//                        System.out.println(Thread.currentThread().getName()
//                                + " 完成一个开发任务，编号为t" + (taskSize--)
//                        );
//                    }
                    saleTicket();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static synchronized void saleTicket() {
        if(taskSize == 8){
//            int s =0/0;
        }

            System.out.println(Thread.currentThread().getName()
                    + " 完成一个开发任务，编号为t" + (taskSize--)
            );

    }
    private static final class PicassoFutureTask extends FutureTask<TestTask>
            implements Comparable<PicassoFutureTask> {
        private final TestTask hunter;

        PicassoFutureTask(TestTask hunter) {
            super(hunter, null);
            this.hunter = hunter;
        }

        @Override
        public int compareTo(PicassoFutureTask other) {

            return 1;
        }
    }
}