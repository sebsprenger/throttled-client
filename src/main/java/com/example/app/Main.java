package com.example.app;

import com.google.common.util.concurrent.RateLimiter;

public class Main {

    public static void main(String[] args) {
        /* Still in BETA state
         * Guava documentation states:
         *
         * <p>It is generally safe for <i>applications</i> to depend on beta APIs, at
         * the cost of some extra work during upgrades. However it is generally
         * inadvisable for <i>libraries</i> (which get included on users' CLASSPATHs,
         * outside the library developers' control) to do so.
         *
         * So beware ;-)
         * */
        RateLimiter rateLimiter = RateLimiter.create(10.0); // rate is "10 permits per second"

        for (int i = 0; i < 99; i++) {
            double slept = rateLimiter.acquire();
            System.out.println("Hello World " + i + " " + slept);
        }

    }
}
