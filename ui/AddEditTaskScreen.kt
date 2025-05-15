@Composable
fun AddEditTaskScreen(onSave: (Task) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf(1) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = title, onValueChange = { title = it }, label = { Text("タイトル") })
        TextField(value = description, onValueChange = { description = it }, label = { Text("説明") })
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("優先度")
            Slider(value = priority.toFloat(), onValueChange = { priority = it.toInt() }, valueRange = 1f..5f)
        }
        Button(onClick = {
            val task = Task(title = title, description = description, priority = priority)
            onSave(task)
        }) {
            Text("保存")
        }
    }
}