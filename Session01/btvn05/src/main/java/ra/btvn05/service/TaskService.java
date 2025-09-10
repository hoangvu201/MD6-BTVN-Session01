package ra.btvn05.service;

import ra.btvn05.entity.Tasks;

import java.util.List;

public interface TaskService {
    List<Tasks> getTasks();
    Tasks insertTask(Tasks tasks);
}
