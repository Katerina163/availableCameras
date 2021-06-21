package available;

public class VideoCamera {
    private int id;
    private StatusVideo urlType;
    private String videoUrl;
    private String value;
    private int ttl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusVideo getUrlType() {
        return urlType;
    }

    public void setUrlType(StatusVideo urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "availableCameras.VideoCamera{" + "id=" + id
                + ", urlType=" + urlType
                + ", videoUrl='" + videoUrl + '\''
                + ", value='" + value + '\''
                + ", ttl=" + ttl + '}';
    }
}
