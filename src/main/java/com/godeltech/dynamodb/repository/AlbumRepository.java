package com.godeltech.dynamodb.repository;

import com.godeltech.dynamodb.domain.Album;
import com.godeltech.dynamodb.domain.AlbumId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface AlbumRepository extends CrudRepository<Album, AlbumId> {

    List<Album> findAllByArtist(String artist);
    List<Album> findAllByGenre(String genre);

}
