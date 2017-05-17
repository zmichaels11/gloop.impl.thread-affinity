/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longlinkislong.gloop.glimpl.affinity;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.openhft.affinity.AffinityLock;
import static net.openhft.affinity.AffinityStrategies.ANY;
import static net.openhft.affinity.AffinityStrategies.DIFFERENT_SOCKET;
import static net.openhft.affinity.AffinityStrategies.SAME_CORE;
import net.openhft.affinity.AffinityThreadFactory;
import org.junit.Test;

/**
 *
 * @author zmichaels
 */
public class TestThreadAffinity {
    @Test
    public void testAffinity() throws InterruptedException {
        final ExecutorService services = Executors.newFixedThreadPool(4, new AffinityThreadFactory("bg"));
        
        for (int i = 0; i < 12; i++) {
            services.submit(() -> {
                Thread.sleep(300);
                return null;
            });
        }
        
        Thread.sleep(200);
        System.out.printf("The assignment of CPUS is: %n%s", AffinityLock.dumpLocks());
        services.shutdown();
        services.awaitTermination(1, TimeUnit.SECONDS);
    }
}
