package com.example.musipleer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musipleer.FragmentSongBinding
import java.text.FieldPosition


class SongFragment : Fragment() {

    private lateinit var binding: FragmentSongBinding
    private lateinit var playlist: ArrayList<Song>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = PlaylistAdapter(playlist, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {

        playlist = ArrayList<Song>()

        playlist.apply {
            add(Song("1","Angel", "Miyagi","3:21"))
            add(Song("2","Without Me", "Eminem","4:58"))
            add(Song("3","Reminder", "The Weekend","3:51"))
            add(Song("4","The Hills", "The Weekend","3:41"))
            add(Song("5","BSBB", "Jax/Freeman","4:50"))
            add(Song("6","Каганат", "Ulukmanapo","3:13"))
            add(Song("7","Tramplin", "Bakr","3:00"))
            add(Song("8","Кара тору", "Begish","4:12"))
            add(Song("9","Летали", "Ulukmanapo","3:04"))
            add(Song("10","Ночь на кухне", "Anna Asti","4:35"))
        }
    }

    private fun onClick(tittle: String){
        val bundle = Bundle()
        bundle.putString("di", tittle)
        val songInfoFragment = SongInfoFragment()
        songInfoFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, songInfoFragment)
            .addToBackStack(null).commit()
    }
}