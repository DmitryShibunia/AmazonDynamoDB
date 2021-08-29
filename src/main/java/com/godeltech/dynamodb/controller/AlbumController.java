package com.godeltech.dynamodb.controller;

import com.godeltech.dynamodb.domain.Album;
import com.godeltech.dynamodb.domain.AlbumId;
import com.godeltech.dynamodb.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumRepository repository;


    @GetMapping("/dynamodb/albums")
    public List<Album> getAllAlbums() {
        return IteratorUtils.toList(repository.findAll().iterator());
    }

    @GetMapping("/dynamodb/albums/song/{song}")
    public List<Album> getAlbumBySong(@PathVariable String song) {
        return repository.findAllBySong(song);
    }

    @GetMapping("/dynamodb/albums/")
    public List<Album> getAllAlbumsByArtist(@PathVariable String artist) {
        return repository.findAllByArtist(artist);
    }

    @PostMapping("/dynamodb/albums/")
    public Album saveAlbum(@RequestBody Album album) {
        return repository.save(album);
    }

    @PutMapping("/dynamodb/albums/")
    public Album updateAlbum(@RequestBody Album album, @RequestParam String id, @RequestParam String name) {
//        var albumId = AlbumId.builder().id(id).name(name).build();
        album.setId(id);
        album.setName(name);
        return repository.save(album);
    }

    @DeleteMapping("/dynamodb/albums/")
    public void deleteAlbum(@RequestParam String id, @RequestParam String name) {
        var albumId = AlbumId.builder().id(id).name(name).build();
        repository.deleteById(albumId);
    }

}
