package io.vamsy.repository.interfaces;

import io.vamsy.entity.Alert;
import io.vamsy.entity.Reading;

/**
 * Created by vamsyramk on 6/27/2017.
 */
public interface ReadingRepository {
    Reading ingest(Reading reading);
    Alert create(Alert alert);
}
