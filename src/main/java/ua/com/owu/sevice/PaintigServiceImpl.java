package ua.com.owu.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.PaintingRepository;
import ua.com.owu.entity.Painting;

import java.util.List;

/**
 * Created by дмитро on 29.03.2018.
 */
@Service
public class PaintigServiceImpl implements PaintingService{
    @Autowired
    private PaintingRepository paintingRepository;

    @Override
    public void addPainting(Painting painting) {
    paintingRepository.saveAndFlush(painting);
    }

    @Override
    public void updatePainting(Painting painting) {
    paintingRepository.saveAndFlush(painting);
    }

    @Override
    public void removePainting(int id) {
    paintingRepository.delete(id);
    }

    @Override
    public Painting getPaintingById(int id) {
        return paintingRepository.findById(id);

    }

    @Override
    public List<Painting> listPaintings() {
        return paintingRepository.findAll();
    }
}
