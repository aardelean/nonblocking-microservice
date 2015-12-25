package home.microservice.nonblocking.verticle;

import co.paralleluniverse.fibers.Suspendable;
import io.vertx.core.Future;
import io.vertx.ext.sync.SyncVerticle;

public class BaseVerticle extends SyncVerticle {

    @Override
    @Suspendable
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);

    }

    @Override
    @Suspendable
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }

    @Override
    @Suspendable
    public void start() throws Exception {
        super.start();
    }

    @Override
    @Suspendable
    public void stop() throws Exception {
        super.stop();
    }
}
