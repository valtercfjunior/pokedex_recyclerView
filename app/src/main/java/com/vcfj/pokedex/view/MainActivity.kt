package com.vcfj.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vcfj.pokedex.R
import com.vcfj.pokedex.api.PokemonRepository
import com.vcfj.pokedex.domain.Pokemon
import com.vcfj.pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    var pokemons = emptyList<Pokemon?>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        if(pokemons.isEmpty()) {
            Thread(Runnable {
                loadPokemons()
            }).start()
        } else {
            loadRecyclerView()
        }
    }


    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons = it.map { pokemonResult ->

                val numberId = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()
                val pokemonsApiResult = PokemonRepository.getPokemon(numberId)

                pokemonsApiResult?.let {
                    Pokemon(
                        pokemonsApiResult.id,
                        pokemonsApiResult.name,
                        pokemonsApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            }


            recyclerView.post {
                loadRecyclerView()
            }
        }
    }

    private fun loadRecyclerView() {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonAdapter(pokemons)
        }
}