package available;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class StorageVC implements Storage {
    private ConcurrentHashMap<Integer, VideoCamera> map = new ConcurrentHashMap<>();

    @Override
    public boolean add(CompletableFuture<VideoCamera> camera) {
        try {
            return map.putIfAbsent(camera.get().getId(), camera.get()) == null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void showAll() {
        for (VideoCamera vc : map.values()) {
            System.out.println(vc);
        }
    }
}
