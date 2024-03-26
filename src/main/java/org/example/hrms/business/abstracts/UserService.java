package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.User;
import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

}
