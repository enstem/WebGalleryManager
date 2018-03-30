package ua.com.owu.entity;

import javax.persistence.*;

/**
 * Created by дмитро on 29.03.2018.
 */
@Entity
@Table(name = "gallery")
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PICTURE_TITLE")
    private String paintingTitle;

    @Column(name = "PICTURE_AUTHOR")
    private String paintingAuthor;

    @Column(name = "PICTURE_PRICE")
    private int paintingPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaintingTitle() {
        return paintingTitle;
    }

    public void setPaintingTitle(String pictureTitle) {
        this.paintingTitle = pictureTitle;
    }

    public String getPaintingAuthor() {
        return paintingAuthor;
    }

    public void setPaintingAuthor(String pictureAuthor) {
        this.paintingAuthor = pictureAuthor;
    }

    public int getPaintingPrice() {
        return paintingPrice;
    }

    public void setPaintingPrice(int picturePrice) {
        this.paintingPrice = picturePrice;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "id=" + id +
                ", paintingTitle='" + paintingTitle + '\'' +
                ", paintingAuthor='" + paintingAuthor + '\'' +
                ", paintingPrice=" + paintingPrice +
                '}';
    }
}
