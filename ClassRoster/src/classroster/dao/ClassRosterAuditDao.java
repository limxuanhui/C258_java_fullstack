package classroster.dao;
/* Created by limxuanhui on 4/7/22 */

public interface ClassRosterAuditDao {

    void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
