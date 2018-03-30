package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Painting;

/**
 * Created by дмитро on 29.03.2018.
 */
public interface PaintingRepository extends JpaRepository<Painting,Integer>{
    @Query("select p from Painting p where p.id = :id")
    Painting findById(@Param("id")int id);
}
