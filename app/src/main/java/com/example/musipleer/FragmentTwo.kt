package com.example.musipleer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentTwo : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var songAdapter: SongAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_layout_two, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        // Создаем список песен (заголовки, исполнители и т.д.)
        val songList = // ваш список песен

            songAdapter = SongAdapter(songList) { position ->
                // Обработка нажатия на элемент списка
                val intent = Intent(activity, SecondActivity::class.java)
                // Добавьте дополнительные данные в intent, если необходимо
                startActivity(intent)
            }

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = songAdapter
    }
}
