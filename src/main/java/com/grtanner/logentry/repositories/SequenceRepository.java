package com.grtanner.logentry.repositories;

import com.grtanner.logentry.domain.Sequence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SequenceRepository extends CrudRepository<Sequence, List<String>> {

    @Query(value = "select count(*) count, sequence, source\n" +
            "    from(\n" +
            "        select source, ip_addr, CONCAT_WS(' --> ', LEAD(source) OVER(ORDER BY timestamp ASC), source, LAG(source) OVER(ORDER BY timestamp ASC) ) AS sequence,\n" +
            "        from log_entry\n" +
            "        order by sequence asc\n" +
            "     )\n" +
            "    group by sequence\n" +
            "    order by count desc", nativeQuery=true)
    List<Sequence> findAllSequences();
}
