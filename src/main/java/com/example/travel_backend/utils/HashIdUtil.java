package com.example.travel_backend.utils;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HashIdUtil {

    private final Hashids hashIds;

    public HashIdUtil(
            @Value("${hashId.salt}") String salt,
            @Value("${hashId.length}") int length,
            @Value("${hashId.alphabet}") String alphabet
    ) {
        this.hashIds = new Hashids(salt, length, alphabet);
    }

    public String encode(long id) {
        return hashIds.encode(id);
    }
}