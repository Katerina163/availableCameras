package available;

import java.util.concurrent.CompletableFuture;

public interface Storage {
    boolean add(CompletableFuture<VideoCamera> camera);

    void showAll();
}
