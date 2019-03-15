package com.latewind.practice.concurrent.cache;

import java.util.Map;
import java.util.concurrent.*;

public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A args) throws Exception {
        Future<V> f = cache.get(args);
        // 同样存在问题 ,f都为空，会 都put进去 然后 run重复运行
        if (f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(args);
                }
            };

            FutureTask<V> ft = new FutureTask<V>(callable);
            f = ft;//不明白 赋给f的原因
            cache.put(args, ft);
            ft.run();
        }//end if f == null
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }
    }

    private static Exception launderThrowable(Throwable cause) {
        //抛出
        Exception exception = new Exception("任务执行过程中遇到异常！" + cause);
        //打印
        cause.printStackTrace();
        return exception;
    }

}
