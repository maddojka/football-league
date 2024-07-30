package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.StandingsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StandingsService {
    final StandingsRepository standingsRepository;

}
