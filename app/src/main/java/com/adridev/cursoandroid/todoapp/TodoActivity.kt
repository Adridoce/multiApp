package com.adridev.cursoandroid.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adridev.cursoandroid.R
import com.adridev.cursoandroid.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.FieldPosition

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Business, Personal, Other
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponents()
        initUI()
        setClickListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { updateCategories(it) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun onItemSelected (position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position:Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }

    private fun setClickListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()

            if (currentTask.isNotEmpty()) {

                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_bussines) -> Business
                    getString(R.string.todo_dialog_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }
}