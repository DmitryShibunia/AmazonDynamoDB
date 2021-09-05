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

    @GetMapping("/dynamodb/album")
    public Album getAlbumById(@RequestParam String artist, @RequestParam String title) {
        var albumId = AlbumId.builder().artist(artist).title(title).build();
        return repository.findById(albumId).orElse(null);
    }

    @GetMapping("/dynamodb/albums/artists/{artist}")
    public List<Album> getAllAlbumsByArtist(@PathVariable String artist) {
        return repository.findAllByArtist(artist);
    }

    @GetMapping("/dynamodb/albums/genres/{genre}")
    public List<Album> getAllAlbumsByGenre(@PathVariable String genre) {
        return repository.findAllByGenre(genre);
    }

    @PostMapping("/dynamodb/albums")
    public Album saveAlbum(@RequestBody Album album) {
        return repository.save(album);
    }

    @PutMapping("/dynamodb/albums")
    public Album updateAlbum(@RequestBody Album album, @RequestParam String artist, @RequestParam String title) {
        album.setArtist(artist);
        album.setTitle(title);
        return repository.save(album);
    }

    @DeleteMapping("/dynamodb/albums")
    public void deleteAlbum(@RequestParam String artist, @RequestParam String title) {
        var albumId = AlbumId.builder().artist(artist).title(title).build();
        repository.deleteById(albumId);
    }

}
