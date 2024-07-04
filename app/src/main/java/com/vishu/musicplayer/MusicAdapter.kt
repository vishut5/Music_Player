package com.vishu.musicplayer

import android.app.Activity
import android.media.MediaPlayer
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MusicAdapter(val context : Activity, val dataList : List<Data> ) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Image : ImageView = itemView.findViewById(R.id.MusicImage)
        val Title : TextView = itemView.findViewById(R.id.MusicTitle)
        val play : ImageButton = itemView.findViewById(R.id.MusicPlay)
        val pause : ImageButton = itemView.findViewById(R.id.MusicPause)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.music_list,parent,false)
        return MusicViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currData = dataList[position]
        holder.Title.text = currData.title


        Picasso.get().load(currData.album.cover).into(holder.Image);
        val mediaPlayer = MediaPlayer.create(context,currData.preview.toUri())
        holder.play.setOnClickListener{
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener{
            mediaPlayer.pause()
        }
    }
}