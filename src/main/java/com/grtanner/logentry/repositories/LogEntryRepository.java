package com.grtanner.logentry.repositories;

import com.grtanner.logentry.domain.LogEntry;
import org.springframework.data.repository.CrudRepository;


/**
 * @author glen on 07/14/2021
 */
public interface LogEntryRepository extends CrudRepository<LogEntry, Long> {
}
