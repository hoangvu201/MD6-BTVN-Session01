package ra.btvn05.service;

import org.springframework.stereotype.Service;
import ra.btvn05.entity.Tasks;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final List<Tasks> tasks = new ArrayList<>();
    private long couter = 1;

    @Override
    public List<Tasks> getTasks() {
        return tasks;
    }

    @Override
    public Tasks insertTask(Tasks task) {
        task.setId(couter++);
        if (task.getStatus() == null) {
            task.setStatus("Pending");
        }
        tasks.add(task);
        return task;
    }
}
