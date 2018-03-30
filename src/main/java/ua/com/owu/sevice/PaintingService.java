package ua.com.owu.sevice;

import ua.com.owu.entity.Painting;

import java.util.List;

/**
 * Created by дмитро on 29.03.2018.
 */
public interface PaintingService {
    void addPainting(Painting painting);
    void updatePainting(Painting painting);
    void removePainting(int id);
    Painting getPaintingById(int id);
    List<Painting> listPaintings();
}
