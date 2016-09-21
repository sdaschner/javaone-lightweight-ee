package com.sebastian_daschner.javaone;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import java.util.concurrent.locks.LockSupport;

@Singleton
public class NewCloudNotifier {

    @Asynchronous
    public void onNewCloud(@Observes final Cloud cloud) {
        LockSupport.parkNanos(2_000_000_000);
        System.out.println("cloud created: " + cloud);
    }

}
