import javafx.scene.image.Image;

public class Getmap {

	private static final String BASE_URL = "https://www.mapquestapi.com/staticmap/v5/map";
	private static final String API_KEY = "	0xtaOolAXkJcJwMXGiMRGBh1lnVZViic";

	private double lng;
	private double lat;
	private int zoom;
	private Image cache[];

	public Getmap(double lng, double lat) {
		this.lng = lng;
		this.lat = lat;
		this.zoom = 12;
		this.cache = new Image[20];
		this.cacheImage();
	}

	private Image cacheImage() {
		if (this.cache[this.zoom - 1] == null) {
			var url = String.format("%s?key=%s&center=%f,%f&locations=%f,%f&zoom=%d&size=@2x", BASE_URL, API_KEY,
					this.lat, this.lng, this.lat, this.lng, this.zoom);
			this.cache[this.zoom - 1] = new Image(url);
		}
		return this.cache[this.zoom - 1];
	}

	public Image getImage() {
		return this.cache[this.zoom - 1];
	}

	public Image zoomUp() {
		if (this.zoom >= 20)
			return this.getImage();
		this.zoom++;
		return this.cacheImage();
	}

	public Image zoomDown() {
		if (this.zoom <= 1)
			return this.getImage();
		this.zoom--;
		return this.cacheImage();
	}

}
