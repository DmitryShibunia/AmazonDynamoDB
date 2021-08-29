package com.godeltech.dynamodb.repository;

import com.godeltech.dynamodb.domain.Album;
import com.godeltech.dynamodb.domain.AlbumId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumCustomRepository {

    List<Album> findAllBySong(String song);

}
