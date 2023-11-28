package com.vcfj.pokedex.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vcfj.pokedex.R


class PokemonDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_details, container, false)

        val txt_details_name = view.findViewById<TextView>(R.id.txt_details_name)
        val txt_details_height = view.findViewById<TextView>(R.id.txt_details_height)
        val txt_details_weight = view.findViewById<TextView>(R.id.txt_details_weight)
        val txt_details_number = view.findViewById<TextView>(R.id.txt_details_number)
        val img_pokemon = view.findViewById<ImageView>(R.id.img_pokemon)
        val txt_type_detail_1 = view.findViewById<TextView>(R.id.txt_type_detail_1)
        val txt_type_detail_2 = view.findViewById<TextView>(R.id.txt_type_detail_2)
        val txt_details_abilitie_1 = view.findViewById<TextView>(R.id.txt_details_abilitie_1)
        val txt_details_abilitie_2 = view.findViewById<TextView>(R.id.txt_details_abilitie_2)
        val txt_details_abilitie_3 = view.findViewById<TextView>(R.id.txt_details_abilitie_3)
        val stats_txt_hp = view.findViewById<TextView>(R.id.stats_txt_hp)
        val stats_txt_attack = view.findViewById<TextView>(R.id.stats_txt_attack)
        val stats_txt_defense = view.findViewById<TextView>(R.id.stats_txt_defense)
        val stats_txt_special_attack = view.findViewById<TextView>(R.id.stats_txt_special_attack)
        val stats_txt_speed = view.findViewById<TextView>(R.id.stats_txt_speed)


        arguments?.getIntegerArrayList("stats")?.let {Log.d("STAT", it[0].toString())}







        Glide.with(view.context).load(arguments?.getString("imageUrl")).into(img_pokemon)

        txt_details_name.setText(arguments?.getString("name"))
        txt_details_height.setText(arguments?.getString("height"))
        txt_details_weight.setText(arguments?.getString("weight"))
        txt_details_number.setText("Nº ${arguments?.getString("number")}")
        stats_txt_hp.setText(arguments?.getIntegerArrayList("stats")?.get(0)?.toString())
        stats_txt_attack.setText(arguments?.getIntegerArrayList("stats")?.get(1)?.toString())
        stats_txt_defense.setText(arguments?.getIntegerArrayList("stats")?.get(2)?.toString())
        stats_txt_special_attack.setText(arguments?.getIntegerArrayList("stats")?.get(3)?.toString())
        stats_txt_speed.setText(arguments?.getIntegerArrayList("stats")?.get(5)?.toString())

        txt_details_abilitie_1.setText(
            "- ${
                arguments?.getStringArrayList("abilities")?.get(0)?.capitalize()
            }"
        )



        txt_details_abilitie_2.visibility = View.GONE
        txt_details_abilitie_3.visibility = View.GONE

        if (arguments?.getStringArrayList("abilities")?.size!! > 1) {
            txt_details_abilitie_2.visibility = View.VISIBLE
            txt_details_abilitie_2.setText(
                "- ${
                    arguments?.getStringArrayList("abilities")?.get(1)?.capitalize()
                }"
            )
        }
        if (arguments?.getStringArrayList("abilities")?.size!! > 2) {
            txt_details_abilitie_3.visibility = View.VISIBLE
            txt_details_abilitie_3.setText(
                "- ${
                    arguments?.getStringArrayList("abilities")?.get(2)?.capitalize()
                }"
            )
        }








        txt_type_detail_2.visibility = View.GONE



        txt_type_detail_1.setText(
            arguments?.getStringArrayList("types")?.get(0)?.capitalize() ?: ""
        )
        when (arguments?.getStringArrayList("types")?.get(0)) {
            "fire" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#FD7D24"))
            "water" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#4592C4"))
            "grass" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#9BCC50"))
            "electric" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#EED535"))
            "rock" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#A38C21"))
            "bug" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#729F3F"))
            "flying" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#3DC7EF"))
            "ice" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#51C4E7"))
            "poison" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#B97FC9"))
            "psychic" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#F366B9"))
            "normal" -> txt_type_detail_1.setBackgroundColor(Color.parseColor("#A4ACAF"))

        }

        if (arguments?.getStringArrayList("types")?.size!! > 1) {
            txt_type_detail_2.visibility = View.VISIBLE
            txt_type_detail_2.setText(
                arguments?.getStringArrayList("types")?.get(1)?.capitalize() ?: ""
            )
            when (arguments?.getStringArrayList("types")?.get(1)) {
                "fire" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#FD7D24"))
                "water" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#4592C4"))
                "grass" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#9BCC50"))
                "electric" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#EED535"))
                "rock" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#A38C21"))
                "bug" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#729F3F"))
                "flying" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#3DC7EF"))
                "ice" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#51C4E7"))
                "poison" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#B97FC9"))
                "psychic" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#F366B9"))
                "normal" -> txt_type_detail_2.setBackgroundColor(Color.parseColor("#A4ACAF"))

            }

        }





        return view


    }


}