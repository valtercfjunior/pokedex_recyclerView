package com.vcfj.pokedex.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vcfj.pokedex.R
import com.vcfj.pokedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) {
            with(itemView) {
                val img_pokemon = findViewById<ImageView>(R.id.img_pokemon)
                val txt_number = findViewById<TextView>(R.id.txt_number)
                val txt_name = findViewById<TextView>(R.id.txt_name)
                val txt_type_1 = findViewById<TextView>(R.id.txt_type_1)
                val txt_type_2 = findViewById<TextView>(R.id.txt_type_2)


                item?.let {

                    Glide.with(itemView.context).load(it.imageUrl).into(img_pokemon)

                    txt_number.text = "Nº ${item.formattedNumber}"
                    txt_name.text = item.formattedName
                    txt_type_1.text = item.types[0].name.capitalize()
                    when(item.types[0].name) {
                        "fire" -> txt_type_1.setBackgroundColor(Color.parseColor("#FD7D24"))
                        "water" -> txt_type_1.setBackgroundColor(Color.parseColor("#4592C4"))
                        "grass" -> txt_type_1.setBackgroundColor(Color.parseColor("#9BCC50"))
                        "electric" -> txt_type_1.setBackgroundColor(Color.parseColor("#EED535"))
                        "rock" -> txt_type_1.setBackgroundColor(Color.parseColor("#A38C21"))
                        "bug" -> txt_type_1.setBackgroundColor(Color.parseColor("#729F3F"))
                        "flying" -> txt_type_1.setBackgroundColor(Color.parseColor("#3DC7EF"))
                        "ice" -> txt_type_1.setBackgroundColor(Color.parseColor("#51C4E7"))
                        "poison" -> txt_type_1.setBackgroundColor(Color.parseColor("#B97FC9"))
                        "psychic" -> txt_type_1.setBackgroundColor(Color.parseColor("#F366B9"))
                        "normal" -> txt_type_1.setBackgroundColor(Color.parseColor("#A4ACAF"))

                    }


                    if (item.types.size > 1) {
                        txt_type_2.visibility = View.VISIBLE
                        txt_type_2.text = item.types[1].name.capitalize()
                        when(item.types[1].name) {
                            "fire" -> txt_type_2.setBackgroundColor(Color.parseColor("#FD7D24"))
                            "water" -> txt_type_2.setBackgroundColor(Color.parseColor("#4592C4"))
                            "grass" -> txt_type_2.setBackgroundColor(Color.parseColor("#9BCC50"))
                            "electric" -> txt_type_2.setBackgroundColor(Color.parseColor("#EED535"))
                            "ground" -> txt_type_2.setBackgroundColor(Color.parseColor("#A38C21"))
                            "bug" -> txt_type_2.setBackgroundColor(Color.parseColor("#729F3F"))
                            "flying" -> txt_type_2.setBackgroundColor(Color.parseColor("#3DC7EF"))
                            "ice" -> txt_type_2.setBackgroundColor(Color.parseColor("#51C4E7"))
                            "poison" -> txt_type_2.setBackgroundColor(Color.parseColor("#B97FC9"))
                            "psychic" -> txt_type_2.setBackgroundColor(Color.parseColor("#F366B9"))
                            "normal" -> txt_type_2.setBackgroundColor(Color.parseColor("#A4ACAF"))

                        }

                    } else {
                        txt_type_2.visibility = View.GONE
                    }
                }
            }
        }
    }
}