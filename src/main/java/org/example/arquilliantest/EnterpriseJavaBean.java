package org.example.arquilliantest;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import java.util.Random;
import java.util.UUID;

@Singleton
public class EnterpriseJavaBean {
    @Asynchronous
    public void writeToConsole() {
        final UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

        try {
            Thread.sleep(Math.abs(new Random().nextLong()) % 100);
        } catch (InterruptedException e) {
            // ignored
        }

        System.out.println(uuid.toString());
    }
}
