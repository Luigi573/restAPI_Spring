package mx.uv.fca.restAPI.repository;

import mx.uv.fca.restAPI.model.StaffMember;
import mx.uv.fca.restAPI.model.StaffTypes;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<StaffMember, ObjectId> {
    List<StaffMember> findByType(StaffTypes type);
}
