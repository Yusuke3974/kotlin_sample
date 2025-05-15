@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.observeAsState(emptyList())

    LazyColumn {
        items(tasks) { task ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = task.isDone,
                    onCheckedChange = { viewModel.toggleDone(task) }
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(text = task.title, fontWeight = FontWeight.Bold)
                    Text(text = task.description)
                }
            }
        }
    }
}
