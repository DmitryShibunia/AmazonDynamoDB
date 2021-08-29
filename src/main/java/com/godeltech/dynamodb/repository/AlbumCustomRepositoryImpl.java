package com.godeltech.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.godeltech.dynamodb.domain.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository {

    private final AmazonDynamoDBClient client;

    @Override
    public List<Album> findAllBySong(String song) {
        ScanResult scan = client.scan(new ScanRequest().withTableName("album")
                .withFilterExpression("contains(song, :val)")
                .withExpressionAttributeValues(Map.of(":val", new AttributeValue(song))));
        return null;
    }
}
