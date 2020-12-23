package ch.hsr.geohash;

import org.junit.jupiter.api.Test;

public class GeoHashTest {

    @Test
    void withCharacterPrecision() {
        GeoHash geoHash = GeoHash.withCharacterPrecision(39.9125, 116.40685612, 12);
        System.out.println(geoHash);
    }

    @Test
    void getAdjacent() {
        GeoHash geoHash = GeoHash.withCharacterPrecision(39.9125, 116.40685612, 12);
        System.out.println(geoHash);
        for (GeoHash hash : geoHash.getAdjacent()) {
            System.out.println(hash);
        }
    }
}
