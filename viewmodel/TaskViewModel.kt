class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = TaskDatabase.getDatabase(application).taskDao()
    val tasks: LiveData<List<Task>> = dao.getAllTasks().asLiveData()

    fun addTask(task: Task) = viewModelScope.launch {
        dao.insert(task)
    }

    fun deleteTask(task: Task) = viewModelScope.launch {
        dao.delete(task)
    }

    fun toggleDone(task: Task) = viewModelScope.launch {
        dao.insert(task.copy(isDone = !task.isDone))
    }
}