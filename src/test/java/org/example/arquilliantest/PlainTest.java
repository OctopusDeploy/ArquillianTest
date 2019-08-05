package org.example.arquilliantest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PlainTest {
    @Test
    public void plainTest() {
        final EnterpriseJavaBean enterpriseJavaBean = new EnterpriseJavaBean();
        for (int i = 0; i < 10; ++i) {
            enterpriseJavaBean.writeToConsole();
        }
        System.out.println("All Done");
    }

    @Test
    public void plainThreadTest() throws InterruptedException {
        final EnterpriseJavaBean enterpriseJavaBean = new EnterpriseJavaBean();

        try {
            final ExecutorService executor = Executors.newFixedThreadPool(10);

            final List<Callable<Void>> tasks = new ArrayList<>();
            for (int i = 0; i < 10; ++i) {
                executor.submit(() -> {
                    enterpriseJavaBean.writeToConsole();
                    return null;
                });
            }

            System.out.println("All Done");
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            // ignored
        }
    }
}
