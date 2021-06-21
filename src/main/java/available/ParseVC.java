package available;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ParseVC implements Parse {
    @Override
    public Storage parse(String str) {
        Storage storage = new StorageVC();
        String[] array = getArray(str);
        for (int i = 2; i < array.length; i = i + 5) {
            storage.add(get(array[i].trim(), array[i + 1].trim(), array[i + 2].trim()));
        }
        return storage;
    }

    private CompletableFuture<VideoCamera> get(String id, String source, String token) {
        return CompletableFuture.supplyAsync(() -> {
            VideoCamera camera = new VideoCamera();
            camera.setId(Integer.parseInt(id.substring(id.indexOf(":") + 2, id.length() - 1)));
            sourceDataUrl(source, camera);
            tokenDataUrl(token, camera);
            return camera;
        });
    }

    private void sourceDataUrl(String str, VideoCamera camera) {
        String[] array = getArray(str.substring(18, str.length() - 2));
        String s = array[1].substring(array[1].indexOf(":") + 3, array[1].length() - 2);
        camera.setUrlType(StatusVideo.valueOf(s));
        s = array[2].substring(array[2].indexOf(":") + 3, array[2].length() - 1);
        camera.setVideoUrl(s);
    }

    private void tokenDataUrl(String str, VideoCamera camera) {
        String[] array = getArray(str.substring(str.indexOf(":") + 3, str.length() - 1));
        String s = array[1].substring(array[1].indexOf(":") + 3, array[1].length() - 2);
        camera.setValue(s);
        s = array[2].substring(array[2].indexOf(":") + 2);
        camera.setTtl(Integer.parseInt(s));
    }

    private String[] getArray(String str) {
        String string = "";
        try {
            Document doc = Jsoup.connect(str).ignoreContentType(true).get();
            string = doc.body().wholeText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.split("\n");
    }
}
