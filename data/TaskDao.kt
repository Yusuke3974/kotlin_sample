@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY isDone ASC, priority DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)
}