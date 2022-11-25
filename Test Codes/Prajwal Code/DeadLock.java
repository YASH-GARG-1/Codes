import java.lang.*;

public class DeadLock {
    public static void main(String[] args) {
        final String res1 = "yash garg";
        final String res2 = "nimal garg";

        Thread t1 = new Thread(){
            public void run()
            {
                synchronized(res1)
                {
                    System.out.println("Thread 1 : Locked resource 1");

                try{Thread.sleep(100);}
                catch(Exception e)
                {

                }

                synchronized(res2)
                {
                    System.out.println("Thread 1 : Locked resource 2");
                }
            }
        }
    };

        Thread t2 = new Thread(){
            public void run()
            {
                synchronized(res2)
                {
                    System.out.println("Thread 2 : Locked resource 2");

                try{Thread.sleep(100);}
                catch(Exception e)
                {

                }

                synchronized(res1)
                {
                    System.out.println("Thread 2 : Locked resource 1");
                }
            }
        }
    };

    t1.start();
    t2.start();
    }
}
