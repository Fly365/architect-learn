package cn.learn.architect.interview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ProjectName : interview-learn
 * Description : []
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，
 * 读取共享资源应该可以同时进行。但是，如果有一个线程想去写共享
 * 资源，就不应该再有其他线程可以对该资源进行读或写。
 * 总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * 写操作： 原子+独占，整个过程必须是一个完整的统一体，中间不许被分隔，被打断
 * @author : Fly365
 * CreateDate : 2019年-05月-19日
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i=0; i<=5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp+"", temp);
            },String.valueOf(i)).start();
        }

        for(int i=0; i<=5; i++){
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache {
    /**volatile缓存数据一般使用该关键字修饰*/
    private volatile Map<String,Object> cacheMap = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写入" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheMap.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在读取");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = cacheMap.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成," + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

}
