package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.StandingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StandingsService {
    private final StandingsRepository standingsRepository;

}
