package threadPool;

import threadPool.queue.MyQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FixedThreadPool implements ThreadPool {
    private volatile boolean isRunning = true;
    private final int THREADPOOL_CAPACITY;
    private MyQueue<Runnable> myQueue = new MyQueue<Runnable>();

    public FixedThreadPool(int capacity){
        this.THREADPOOL_CAPACITY = capacity;
        //initAllConsumers();
    }

    @Override
    public void start() {
        for(Integer i = 0; i < THREADPOOL_CAPACITY; i++){
            Thread thread = new Thread(new Worker(myQueue, i.toString()));
            thread.start();

        }
    }

    @Override
    public void execute(Runnable runnable) {
        myQueue.enqueue(runnable);
    }

    public class Worker implements Runnable{

        private MyQueue<Runnable> myQueue;
        private String name;

        public Worker(MyQueue<Runnable> myQueue, String name){
            this.myQueue = myQueue;
            this.name = name;
        }


        @Override
        public void run() {
            while(isRunning){
                Runnable r = myQueue.dequeue();
                // print the dequeued item
                System.out.println(" Taken Item by thread name:" + this.name );
                // run it

                r.run();
                System.out.println(" Task completed of thread:" + this.name);
            }
            //System.out.println("!!!!!!!!!!!!!!!");
        }
    }



}
